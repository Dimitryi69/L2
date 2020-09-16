package com.example.l2.EducationManager;

import android.util.Log;

import java.util.ArrayList;

public interface IAction<T> {
    static String hi(Manager a)
    {
        return "Hello from "+ a.name;
    }
    default void Version(T someObj)
    {
        Log.d("IAction", "Type is: " + someObj.getClass().getName());
    }
}
