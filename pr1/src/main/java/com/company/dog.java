package com.company;

public class dog extends animal {
    public String race;

    public dog(String hab,int pop,int age,double len,String race){
        super(pop,hab,age,len);
        setRace(race);
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getRace() {
        return race;
    }
}
