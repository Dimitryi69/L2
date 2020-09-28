package com.example.l2.Units;

import android.util.Log;

public class Listener extends Person {
    public int ListenedCourses;
    public int Rating;
    public int getcourse()
    {
        return ListenedCourses;
    }
    public void setcourse(int course)
    {
        ListenedCourses = course;
    }
    public int getRating()
    {
        return Rating;
    }
    public void setRating(int rate)
    {
        Rating = rate;
    }

    public Listener(int courses, int rate, String Un, String name, int d, int m, int y)
    {
        UnitType = Un;
        FullName = name;
        Day = d;
        Mounth = m;
        Year = y;
        ListenedCourses = courses;
        Rating = rate;
        Log.d("Listener","Listener " + FullName + " created");
    }
    public Listener() {}

    @Override
    public String toString()
    {
        return "Unit Type: "+"Listener, "+"Listened Course: "+ListenedCourses + ", Rating: " + Rating + ", Name: " + FullName + ", Year: "+Year;
    }
}
