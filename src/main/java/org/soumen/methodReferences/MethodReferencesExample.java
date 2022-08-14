package org.soumen.methodReferences;


import org.soumen.functionalInterface.data.Student;
import org.soumen.functionalInterface.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

//Syntax :-
//ClassName::instance-methodName
//ClassName::static-methodName
//Instance::methodName
//Can be used where Lambda Expressions referring to a method directly
public class MethodReferencesExample {

    //static Function<String, String> function = s -> s.toUpperCase();
    static Function<String, String> functionMethodReference = String::toUpperCase;

    //static Consumer<Student> studentConsumer = s -> System.out.println(s);
    static Consumer<Student> studentConsumerMethodReference = System.out::println;

    //static Consumer<Student> studentActivitiesConsumer = s -> s.printActivities();
    //ClassName::InstanceMethodName
    static Consumer<Student> studentActivitiesConsumerMethodReference = Student::printActivities;

    public static void main(String[] args) {
        String result = functionMethodReference.apply("java8");
        System.out.println("The Result of function is :- "+result);

        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(student -> {
            studentConsumerMethodReference.accept(student);
        });

        StudentDataBase.getAllStudents().forEach(studentActivitiesConsumerMethodReference);
    }
}
