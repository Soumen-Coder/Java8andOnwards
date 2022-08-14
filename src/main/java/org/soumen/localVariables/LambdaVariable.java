package org.soumen.localVariables;

import java.util.function.Consumer;

//Rules
//You cannot use the same name as the local variable name inside a lambda body or in the lambda parameter
//You cannot reassign the value to a local variable
//Final or effectively final
//No rules for Instance variables
public class LambdaVariable {

    static int instanceVar = 100;

    public static void main(String[] args) {
        int i = 1;

        //Consumer<Integer> consumer = i -> System.out.println(i); //Not allowed, variable already defined in scope

        int value = 10;

        Consumer<Integer> consumer = x -> {
            //value++; //Modification of value is not allowed inside a lambda expression
            //It treats the value primitive as final and doesn't let you modify it - "EFFECTIVELY FINAL"
            //Prior to Java8, you have to declare any variable used inside anonymous class as final
            instanceVar++; // No rules for instance variables, you can modify them when required
            System.out.println("value+x+i = "+(value+x+i));
            System.out.println("Instance variable value = "+(--instanceVar));
        };

        //value=9; Since value is used inside lambda expression, you cannot modify it within the method scope as well

        consumer.accept(4);


        //Advantages of Effectively final :
        //Easy to perform concurrency operations
        //Promotes functional programming and demotes imperative style of programming
    }
}
