package org.soumen.functionalInterface;

import org.soumen.functionalInterface.data.Student;
import org.soumen.functionalInterface.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionStudentExample {
    static Function<List<Student>, Map<String, Double>> studentFunction = (students -> {
        Map<String, Double> studentMap = new HashMap<>();
        students.forEach(student -> {
            if(PredicateStudentExample.studentGradePredicate.test(student)) {
                studentMap.put(student.getName(), student.getGpa());
            }
        });
        return studentMap;
    });

    public static void main(String[] args) {
        Map<String, Double> studentMap = studentFunction.apply(StudentDataBase.getAllStudents());
        System.out.println(studentMap);
    }
}
