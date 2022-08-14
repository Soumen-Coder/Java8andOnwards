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
            instanceVar++; // No rules for instance variables, you can modify them when required
            System.out.println("value+x+i = "+(value+x+i));
            System.out.println("Instance variable value = "+(--instanceVar));
        };

        //value=9; Since value is used inside lambda expression, you cannot modify it within the method scope as well

        consumer.accept(4);
    }
}
