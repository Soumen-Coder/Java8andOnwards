package org.soumen.streams;

import org.soumen.functionalInterface.PredicateStudentExample;
import org.soumen.functionalInterface.data.Student;
import org.soumen.functionalInterface.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExample {
    static Predicate<Student> studentPredicate = student -> student.getGpa()>=3.9;
    public static void main(String[] args) {

        //Use case - Create a Map of Student as Key and List of activities as Values
        Map<String, List<String>> studentActivitiesMap = StudentDataBase.getAllStudents().stream()
                .peek(student -> {
                    System.out.println("Getting all student via stream :- "+student);
                    System.out.println("------------------------------------------");
                })
                .filter(PredicateStudentExample.studentGradePredicate)
                .peek(student -> {
                    System.out.println("After the 1st predicate, the stream is :- "+student);
                    System.out.println("------------------------------------------");
                })
                .filter(studentPredicate)
                .peek(student -> {
                    System.out.println("After the 2nd predicate, the stream is :- "+student);
                    System.out.println("------------------------------------------");
                })
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
        System.out.println("The student=activities hashMap :- "+studentActivitiesMap);

        //Streams are Lazy, if we don't have the terminal operation specified, none of the intermediate operations would take place.
        //Terminal operations invokes the stream pipeline.

        //You can debug a stream by using the peek(Consumer) method - This helps us in analyzing what values are being passed from one
        //stage to another within the stream pipeline.
        //They all happen in sequences.
    }
}
