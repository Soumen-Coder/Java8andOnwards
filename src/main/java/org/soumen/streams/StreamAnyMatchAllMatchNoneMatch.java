package org.soumen.streams;

// Stream API : anyMatch() - if there's any match for the predicate passed - returns boolean
// Stream API : allMatch() - if all elements matches for the predicate passed - returns boolean
// Stream API : noneMatch() - if none matches for the predicate passed - returns boolean

import org.soumen.functionalInterface.data.StudentDataBase;

public class StreamAnyMatchAllMatchNoneMatch {

    public static boolean anyMatches(){
        return StudentDataBase.getAllStudents().stream()
                .anyMatch(student -> student.getGpa()>=5.0);

    }

    public static boolean allMatches(){
        return StudentDataBase.getAllStudents().stream()
                .allMatch(student -> student.getNoOfBooks()>=1);
    }

    public static boolean noneMatches(){
        return StudentDataBase.getAllStudents().stream()
                .noneMatch(student -> student.getGpa()>=5.0);
    }

    public static void main(String[] args) {
        boolean resultOfAnyMatch = anyMatches();
        boolean resultOfAllMatch = allMatches();
        boolean resultOfNoneMatch = noneMatches();

        System.out.println("Any student>=5.0 GPA ? "+resultOfAnyMatch);
        System.out.println("All students have more than or equal to 1 book ? "+resultOfAllMatch);
        System.out.println("No match of student>=5.0 GPA ? "+resultOfNoneMatch);
    }
}
