package com.company;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	// write your code here
    teacher t1 = new teacher();
    t1.setName("Alan");
    t1.setCourseId(65614);
    t1.setFaculty("College of Engineering");
    t1.printTeacher();

    student s1 = new student();
    s1.printStudent();

    t1.getStudents().add(s1);

    animal wolf = new dog("step",356,5,2.05,"timberwolf");
    dog bulldog = new dog("pet",10,10,.65,"bulldog");

    System.out.println(wolf.getHabitat());
    System.out.println(bulldog.toStr());
    }
}
