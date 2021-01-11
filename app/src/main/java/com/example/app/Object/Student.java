package com.example.app.Object;

public class Student {
    int id;
    String name;
    String classroom;
    String address;

    public Student(int id, String name, String classroom, String address) {
        this.id = id;
        this.name = name;
        this.classroom = classroom;
        this.address = address;
    }

    public Student() {
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

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
