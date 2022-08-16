package org.soumen.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CollectionsVsStreams {
    public static void main(String[] args) {
        // 1) You can add/modify elements at any point of time in Collections, like using the add() method in List whereas in Streams you cannot. Streams is a fixed data set

        // 2) Collections uses an external iteration to iterate over elements whereas Streams uses internal iteration(forEach())

        // 3) You can traverse the Collection "n" number of times whereas streams can be traversed only once.
              //If you try traversing streams the second time you will get IllegalStateException: The stream has been operated upon or closed

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        for(Integer i : integerList){
            System.out.println(i);
        }

        for(Integer i : integerList){
            System.out.println(i);
        }

        for(Integer i : integerList){
            System.out.println(i);
        }

        Stream<Integer> integerStream = integerList.stream();
        integerStream.forEach(System.out::println);
        integerStream.forEach(System.out::println); // IllegalStateException

        // 4) Collections are eagerly constructed - just add values and access, whereas Streams are Lazily constructed - need terminal operations

        // 5) You can access an element at any point of time via get(4) for example in Collections whereas in streams you can only access elements in sequence one after the other

        // 6) You don't care much about the internal operations of stream, you do it in a declarative way whereas in Collection you do it the imperative way
    }
}
