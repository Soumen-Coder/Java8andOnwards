package org.soumen.functionalInterface;

import java.util.function.Function;

public class FunctionExample {

    static Function<String, String> function = String::toUpperCase;

    static Function<String, String> addSomeString = name -> name.toUpperCase().concat("-Learning");

    public static void main(String[] args) {

        String functionResult = function.apply("java8");
        System.out.println("Function Result is :- "+functionResult);

        //applies the function to the parameter passed, first and then applies the function to the addSomeString
        String functionAndThenResult = function.andThen(addSomeString).apply("java8");
        System.out.println("Function AndThen Result is :- "+functionAndThenResult);

        //applies the addSomeString to the parameter passed, first and then applies the function
        String functionComposeResult = function.compose(addSomeString).apply("java8");
        System.out.println("Function Compose Result is :- "+functionComposeResult);
    }
}
