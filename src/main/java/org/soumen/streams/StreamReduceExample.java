package org.soumen.streams;

import org.soumen.functionalInterface.data.Student;
import org.soumen.functionalInterface.data.StudentDataBase;

import java.util.Optional;
import java.util.stream.Stream;

public class StreamReduceExample {

    public static Optional<Double> getHighestGPA(Stream<Double> studentGPAStream){
        return studentGPAStream.reduce((studentOneGpa, studentTwoGpa) -> Math.max(studentOneGpa, studentTwoGpa));
    }

    public static Optional<Student> getStudentWithHighestGPA(Stream<Student> studentStream){
        return studentStream.reduce((studentOne, studentTwo) ->(studentOne.getGpa() > studentTwo.getGpa()) ? studentOne : studentTwo);
    }

    public static void main(String[] args) {
        Stream<Student> studentStream = StudentDataBase.getAllStudents().stream();
        Optional<Double> highestGPA = getHighestGPA(studentStream.map(Student::getGpa));
        if(highestGPA.isPresent()){
            System.out.println(highestGPA.get());
        }
        Optional<Student> studentWithHighestGPA = getStudentWithHighestGPA(StudentDataBase.getAllStudents().stream());
        studentWithHighestGPA.ifPresent(System.out::println);
    }
}
