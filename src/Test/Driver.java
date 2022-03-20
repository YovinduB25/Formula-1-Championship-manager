package Test;
//UoW - 1837849
//IIT - 20200870

import java.io.Serializable;

public abstract class Driver implements Serializable
{   //Abstract class of the F1 Championship
    private String name;
    private String location;
    private String team;

    public Driver(){}

    public Driver(String name, String location, String team)
    { //Driver class constructor
        this.name = name;
        this.location = location;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Driver Name: " + name + ", Location: " + location + ", Team: " + team;
    }

}