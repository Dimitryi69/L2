package com.example.l2.Stuff;

import android.util.Log;

import com.example.l2.Exception.EduException;
import com.example.l2.Units.Listener;
import com.example.l2.Units.Person;
import com.example.l2.Units.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Stuff {
    public ArrayList<Person> studlist;
    public CopyOnWriteArrayList<Student> Students;
    public CopyOnWriteArrayList<Listener> Listeners;
    public Stuff(){studlist = new ArrayList<Person>(); Log.d("Stuff","Stuff created");}
    public Stuff(ArrayList<Person> persons)
    {
        studlist = persons;
        Log.d("Stuff","Stuff created");
    }
    public List<Person> getStudList() {return studlist;}
    public void setStudList(ArrayList<Person> studlist){this.studlist=studlist;}
    public boolean add(Person item) throws EduException
    {
        if(!studlist.contains(item)) {studlist.add(item); Log.d("Stuff","Person added"); return true;}
        else {System.out.println("Already exists"); return false;}
    }
    public boolean remove(Person item)
    {
        if(studlist.contains(item)){studlist.remove(item); Log.d("Stuff","Person removed"); return true;}
        else {System.out.println("This person doesn't exist"); return false;}
    }

    @Override
    public String toString()
    {
        String res = "";
        String res1 = "";
        for (int i = 0; i < studlist.size() ; i++) {
            res1 = studlist.get(i).toString();
            res += studlist.get(i).toString() + System.lineSeparator();
            Log.d("Stuff", res1);
        }
        return res;
    }

    public int CompByYear(Person a, Person b)
    {
        if(a.Year>b.Year) return 1;
        else if(a.Year<b.Year) return 0;
        else return 2;
    }

    public CopyOnWriteArrayList<Student> getStudentList()
    {
        if(studlist.size()!= 0)
        {
            CopyOnWriteArrayList<Student> ret = new CopyOnWriteArrayList<Student>();
            for (int i = 0; i < studlist.size() ; i++) {
                if(studlist.get(i).UnitType.equals("Student") )
                {
                    ret.add((Student) studlist.get(i));
                }
            }
            return ret;
        }
        else return null;
    }

    public CopyOnWriteArrayList<Listener> getListenerList()
    {
        if(studlist.size()!= 0)
        {
            CopyOnWriteArrayList<Listener> ret = new CopyOnWriteArrayList<Listener>();
            for (int i = 0; i < studlist.size() ; i++) {
                if(studlist.get(i).UnitType.equals("Listener"))
                {
                    ret.add((Listener) studlist.get(i));
                }
            }
            return ret;
        }
        else return null;
    }

    public void setStudentsList(CopyOnWriteArrayList<Student> k) throws EduException
    {
        Students =k;
    }

    public void setListenersList(CopyOnWriteArrayList<Listener> k) throws EduException
    {
        Listeners =k;
    }
    public void mergeLists(){
        studlist = new ArrayList<Person>();
        studlist.addAll(Students);
        studlist.addAll(Listeners);
    }
}
