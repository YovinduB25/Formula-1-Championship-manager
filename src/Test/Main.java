package Test;
//UoW - 1837849
//IIT - 20200870

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        String selected = "";   //crated local variable as an empty sting

        while (true)
        {
            if (!(selected.equalsIgnoreCase("Q")))
            { //Until user input "Q" or "q" menu will run
                selected = displayMenu();
                Main menuRun = new Main();  //created a main class object to call non-static menu method
                menuRun.menu(selected);

            } else
            {
                System.out.println("-----------Thank you!-----------" +
                        "\nWhat's behind you doesn't matter." +
                        "\n                  -Enzo Ferrari");
                break;
            }
        }
    }

        //Command Line Interface
        public static String displayMenu ()
        {  //display menu in console
            System.out.println("______________________________________________________________");
            System.out.println(" ******Welcome to The Formula 1 racing car championship******" +
                    "\n Please select the options below" +
                    "\n Enter \"A\" to add new driver" +
                    "\n Enter \"D\" to remove driver" +
                    "\n Enter \"C\" to change driver" +
                    "\n Enter \"V\" to view statistics" +
                    "\n Enter \"T\" to view formula 1 driver table" +
                    "\n Enter \"R\" to add new race" +
                    "\n Enter \"G\" to display GUI" +
                    "\n Enter \"S\" to save to file" +
                    "\n Enter \"L\" to load from file" +
                    "\n Enter \"Q\" to quite the program" +
                    "\n Please select your option");
            System.out.println(" ************************************************************");
            System.out.println("______________________________________________________________");
            System.out.println("Input required: ");

            Scanner sc = new Scanner(System.in);
            return sc.next();
        }

        public void menu (String selected)
        {//When user selects the option, this will call the method
            if (selected.equalsIgnoreCase("A"))
            {
                addDriver();
            } else if (selected.equalsIgnoreCase("D"))
            {
                deleteDriver();
            } else if (selected.equalsIgnoreCase("C"))
            {
                changeDriver();
            } else if (selected.equalsIgnoreCase("V"))
            {
                displayStatistics();
            } else if (selected.equalsIgnoreCase("T"))
            {
                formula1Table();
            } else if (selected.equalsIgnoreCase("R"))
            {
                addRace();
            } else if (selected.equalsIgnoreCase("G"))
            {
                System.out.println("GUI is Loading.........");
                String[] args = new String[0];
                Formula1ChampionshipGUI.main(args);
            }
            else if (selected.equalsIgnoreCase("S"))
            {
                saveToFile();
            } else if (selected.equalsIgnoreCase("L"))
            {
                readFile();
            } else if (selected.equalsIgnoreCase("Q"))
            {
                System.out.print("");
            } else
            {
                System.out.println("Invalid input. Try again!!!");
            }
        }

    //Add new driver when "A" or "a"
        public void addDriver ()
        {//method to add new driver to F1 Championship
            Scanner sc = new Scanner(System.in);
            try
            {//To correct wrong input by user
                Scanner sc1 = new Scanner(System.in);
                System.out.println("Enter a driver name: ");
                String dName = sc1.next();

                for (int a = 0; a < Formula1ChampionshipManager.Formula1DriverArrayList.size(); a++)
                {
                    if (Formula1ChampionshipManager.Formula1DriverArrayList.get(a).getName().equals(dName))
                    {//checking the entered value being already in F1 championship
                        System.out.println("Driver already registered to the Formula 1 Championship");
                        return;
                    }
                }
                Scanner sc2 = new Scanner(System.in);   //created new scanner to get 2 strings. for example "Sri Lanka"
                System.out.println("Enter the driver's location: ");
                String dLocation = sc2.nextLine();
                System.out.println("Enter the driver's team: ");
                String dTeam = sc.next();

                for (int t = 0; t < Formula1ChampionshipManager.Formula1DriverArrayList.size(); t++)
                {
                    if (Formula1ChampionshipManager.Formula1DriverArrayList.get(t).getTeam().equals(dTeam))
                    {//checking the team was already filled with driver
                        System.out.println("Team has a driver already. Enter a different team."); //since one has one driver
                        return;
                    }
                }
                System.out.println("Enter the driver's first positions: ");
                int dFiPositions = sc.nextInt();
                System.out.println("Enter the driver's second positions: ");
                int dSePositions = sc.nextInt();
                System.out.println("Enter the driver's third positions: ");
                int dThPositions = sc.nextInt();
                System.out.println("Enter the driver's total points: ");
                int dPoints = sc.nextInt();
                System.out.println("Enter the driver's total races: ");
                int dToRaces = sc.nextInt();

                Formula1Driver F1Driver = new Formula1Driver(dName, dLocation, dTeam, dFiPositions, dSePositions, dThPositions, dPoints, dToRaces); // created a driver object to store in ArrayList
                Formula1ChampionshipManager f1Drive = new Formula1ChampionshipManager();
                f1Drive.addDriver(F1Driver); //created the driver object

            } catch (Exception e)
            {
                System.out.println("Your input is incorrect!");
            }
        }

        //Delete driver when "D" or "d"
        public void deleteDriver ()
        {//method to delete a driver
            Scanner sc = new Scanner(System.in);

        for (int x = 0; x< Formula1ChampionshipManager.Formula1DriverArrayList.size(); x++)
        {
            System.out.println((Formula1ChampionshipManager.Formula1DriverArrayList.get(x)).toString());
            }
            System.out.println("______________________________________________________________");
            System.out.println("Enter the drivers name to delete from Formula 1 Championship: ");
            String delDriveName = sc.next();

            Formula1ChampionshipManager f1Driver = new Formula1ChampionshipManager();
            f1Driver.deleteDriver(delDriveName);       //deleting driver object
        }

        //Change drive for an existing constructor team when "C" or "c"
        public void changeDriver ()
        {   //method to change driver for an existing constructor team
            Scanner sc = new Scanner(System.in);

            try
            {
                System.out.println("Enter the current driver's name: ");
                String curDriver = sc.next();

                for (int a = 0; a < Formula1ChampionshipManager.Formula1DriverArrayList.size(); a++)
                {
                    if (Formula1ChampionshipManager.Formula1DriverArrayList.get(a).getName().equalsIgnoreCase(curDriver))
                    {
                        System.out.println("Enter the new driver's name: ");
                        String newNameDriver = sc.next();

                        Formula1ChampionshipManager f1Driver = new Formula1ChampionshipManager();
                        f1Driver.changeDriver(curDriver, newNameDriver);
                        break;

                    }else
                    {
                        if (a ==(Formula1ChampionshipManager.Formula1DriverArrayList.size()-1))
                        {//error handling to check whether driver already in the arraylist
                            System.out.println("Current driver's name is not in the F1 Championship. \nPlease try again!!!");
                            break;
                        }
                    }
                }
            }catch (Exception e)
            {
                System.out.println("Your input is incorrect!");
            }
        }

        //Display statistics when "V" or "v"
        public void displayStatistics ()
        {//method to display statistics
            Scanner sc = new Scanner(System.in);
            try
            {
                System.out.println("Enter the name of the driver you want to know the statistic");
                String statDriver = sc.next();

                for (int v = 0; v < Formula1ChampionshipManager.Formula1DriverArrayList.size(); v++)
                {
                    if (Formula1ChampionshipManager.Formula1DriverArrayList.get(v).getName().equalsIgnoreCase(statDriver))
                    {
                        Formula1ChampionshipManager f1Driver = new Formula1ChampionshipManager();
                        f1Driver.displayStatistics(statDriver);
                        break;
                    }else
                    {
                        if (v ==(Formula1ChampionshipManager.Formula1DriverArrayList.size()-1))
                        {//error handling to check whether driver already in the arraylist
                            System.out.println("The name you entered is not in F1 Championship. Please try again");
                            break;
                        }
                    }
                }
            }catch (Exception e)
            {
            System.out.println("Your input is incorrect!");
            }
        }

        //Display Formula 1 table "T" or "t"
        public void formula1Table ()
        {//calling method to display F1 Table
            Formula1ChampionshipManager f1Driver = new Formula1ChampionshipManager();
            f1Driver.formula1Table();   //Calling f1table object
        }

        //Add a new race when "R" or "r"
        public void addRace ()
        { //method to add new race
            Scanner sc = new Scanner(System.in);

            //initialising variable
            int newRacePosition =0;
            String inputtedName = "";
            Race newRace;
            String[] driverNames;
            int[] racePos;

            try
            {
                System.out.println("Please enter the date of the race:- ");
                System.out.print("Year: ");
                int newRaceYear = sc.nextInt();
                System.out.print("Month: ");
                int newRaceMonth = sc.nextInt();

                if (newRaceMonth > 12)
                {//check the input is valid
                    System.out.println("Invalid month. Please enter the correct month!!");
                    return;
                }
                System.out.print("Day: ");
                int newRaceDay = sc.nextInt();

                if (newRaceDay > 31)
                {//check the input is valid
                    System.out.println("Invalid date. Please enter the correct date!!");
                    return;
                }
                RaceDate newRaceDate = new RaceDate(newRaceYear, newRaceMonth, newRaceDay); //newRaceDate object created
                System.out.println("Race date: " + newRaceDate);

                System.out.println("Enter the number of drivers who participated in new race: ");//Getting the number of drivers who participated the race
                int count = sc.nextInt();

                driverNames = new String[count]; //sizing the name array
                racePos = new int[count];   //sizing the position array

                if (count >= 2)
                {//To add race need more than 1 racer

                    for (int a = 0; a <count; a++)
                    {
                        System.out.println("Enter the driver name: ");
                        inputtedName = sc.next();
                        driverNames[a]=inputtedName;

                        for (int i = 0; i < Formula1ChampionshipManager.Formula1DriverArrayList.size()-1; i++)
                        {
                            if (Formula1ChampionshipManager.Formula1DriverArrayList.get(i).getName().equalsIgnoreCase(inputtedName))
                            {//checking the inputted driver existed in the f1 driver table
                                System.out.println("Enter the position of " + inputtedName + " : ");
                                newRacePosition = sc.nextInt();
                                racePos[a] = newRacePosition;

                                Formula1Driver driver = Formula1ChampionshipManager.Formula1DriverArrayList.get(i);
                                addPoints(newRacePosition, driver); //Calling add point method

                                break;
                            }

                            if (i == Formula1ChampionshipManager.Formula1DriverArrayList.size()-1)
                            {//if not printing the below massage
                                System.out.println(inputtedName + " is not existed in F1 Championship");
                                a--;
                            }
                        }
                    }
                    //Adding to the array List
                    newRace = new Race(newRaceDate, count, inputtedName, newRacePosition, driverNames,racePos);
                    Formula1ChampionshipManager.raceArray.add(newRace);

                    System.out.println("Race added!");
                    //Letting know that race were successfully added.
                }else
                {
                    System.out.println("Enter more than 1 racer.");
                }

                for (int s = 0; s < Formula1ChampionshipManager.raceArray.size(); s++)
                {   //displaying added race
                    System.out.println(" ");
                    System.out.println("Race Date: " + Formula1ChampionshipManager.raceArray.get(s).getrDate());
                    System.out.println("Number of Drivers in the Race: " + Formula1ChampionshipManager.raceArray.get(s).getNumOfDrivers());
                }
            } catch (InputMismatchException e)
            {
                System.out.println("Please enter the correct value.");
            }
        }

        public void addPoints(int newRacePosition, Formula1Driver driver)
        {//method to calculate points per position and update the table accordingly
           int [] pointArr = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1}; //Array to hold points for index
           if (newRacePosition == 1)
           {//updating the place value
               driver.setFirstPosition(driver.getFirstPosition() + 1);
           }
           else if (newRacePosition == 2)
           {
               driver.setSecondPosition(driver.getSecondPosition() + 1);
           }
           else if (newRacePosition == 3)
           {
               driver.setThirdPosition(driver.getThirdPosition() + 1);
           }
           driver.setTotalRaces(driver.getTotalRaces() + 1);    //updating the total race
           driver.setTotalPoints(driver.getTotalPoints() + pointArr[newRacePosition-1]);    //updating the total points
        }

        //Save data when "S" or "s"
        public void saveToFile ()
        { //method to save to file
            Formula1ChampionshipManager f1Driver = new Formula1ChampionshipManager();
            f1Driver.saveToFile();

            System.out.println("Data has saved to the file.");
        }

        //Load data when "L" or "l"
        public void readFile ()
        {   //method to load data from file
            Formula1ChampionshipManager f1Driver = new Formula1ChampionshipManager();
            f1Driver.readFile();

            System.out.println("Loaded data. Please check the file.");
            System.out.println(" " + "\n Driver Details: ");    //displaying saved drivers
            for (int r = 0; r < Formula1ChampionshipManager.Formula1DriverArrayList.size(); r++)
            {
                System.out.println(Formula1ChampionshipManager.Formula1DriverArrayList.get(r).toString());
            }
            System.out.println(" " + "\n Race Details: ");  //displaying saved races
            for (int k = 0; k < Formula1ChampionshipManager.raceArray.size(); k++)
            {
                System.out.println(Formula1ChampionshipManager.raceArray.get(k).toString());
            }
        }
    }
