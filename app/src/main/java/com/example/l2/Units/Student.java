package com.example.l2.Units;

import android.util.Log;

import com.example.l2.Organization.Organizations;

public class Student extends Person {
    public int mark;
    public int Course;
    public String org;

    public int getmark()
    {
        return mark;
    }
    public void setmark(int mark)
    {
        this.mark = mark;
    }
    public int getCourse()
    {
        return Course;
    }
    public void setname(int Course)
    {
        this.Course = Course;
    }
    public Student(int Mark, int course, String g, String Fullname, int day, int mounth, int year)
    {
        mark = Mark;
        Course = course;
        org = g;
        UnitType ="Student";
        FullName = Fullname;
        Day = day;
        Mounth = mounth;
        Year = year;
        Log.d("Student ","Student " + FullName + " created");
    }
    @Override
    public String toString()
    {
        return "Unit Type: "+ UnitType+ ", Full Name: " + FullName + ", Org: " + org + ", Course: " + Course + ", Mark: " + mark + ", Year: "+ Year;
    }
    public Student(){}
}
