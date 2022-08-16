package org.soumen.functionalInterface;

import org.soumen.functionalInterface.data.Student;
import org.soumen.functionalInterface.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class PredicateStudentExample {

    public static Predicate<Student> studentGradePredicate = student -> student.getGradeLevel()>=3;
    public static Predicate<Student> studentGpaPredicate = student -> student.getGpa()>=3.9;

    static BiConsumer<String, String> studentBiConsumer = (studentGender, studentName) -> System.out.println("Gender is :- "+studentGender+" and Student name is :- "+studentName);

    public static void main(String[] args) {
        filterStudentByGradeLevel();
        System.out.println();
        printActivities();
    }

    public static void filterStudentByGradeLevel(){
        System.out.println("Filtering student by grade level");
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(student -> {
            if(studentGradePredicate.test(student)){
                System.out.println("Students with greater than 4 Grade levels are :- "+student.getName());
            }
        });
    }

    public static void printActivities(){
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(student -> {
            if(studentGpaPredicate.or(studentGradePredicate).test(student)){
                studentBiConsumer.accept(student.getGender(), student.getName());
            }
        });
    }
}
