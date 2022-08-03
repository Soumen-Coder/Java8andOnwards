package org.soumen.functionalInterface;

import org.soumen.functionalInterface.data.Student;
import org.soumen.functionalInterface.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

//CA - Consumer only accepts, doesn't return anything
public class ConsumerExample {
    static Consumer<Student> c1 = System.out::println;
    static Consumer<Student> c2 = student -> System.out.print(student.getName()+ " ");
    static Consumer<Student> c3 = student -> System.out.println(student.getActivities());

    public static void main(String[] args) {
        Consumer<String> consumer = s -> System.out.println(s.toUpperCase());
        consumer.accept("java8");
        System.out.println();
        System.out.println("Student List : ");
        printStudents();
        System.out.println();
        printNameAndActivities();
        System.out.println();
        printNameAndActivitiesUsingCondition();
    }

    public static void printStudents(){
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(c1);
    }

    public static void printNameAndActivities(){
        System.out.println("Inside printNameAndActivities :: ");
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(c2.andThen(c3)); //consumer chaining
    }

    public static void printNameAndActivitiesUsingCondition(){
        System.out.println("Inside printNameAndActivitiesUsingCondition :: ");
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(student -> {
            if(student.getGpa()>=3 && student.getGradeLevel()>=4){
                c2.andThen(c3).accept(student); // reusing consumers -> accepting students
            }
        });
    }

}
