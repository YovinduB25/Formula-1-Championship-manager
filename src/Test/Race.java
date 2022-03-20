package Test;
//UoW - 1837849
//IIT - 20200870

import java.io.Serializable;

public class Race implements Serializable
{
    private RaceDate rDate; //date object from RaceDate
    private int numOfDrivers;   //number of drivers in race
    private String raceDriverName;  //driver name
    private int racePositions;  //placed position in race
    private  String[] driverNames = new String[numOfDrivers];   //Array to store names
    private int[] racePos = new int[getNumOfDrivers()]; //Array to placed position in race

    public Race()
    {  //constructor without parameters
        this.rDate= new RaceDate(0,0,0);
        this.numOfDrivers=0;
        this.raceDriverName="";
        this.racePositions=0;
    }

    public Race(RaceDate rDate, int numOfDrivers, String raceDriverName, int racePositions, String[] driverNames, int[] racePos)
    {   //constructor with parameters
        this.rDate = rDate;
        this.numOfDrivers = numOfDrivers;
        this.raceDriverName = raceDriverName;
        this.racePositions = racePositions;
        this.driverNames=driverNames;
        this.racePos = racePos;
    }


    public RaceDate getrDate() {
        return rDate;
    }

    public void setrDate(RaceDate rDate) {
        this.rDate = rDate;
    }

    public int getNumOfDrivers() {
        return numOfDrivers;
    }

    public void setNumOfDrivers(int numOfDrivers) {
        this.numOfDrivers = numOfDrivers;
    }

    public String getRaceDriverName() {
        return raceDriverName;
    }

    public void setRaceDriverName(String raceDriverName) {
        this.raceDriverName = raceDriverName;
    }

    public int getRacePositions() {
        return racePositions;
    }

    public void setRacePositions(int racePositions) {
        this.racePositions = racePositions;
    }

    public String[] getDriverNames() {
        return driverNames;
    }

    public void setDriverNames(String[] driverNames) {
        this.driverNames = driverNames;
    }

    public int[] getRacePos() {
        return racePos;
    }

    public void setRacePos(int[] racePos) {
        this.racePos = racePos;
    }

    @Override
    public String toString()
    {
        return "Race Date:" + rDate + " Number Of Drivers:" + numOfDrivers;
    }
}
