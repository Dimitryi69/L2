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

    public Listener(int courses, int rate)
    {
        ListenedCourses = courses;
        Rating = rate;
        Log.d("Listener","Listener " + FullName + " created");
    }
    public Listener() {}

    @Override
    public String toString()
    {
        return "Listened Course: "+ListenedCourses + ", Rating: " + Rating + ", Name: " + FullName + ", Year: "+Year;
    }
}
