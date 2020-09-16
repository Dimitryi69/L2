package com.example.l2.Stuff;

import java.util.concurrent.CopyOnWriteArrayList;

public class Course {
    public CopyOnWriteArrayList<Stuff> CourseList = new CopyOnWriteArrayList<Stuff>();
    public void setList(Stuff a, Stuff b, Stuff c, Stuff d)
    {
        firstGroup = a;
        secondGroup = b;
        thirdGroup = c;
        fourthGroup = d;
        CourseList.add(a);
        CourseList.add(b);
        CourseList.add(c);
        CourseList.add(d);
    }
    public Course(){}

    public  Stuff firstGroup;
    public Stuff secondGroup;
    public  Stuff thirdGroup;
    public  Stuff fourthGroup;
}
