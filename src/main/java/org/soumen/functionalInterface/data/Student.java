package org.soumen.functionalInterface.data;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int gradeLevel;
    private double gpa;
    private String gender;
    List<String> activities;

    private boolean isAbove18;

    public Student(String name, int gradeLevel, double gpa, String gender, List<String> activities) {
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.gpa = gpa;
        this.gender = gender;
        this.activities = activities;
    }

    public Student(StudentBuilder studentBuilder) {
        this.name = studentBuilder.name;
        this.gender = studentBuilder.gender;
        this.isAbove18 = studentBuilder.isAbove18;
        this.gradeLevel = studentBuilder.gradeLevel;
        this.gpa = studentBuilder.gpa;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public List<String> getActivities() {
        return activities;
    }

    public void setActivities(List<String> activities) {
        this.activities = activities;
    }

    public boolean isAbove18() {
        return isAbove18;
    }

    public void printActivities() {
        System.out.println(activities);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gradeLevel=" + gradeLevel +
                ", gpa=" + gpa +
                ", gender='" + gender + '\'' +
                ", activities=" + activities +
                '}';
    }

    static class StudentBuilder {
        //Required parameters
        private String name;
        private String gender;

        //optional parameters
        private int gradeLevel;
        private double gpa;

        private boolean isAbove18;

        public StudentBuilder(String name, String gender) {
            this.name = name;
            this.gender = gender;
        }

        public StudentBuilder setIsAbove18(boolean isAbove18) {
            this.isAbove18 = isAbove18;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}