package org.soumen.streams;

import org.soumen.functionalInterface.data.Student;
import org.soumen.functionalInterface.data.StudentDataBase;

import java.util.List;

import static java.util.stream.Collectors.toList;

//Stream API :: Map is used to convert/transform one type to another type
public class StreamMapExample {

    public static List<String> studentName = StudentDataBase.getAllStudents().stream() //Stream<Student>
            .map(Student::getName) //Stream<String>
            .sorted() //sorted without any params - sorts the name list //Stream<String>
            .collect(toList());  //To List - Terminal operation

    public static void main(String[] args) {
        studentName.forEach(System.out::println);
    }
}
