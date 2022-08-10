package org.soumen.functionalInterface;

import org.soumen.functionalInterface.data.Student;
import org.soumen.functionalInterface.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionExample {
    static BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> studentBiFunction = (students, studentPredicate) -> {
        Map<String, Double> studentMap = new HashMap<>();
        students.forEach(student -> {
            if(studentPredicate.test(student)) {
                studentMap.put(student.getName(), student.getGpa());
            }
        });
        return studentMap;
    };

    public static void main(String[] args) {
        Map<String, Double> studentMap = studentBiFunction.apply(StudentDataBase.getAllStudents(), PredicateStudentExample.studentGpaPredicate);
        System.out.println(studentMap);
    }
}
