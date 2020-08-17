package com.tarnet.reflection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private int id;
    private String name;
    private String title;
    private Date birthday;

    public Person(int id, String name, String title, String birthday) throws ParseException {
        this.id = id;
        this.name = name;
        this.title = title;
        this.setBirthday(birthday);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBirthday() {
        SimpleDateFormat df = new SimpleDateFormat("d/M/yyyy");
        return df.format(this.birthday);
    }

    public void setBirthday(String birthday) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("d/M/yyyy");
        this.birthday = df.parse(birthday);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
