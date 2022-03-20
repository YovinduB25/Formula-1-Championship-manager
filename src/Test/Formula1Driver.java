package Test;
//UoW - 1837849
//IIT - 20200870

import java.io.Serializable;

//for one driver
public class Formula1Driver extends Driver implements Serializable
{
    private int firstPosition;  //1st pace
    private int secondPosition; //2nd place
    private int thirdPosition;  //3rd place
    private int totalPoints;    //total points
    private int totalRaces; //total races

    public Formula1Driver(){}

    public Formula1Driver(String name, String location, String team, int firstPosition,
                          int secondPosition, int thirdPosition, int totalPoints, int totalRaces)
    {
        super(name, location, team);    //reusing Test.Driver class constructor
        this.firstPosition = firstPosition;
        this.secondPosition = secondPosition;
        this.thirdPosition = thirdPosition;
        this.totalPoints = totalPoints;
        this.totalRaces = totalRaces;
    }

    public int getFirstPosition() {
        return firstPosition;
    }

    public void setFirstPosition(int firstPosition) {
        this.firstPosition = firstPosition;
    }

    public int getSecondPosition() {
        return secondPosition;
    }

    public void setSecondPosition(int secondPosition) {
        this.secondPosition = secondPosition;
    }

    public int getThirdPosition() {
        return thirdPosition;
    }

    public void setThirdPosition(int thirdPosition) {
        this.thirdPosition = thirdPosition;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getTotalRaces() {
        return totalRaces;
    }

    public void setTotalRaces(int totalRaces) {
        this.totalRaces = totalRaces;
    }

    @Override
    public String toString()
    {
        return "Driver Name = " + getName() + ", Location = " + getLocation() + ", Team = " + getTeam() + ", firstPosition = " + firstPosition +
                ", secondPosition = " + secondPosition + ", thirdPosition = " + thirdPosition +", totalPoints = " + totalPoints + ", totalRaces = " + totalRaces;
    }
}

