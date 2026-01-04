package com.student.registration;

public class Student {
    private int id;
    private String name;
    private int roll;
    private String dept;

    // Constructor
    public Student(String name, int roll, String dept) {
        this.name = name;
        this.roll = roll;
        this.dept = dept;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getRoll() { return roll; }
    public void setRoll(int roll) { this.roll = roll; }

    public String getDept() { return dept; }
    public void setDept(String dept) { this.dept = dept; }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", roll=" + roll + ", dept=" + dept + "]";
    }
}