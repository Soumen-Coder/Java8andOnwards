package org.soumen.streams;

import org.soumen.functionalInterface.data.Student;
import org.soumen.functionalInterface.data.StudentDataBase;

import java.util.List;

import static java.util.stream.Collectors.toList;

//Stream API :: Count - returns the count of elements in the string
//It is a terminal operator
//Return long
//Similar to SQL Query count
public class StreamCountExample {

    public static long studentActivitiesCount(){
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .count(); // returns the count of distinct members in the stream
    }

    public static void main(String[] args) {
        System.out.println(studentActivitiesCount());
    }
}
