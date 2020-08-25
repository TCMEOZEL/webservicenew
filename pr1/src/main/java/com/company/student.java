package com.company;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Table(name = "students",schema = "micropayment_pool")
public class student implements person {
    @Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE1")
    @SequenceGenerator(name="SEQUENCE1", sequenceName="SEQUENCE1", allocationSize=1)
    @Column(name="Studentid")
    int id;
    @Column(name="name")
    String name;
    @Column(name="major")
    String major;
    @Column(name="gpa")
    double gpa;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "student_teacher",
            joinColumns = { @JoinColumn(name = "Studentid") },
            inverseJoinColumns = { @JoinColumn(name = "id") }
    )
    private List<teacher> ts = new ArrayList<teacher>();


    public student(){}

    public void setGpa(double gpa) { this.gpa = gpa; }
    public double getGpa() { return gpa; }
    public void setName(String name){
        this.name=name;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setMajor(String major){
        this.major=major;
    }
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getMajor(){
        return this.major;
    }
    public void printStudent(){
        System.out.println("Student name: "+this.name+" id: "+this.id+" major: "+this.major);
    }
    public String nationality(String nation){
        return nation;
    }
    public List<teacher> getTlist(){return this.ts;}
    public void setTs(List tlist){this.ts=tlist;}

    public int age(int year) {
        return 2020-year;
    }

    public int citizenid(int id) {
        return id;
    }




}
