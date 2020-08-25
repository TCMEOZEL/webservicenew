package com.company;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "teachers",schema = "micropayment_pool")
public class teacher implements person {
    @Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE2")
    @SequenceGenerator(name="SEQUENCE2", sequenceName="SEQUENCE2", allocationSize=1)
    @Column(name="id")
    int id;
    @Column(name="name")
    String name;
    @Column(name="courseNo")
    int courseId;
    @Column(name="faculty")
    String faculty;

    @ManyToMany(mappedBy = "ts")
    List<student> students = new ArrayList<>();


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public void setName(String name) {
        this.name = name;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
    public int getCourseId() {
        return courseId;
    }
    public String getFaculty() {
        return faculty;
    }
    public String getName() {
        return name;
    }
    public void printTeacher(){
        System.out.println("Teacher name: "+this.name+" course no: "+this.courseId+" faculty: "+this.faculty);
    }
    public String nationality(String nation){
        return nation;
    }

    public int age(int year) {
        return 2020-year;
    }

   // java collections a bak

    public int citizenid(int id) {
        return id;
    }

    public List<student> getStudents() {
        return students;
    }

}
