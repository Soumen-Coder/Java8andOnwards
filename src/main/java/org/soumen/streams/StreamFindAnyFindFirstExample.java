package org.soumen.streams;

import org.soumen.functionalInterface.data.Student;
import org.soumen.functionalInterface.data.StudentDataBase;

import java.util.Optional;

//Stream API : FindAny/FindFirst - both returns the first element that is encountered/matched for a predicate while traversing the stream
//The difference can be seen when dealing with parallel streams
public class StreamFindAnyFindFirstExample {

    public static Optional<Student> findAny(){
        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGpa()>=3.9)
                .findAny();

    }

    public static Optional<Student> findFirst(){
        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGpa()>=3.9)
                .findFirst();

    }

    public static void main(String[] args) {
        Optional<Student> findAnyStudent = findAny();
        Optional<Student> findFirstStudent = findFirst();

        System.out.println("Print the findAny() :- ");
        if(findAnyStudent.isPresent()){
            System.out.println(findAnyStudent.get());
        }else{
            System.out.println("None of the student has a GPA>=3.9");
        }

        System.out.println("*********************");

        System.out.println("Print the findFirst() :- ");
        if(findFirstStudent.isPresent()){
            System.out.println(findFirstStudent.get());
        }else{
            System.out.println("None of the student has a GPA>=3.9");
        }
    }
}
