package org.soumen.streams;

import org.soumen.functionalInterface.data.Student;
import org.soumen.functionalInterface.data.StudentDataBase;

import java.util.List;
import java.util.Optional;

public class StreamMapReduceFilter {

    public static Optional<Integer> noOfBooks(List<Student> studentList){

        return studentList.stream()
                .filter(student -> student.getGpa()>=3.5)
                .filter(student -> student.getGender().equalsIgnoreCase("female"))
                .map(Student::getNoOfBooks)
                .reduce(Integer::sum);
    }

    public static void main(String[] args) {
        System.out.println("Total No of Books that all the students have is :- ");
        Optional<Integer> result = noOfBooks(StudentDataBase.getAllStudents());
        result.ifPresent(System.out::print);
    }


}
