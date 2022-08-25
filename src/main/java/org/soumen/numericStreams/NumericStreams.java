package org.soumen.numericStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreams {

    public static int BeforeIntStreams(List<Integer> integerList){
        return integerList.stream()
                .reduce(0, (x,y) -> x+y); // Overhead/Problem - It converts Wrapper to an int in each step and then provide us the result
    }

    public static int UsingIntStreams(){
        //IntStream has some awesome methods like range(), rangeClosed(), count(), forEach()
        return IntStream.rangeClosed(1,6).sum();
    }

    public static long UsingLongStreams(){
        //using the range() and count()
        return LongStream.range(1,6).count();
    }

    public static double UsingDoubleStreams(){
        //Double streams doesn't have direct methods like range() and rangeClosed()
        return IntStream.range(1,6).asDoubleStream().sum();
    }

    public static void main(String[] args) {
        System.out.println("Before IntStream : Converting from Wrapper to int was a performance impact : ");
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6);
        int resultBeforeIntStream = BeforeIntStreams(integerList);
        System.out.println(resultBeforeIntStream);

        System.out.println("Using IntStream :- No performance impact here");
        int resultUsingIntStream = UsingIntStreams();
        System.out.println(resultUsingIntStream);

        System.out.println("Using LongStream to calculate the number of elements");
        long resultUsingLongStream = UsingLongStreams();
        System.out.println(resultUsingLongStream);

        System.out.println("Using DoubleStream :- No direct methods, had to use IntStream to get a DoubleStream");
        double resultUsingDoubleStream = UsingDoubleStreams();
        System.out.println(resultUsingDoubleStream);
    }
}
