package com.example.l2.EducationManager;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.l2.Exception.EduException;
import com.example.l2.Organization.Organizations;
import com.example.l2.Stuff.Course;
import com.example.l2.Stuff.Stuff;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.l2.Units.Listener;
import com.example.l2.Units.Person;
import com.example.l2.Units.Student;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;

import static java.lang.Integer.compare;

public class Manager implements IAction {
    public String name;
    public String getname()
    {
        return name;
    }
    public void setname(String Name)
    {
        name = Name;
    }
    public Manager(String Name)
    {
        name = Name;
        Log.d("Manager","Object "+name + " created");
    }

    @Override
    public String toString()
    {
        return "Name: "+name;
    }

    public Stuff generate(int studAmount, int listenersAmount, int course) throws EduException
    {
        ArrayList<Person> temp = new ArrayList<Person>();
        for (int i = 0; i <studAmount ; i++) {
            Student stud = new Student();
            stud.Day = getRandomNumberInRange(1, 30);
            stud.Mounth = getRandomNumberInRange(1,12);
            stud.Year = getRandomNumberInRange(1960, 2005);
            switch (getRandomNumberInRange(1,4))
            {
                case 1: stud.FullName="Frad"; break;
                case 2: stud.FullName="John"; break;
                case 3: stud.FullName="Gzegozhch"; break;
                case 4: stud.FullName="Andruha"; break;
            }
            Organizations g;
            stud.mark = getRandomNumberInRange(1,10);
            stud.Course = course;
            stud.Rang = getRandomNumberInRange(1,7);
            stud.UnitType = "Student";
            switch (getRandomNumberInRange(1,4))
            {
                case 1: g = Organizations.Epam; break;
                case 2: g = Organizations.GloruHL; break;
                case 3: g = Organizations.Google; break;
                case 4: g = Organizations.Tiharb; break;
                default: g = Organizations.GloruHL; break;
            }
            stud.org = g.getOrg();
            temp.add(stud);
        }
        for (int i = 0; i <listenersAmount ; i++) {
            Listener listen = new Listener();
            listen.Day = getRandomNumberInRange(1, 30);
            listen.Mounth = getRandomNumberInRange(1, 12);
            listen.Year = getRandomNumberInRange(1960, 2005);
            switch (getRandomNumberInRange(1, 4)) {
                case 1:
                    listen.FullName = "Frad";
                    break;
                case 2:
                    listen.FullName = "John";
                    break;
                case 3:
                    listen.FullName = "Gzegozhch";
                    break;
                case 4:
                    listen.FullName = "Andruha";
                    break;
            }
            listen.Rang = getRandomNumberInRange(1,7);
            listen.ListenedCourses = getRandomNumberInRange(1, 100);
            listen.Rating = getRandomNumberInRange(1, 10);
            listen.UnitType = "Listener";
            temp.add(listen);
        }
        Stuff stuff = new Stuff();
        stuff.studlist = temp;
        Log.d("Manager","List generated");
        return stuff;
    }
    public int sumRanges (Stuff anyCourse) throws EduException
    {
        int sum=0;
        for (int i = 0; i < anyCourse.studlist.size() ; i++) {
           sum +=anyCourse.studlist.get(i).Rang;
        }
        return sum;
    }
    public int CountListeners(Stuff AnyCourse) throws EduException
    {
        int sum = 0;
        for (int i = 0; i < AnyCourse.studlist.size(); i++)
        {
            if(AnyCourse.studlist.get(i).UnitType == "Listener") sum++;
        }
        return sum;
    }

    public ArrayList<Person> bubbleSort(ArrayList<Person> arr) throws EduException{
        for(int i = arr.size()-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( this.compare.compare(arr.get(j), arr.get(j+1))==1 ){
                int tmp = arr.get(j).Year;
                arr.get(j).Year = arr.get(j+1).Year;
                arr.get(j+1).Year = tmp;
            }
        }

    }
        Log.d("Manager","Sorted by year");
        return arr;
}
    Comparator<Person> compare = (o1,o2) -> {return compare(o1.Year, o2.Year);};


    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    /////////////////////////////////////////////////Serial
    public void saveListenersJson(Stuff stuff, File path) throws EduException {
        Gson gson = new Gson();
        File file = new File(path,"Listeners.txt");
        try {
            try(FileWriter writer = new FileWriter(file,false)){
                writer.write(gson.toJson(stuff.getListenerList()));
            }
        } catch (IOException e) {
            Log.d("Serial",e.getMessage());
        }
    }

    public void saveStudentsJson(Stuff stuff, File path) throws EduException {
        Gson gson = new Gson();
        File file = new File(path,"Students.txt");
        try {
            try(FileWriter writer = new FileWriter(file,false)){
                writer.write(gson.toJson(stuff.getStudentList()));
            }
        } catch (IOException e) {
            Log.d("Serial",e.getMessage());
        }
        System.out.println(file.exists());
    }
    public CopyOnWriteArrayList<Student> readStudentsJson(String json){
        Gson gson = new Gson();
        Type s = new TypeToken<CopyOnWriteArrayList<Student>>() {}.getType();
        Type t = new TypeToken<Stuff>() {}.getType();

        Log.d("Deserial","Считаны студенты");
        return gson.fromJson(json,s);

    }

    public CopyOnWriteArrayList<Listener> readListenersJson(String json){
        Gson gson = new Gson();

        Type l = new TypeToken<CopyOnWriteArrayList<Listener>>() {}.getType();
        Log.d("Deserial","Считаны слушатели");
        return gson.fromJson(json,l);
    }

    public Stuff createCourse(File path) throws EduException {
        Stuff stuff = new Stuff();
        String studentsString="";
        String ListenersString="";
        File studentsFile = new File(path,"Students.txt");
        File listenersFile = new File(path,"Listeners.txt");

        try {
            try(FileReader reader = new FileReader(studentsFile)){
                String g = path.getPath()+"/Students.txt";
                studentsString = new String(Files.readAllBytes(Paths.get(path.getPath()+"/Students.txt")));

            }
        } catch (IOException e) {
            Log.d("Serialize","Ошибка чтения");
        }
        try {
            try(FileReader reader = new FileReader(listenersFile)){

                ListenersString = new String(Files.readAllBytes(Paths.get(path.getPath()+"/Listeners.txt")));
            }
        } catch (IOException e) {
            Log.d("Serialize","Ошибка чтения");
        }
        stuff.setStudentsList(readStudentsJson(studentsString));
        stuff.setListenersList(readListenersJson(ListenersString));
        stuff.mergeLists();
        Log.d("Read: ","Считан курс");

        return stuff;
    }

    public void save(Stuff st, File path)
    {
        try {
            saveListenersJson(st, path);
            saveStudentsJson(st, path);
        }
        catch (EduException e)
        {
            Log.d("Save: ", "error");
        }
    }
}
