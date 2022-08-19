package org.soumen.streams;

import org.soumen.functionalInterface.data.Student;
import org.soumen.functionalInterface.data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterExample {
    public static void main(String[] args) {
        List<Student> femaleStudentList = filterFemaleStudents();
        System.out.println(femaleStudentList);
    }

    public static List<Student> filterFemaleStudents(){

        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGender().equalsIgnoreCase("female"))
                .filter(student -> student.getGpa() >= 3.9)
                .collect(Collectors.toList());
    }
}
