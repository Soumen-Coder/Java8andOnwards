package org.soumen.functionalInterface;

import org.soumen.functionalInterface.data.Student;
import org.soumen.functionalInterface.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {
    static BiConsumer<Student, String> biConsumer = (student, gender) -> System.out.println(student.getActivities());

    static BiConsumer<String, List<String>> nameAndActivitiesBiConsumer = (name, activities) -> System.out.println("Student Name :- "+name+" and Activities :- "+activities);
    static BiConsumer<Integer, Integer> multiply = (a, b) -> System.out.println("Multiplication is :- "+a*b);

    public static void main(String[] args) {
        multiply.accept(10, 20);
        printStudentActivities();
        System.out.println();
        System.out.println();
        printNameAndActivities();
    }

    public static void printStudentActivities(){
        System.out.println("Inside printStudentActivities :: ");
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(student -> {
            if(student.getGradeLevel()>=3 && student.getGender().equalsIgnoreCase("Male")){
                biConsumer.accept(student, student.getGender());
            }
        });
    }

    public static void printNameAndActivities(){
        System.out.println("Inside printNameAndActivities :: ");
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(student -> nameAndActivitiesBiConsumer.accept(student.getName(), student.getActivities()));
    }
}
