package org.soumen.functionalInterface;

import org.soumen.functionalInterface.data.Student;
import org.soumen.functionalInterface.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateStudentExample {

    static Predicate<Student> studentGradePredicate = student -> student.getGradeLevel()>=4;
    static Predicate<Student> studentGpaPredicate = student -> student.getGpa()>=4;

    static BiConsumer<String, String> studentBiConsumer = (studentGender, studentName) -> System.out.println("Gender is :- "+studentGender+" and Student name is :- "+studentName);

    public static void main(String[] args) {
        printActivities();
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
