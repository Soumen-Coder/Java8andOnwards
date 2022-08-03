package org.soumen.collections;

import java.util.Comparator;

public class RunnableLambdas {
    public static void main(String[] args) {
        //prior Java 8
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside runnable prior to Java 8");
            }
        };

        new Thread(runnable).start();


        //After Java 8
        Runnable runnableNew = () -> {
            System.out.println("Inside runnable after Java 8");
        };

        new Thread(runnableNew).start();
    }
}
