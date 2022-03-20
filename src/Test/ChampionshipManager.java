package Test;
//UoW - 1837849
//IIT - 20200870

public interface ChampionshipManager
{

    void addDriver(Formula1Driver addNewDriver);    //Add new driver
    void deleteDriver(String delDriver);    //Removing existing driver
    void changeDriver(String curDriver, String newDriver);    //Changing a driver from existing team
    void displayStatistics(String disStatDriver);   //Display statistics table
    void formula1Table();   //Display formula 1 table
    void addRace(String dName, int numDriver, int racePosition); //Add new race
    void saveToFile();  //Store data to the file
    void readFile();    //Load data from existing file
}