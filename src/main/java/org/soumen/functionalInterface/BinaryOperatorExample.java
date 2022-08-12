package org.soumen.functionalInterface;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample {

    static Comparator<Integer> comparator = Integer::compareTo;
    static BinaryOperator<Integer> binaryOperator = (a,b) -> a*b;

    static BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(comparator);

    static BinaryOperator<Integer> minBy = BinaryOperator.minBy(comparator);

    public static void main(String[] args) {
        Integer multiply = binaryOperator.apply(4,5);
        System.out.println("Result of multiplication is :- "+multiply);

        Integer maximum = maxBy.apply(4,5);
        System.out.println("Maximum of two values passed is :- "+maximum);

        Integer minimum = minBy.apply(4,5);
        System.out.println("Minimum of two values passed is :- "+minimum);
    }
}
