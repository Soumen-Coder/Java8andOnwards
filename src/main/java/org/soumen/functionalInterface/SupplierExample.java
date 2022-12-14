package org.soumen.functionalInterface;

import org.soumen.functionalInterface.data.Student;
import org.soumen.functionalInterface.data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {
    static Supplier<Student> studentSupplier = () -> new Student("Adam",2,3.6, "male", Arrays.asList("swimming", "basketball","volleyball"), 12);

    static Supplier<List<Student>> studentListSupplier = StudentDataBase::getAllStudents;

    public static void main(String[] args) {

        System.out.println(studentSupplier.get());

        System.out.println(studentListSupplier.get());
    }
}
