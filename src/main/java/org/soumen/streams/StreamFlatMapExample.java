package org.soumen.streams;

import org.soumen.functionalInterface.data.Student;
import org.soumen.functionalInterface.data.StudentDataBase;

import java.util.List;

import static java.util.stream.Collectors.toList;

//Stream API :: FlatMap transforms one form of the same type to another form of the same type
//Flattens something
public class StreamFlatMapExample {

    public static List<String> studentActivities = StudentDataBase.getAllStudents().stream() //Stream<Student>
            .map(Student::getActivities) //Stream<List<String>>
            .flatMap(List::stream) //Stream<String> // flattens the stream of list of string to stream of string
            .distinct() // Stream<String> - return the distinct elements from the stream
            .sorted() //sorted without any params - sorts the name list //Stream<String>
            .collect(toList());  //To List - Terminal operation

    public static void main(String[] args) {
        System.out.println(studentActivities);
    }
}
