package org.soumen.functionalInterface;

public class FunctionExampleReUsage {
    public static void main(String[] args) {
        String result = performConcat("Concatenation by reusing the previous Function"); // Utilizing the Function from other classes
        System.out.println("Utilizing and Readability Enhanced by reusing the function");
        System.out.println("The result is :- "+result);
    }

    public static String performConcat(String str){
        return FunctionExample.addSomeString.apply(str);
    }
}
