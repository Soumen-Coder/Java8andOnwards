package org.soumen.methodReferences;

import org.soumen.functionalInterface.data.Student;

import java.util.function.Function;
import java.util.function.Supplier;

//Syntax
//ClassName::new
public class ConstructorReference {

    static Supplier<Student> studentSupplier = Student::new; // needs an empty constructor to be created, gives back an empty object upon get

    static Function<String, Student> studentFunction = Student::new; // needs a constructor with single string argument, given back the Student object with student name

    public static void main(String[] args) {
        Student emptyStudentObject = studentSupplier.get();
        System.out.println(emptyStudentObject);

        System.out.println("**********************************");

        Student studentObjWithName = studentFunction.apply("Soumen");
        System.out.println(studentObjWithName);
    }
}
