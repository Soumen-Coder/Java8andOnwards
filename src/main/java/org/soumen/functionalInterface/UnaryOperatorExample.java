package org.soumen.functionalInterface;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
    //UnaryOperator Extends Function - Takes in a input of same type and returns output of the same type
    static UnaryOperator<String> unaryOperator= s -> s.concat("default");

    public static void main(String[] args) {
        String result = unaryOperator.apply("Java8");
        System.out.println(result);
    }
}
