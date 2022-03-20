package Test;
//UoW - 1837849
//IIT - 20200870

import Test.ChampionshipManager;

import java.io.*;
import java.util.ArrayList;

public class Formula1ChampionshipManager implements ChampionshipManager,Serializable
{

    private static final int numOfDriver = 20;    //I assumed that maximum number of drivers who will participate in F1 championship as 20 drivers
    static ArrayList<Formula1Driver>Formula1DriverArrayList = new ArrayList<>();  //ArrayList to hold Formula 1 Drivers
    static ArrayList<Race>raceArray = new ArrayList<>();    //ArrayList to hold new races

    public Formula1ChampionshipManager(){}

    @Override
    public void addDriver(Formula1Driver addNewDriver)
    { //method to add new driver
        if (Formula1DriverArrayList.size() < numOfDriver)
        {
            Formula1DriverArrayList.add(addNewDriver);
            System.out.println(Formula1DriverArrayList.toString());
        }else
        {
            System.out.println("Drivers are filled to all the teams.\n If you want to add a new driver, Please delete a existing driver.");
        }
    }

    @Override
    public void deleteDriver(String delDriver)
    { //method to delete a driver
        for (int i = 0; i < Formula1DriverArrayList.size(); i++)
        {
            if (Formula1DriverArrayList.get(i).getName().equalsIgnoreCase(delDriver))
            {
                Formula1DriverArrayList.remove(i);
                System.out.println(delDriver +" was successfully removed from F1 championship.");
                break;
            }else
            {
                if (i==(Formula1DriverArrayList.size()-1))
                {   //checking the whether driver existed

                    System.out.println("Drivers name is not here. Please check again!");
                    break;
                }
            }
        }
    }

    @Override
    public void changeDriver(String curDriver, String newDriver)
    { //method to change driver for an existing constructor team
        for (int c = 0; c < Formula1DriverArrayList.size(); c++ )
        {
            if (Formula1DriverArrayList.get(c).getName().equalsIgnoreCase(curDriver))
            {
                Formula1DriverArrayList.get(c).setName(newDriver);  //setting the new name
                System.out.println(Formula1DriverArrayList.get(c).toString());
            }
        }
    }

    @Override
    public void displayStatistics(String disStatDriver)
    {//method to display statistics
        for (int s = 0; s <= 10; s++)
        {  //for loop to for 10 drivers
            if (Formula1DriverArrayList.get(s).getName().equalsIgnoreCase(disStatDriver))
            {
                System.out.println(Formula1DriverArrayList.get(s).toString());
                break;
            }
        }
    }

    @Override
    public void formula1Table()
    {    //method to display
        // F1 Table ->
            // https://www.javatpoint.com/bubble-sort
            // https://www.javatpoint.com/bubble-sort-in-java

        ArrayList<Formula1Driver>Formula1DriverArrayTempList = new ArrayList<>();   //new temporary ArrayList to hold values in the method
        Formula1DriverArrayTempList = Formula1DriverArrayList;
        int t  = Formula1DriverArrayTempList.size();
        Formula1Driver tmp = null; //bubble sort is using to store drivers according to their points
        for (int a = 0; a < t-1; a++)
        {
            for (int b = 0; b < (t-a-1); b++)
            {
                if (Formula1DriverArrayTempList.get(b).getTotalPoints() < Formula1DriverArrayTempList.get(b + 1).getTotalPoints())
                {
                    tmp = Formula1DriverArrayTempList.get(b);
                    Formula1DriverArrayTempList.set(b, Formula1DriverArrayTempList.get(b+1));
                    Formula1DriverArrayTempList.set(b+1, tmp);  //changing positions

                }else if (Formula1DriverArrayTempList.get(b).getTotalPoints() == Formula1DriverArrayTempList.get(b+1).getTotalPoints())
                {  //if points equals
                    if (Formula1DriverArrayTempList.get(b).getFirstPosition() < Formula1DriverArrayTempList.get(b + 1).getFirstPosition())
                    {
                        tmp = Formula1DriverArrayTempList.get(b);
                        Formula1DriverArrayTempList.set(b, Formula1DriverArrayTempList.get(b+1));
                        Formula1DriverArrayTempList.set(b+1, tmp);  //changing positions
                    }
                }
            }
        }
        //Table will be printed in below format
        //The code I referred for below format: https://www.delftstack.com/howto/java/print-a-table-in-java/
        System.out.println("______________________________________________________________________________________________________________");
        System.out.printf("%8s %11s %9s %10s %10s %10s %10s %10s", "| NAME |", " LOCATION |", " TEAM |", " FIRST PLACES |", " SECOND PLACES |", " THIRD PLACES |", " TOTAL POINTS |", " TOTAL RACES |\n");
        System.out.println("______________________________________________________________________________________________________________");
        for (Formula1Driver formula1Driver : Formula1DriverArrayTempList)
        {
            System.out.format("%7s %9s %9s %8s %15s %16s %16s %16s", formula1Driver.getName(), formula1Driver.getLocation(), formula1Driver.getTeam(),
                    formula1Driver.getFirstPosition(), formula1Driver.getSecondPosition(), formula1Driver.getThirdPosition(), formula1Driver.getTotalPoints(), formula1Driver.getTotalRaces());
            System.out.println();
        }
        System.out.println("______________________________________________________________________________________________________________");
    }

    @Override
    public void addRace(String dName,int numDriver, int racePositions) {}

    //I referred and develop  below two methods according to: https://howtodoinjava.com/java/collections/arraylist/serialize-deserialize-arraylist/
    @Override
    public void saveToFile()
    {//method to save to file
        try
        {
            FileOutputStream file1 =new FileOutputStream("F1ChampionshipData.txt"); //Initialising text file to save drivers
            ObjectOutputStream obj1 =new ObjectOutputStream(file1); //Object streaming
            obj1.writeObject(Formula1DriverArrayList);  //Saving Formula1DriverArrayList
            file1.close();
            obj1.close();

            FileOutputStream file2 =new FileOutputStream("F1Race.txt"); //Initialising text file to save races
            ObjectOutputStream obj2 =new ObjectOutputStream(file2); //Object streaming
            obj2.writeObject(raceArray);    //Saving raceArray
            file2.close();
            obj2.close();

        }catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    @Override
    public void readFile()
    { //method to load data from file
        try
        {
            FileInputStream files1 = new FileInputStream("F1ChampionshipData.txt"); //reading text file
            ObjectInputStream objs1 = new ObjectInputStream(files1);
            Formula1DriverArrayList = (ArrayList<Formula1Driver>) objs1.readObject();
            objs1.close();
            files1.close();

            FileInputStream files2 = new FileInputStream("F1Race.txt");
            ObjectInputStream objs2 = new ObjectInputStream(files2);
            raceArray = (ArrayList<Race>) objs2.readObject();
            objs2.close();
            files2.close();

        } catch (FileNotFoundException | ClassNotFoundException e)  //exception for load file
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.println(" Data loaded.");
    }
}