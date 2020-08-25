package com.company;

public abstract class animal {
    private int population;
    private String habitat;
    private int age;
    private double length;

    public animal(int pop,String hab,int age,double len){
        this.population=pop;
        this.age=age;
        this.habitat=hab;
        this.length=len;
    }

    public int getPopulation() {
        return population;
    }

    public String getHabitat() {
        return habitat;
    }

    public String toStr(){

        return ""+this.population+" "+this.length+" "+this.habitat+" "+this.age;
    }
}
