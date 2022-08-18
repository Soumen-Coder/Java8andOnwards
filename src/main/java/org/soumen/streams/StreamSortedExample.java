package org.soumen.streams;

import org.soumen.functionalInterface.data.Student;
import org.soumen.functionalInterface.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamSortedExample {
    public static List<Student> studentSortedListByGpa = StudentDataBase.getAllStudents().stream() //Stream<Student>
            .sorted(Comparator.comparing(Student::getGpa)) //sorted with the Comparator param to sort in ascending order
            .collect(toList());  //To List - Terminal operation

    public static List<Student> studentSortedListByGpaReversed = StudentDataBase.getAllStudents().stream() //Stream<Student>
            .sorted(Comparator.comparing(Student::getGpa).reversed()) //sorted with the Comparator param to sort in descending order
            .collect(toList());  //To List - Terminal operation


    public static void main(String[] args) {
        System.out.println("Student List sorted by Gpa in ascending order");
        studentSortedListByGpa.forEach(System.out::println);
        System.out.println();
        System.out.println("Student List sorted by Gpa in descending order");
        System.out.println(studentSortedListByGpaReversed);

    }
}
