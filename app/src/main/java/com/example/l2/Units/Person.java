package com.example.l2.Units;

public abstract class Person {
    public String FullName;
    public int Year;
    public int Mounth;
    public int Day;
    public int Rang;
    public String UnitType;
    public String getname()
    {
        return FullName;
    }
    public void setname(String Name)
    {
        FullName= Name;
    }

}
