package org.soumen.methodReferences;

import org.soumen.functionalInterface.data.Student;
import org.soumen.functionalInterface.data.StudentDataBase;

import java.util.function.Predicate;

public class RefactorMethodReference {
    //static Predicate<Student> studentPredicate = (student) -> student.getName().equalsIgnoreCase("Java");

    //getNameEqualTo can take a parameter of the type Predicate and can return a boolean
    static Predicate<Student> studentPredicate = RefactorMethodReference::getNameEqualTo;

    //Question is how can we convert the above types as method references ?
    //You have to write a method for that and then can access it via className

    public static boolean getNameEqualTo(Student student){
        return student.getName().equalsIgnoreCase("Java");
    }

    public static void main(String[] args) {
        boolean result = studentPredicate.test(StudentDataBase.studentSupplier.get());
        System.out.println("Is the student's name, Java ? :- "+result);
    }
}
