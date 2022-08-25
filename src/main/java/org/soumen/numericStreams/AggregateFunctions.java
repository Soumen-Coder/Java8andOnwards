package org.soumen.numericStreams;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class AggregateFunctions {
    public static int aggregateFunctionSum(){
        return IntStream.rangeClosed(1,6).sum();
    }

    public static OptionalInt aggregateFunctionMax(){
        return IntStream.range(1,6).max();
    }

    public static OptionalLong aggregateFunctionMin(){
        return LongStream.range(1,6).min();
    }

    public static OptionalDouble aggregateFunctionAverage(){
        return IntStream.range(1,6).average();
    }

    public static void main(String[] args) {
        System.out.println("Print sum using IntStream");
        int sum = aggregateFunctionSum();
        System.out.println(sum);

        System.out.println("Using IntStream to calculate the maximum inside a stream : ");
        OptionalInt resultUsingIntStreamForMax = aggregateFunctionMax();
        if(resultUsingIntStreamForMax.isPresent())
           System.out.println(resultUsingIntStreamForMax.getAsInt());

        System.out.println("Using LongStream to calculate the minimum inside a stream : ");
        OptionalLong resultUsingLongStreamForMin = aggregateFunctionMin();
        if(resultUsingLongStreamForMin.isPresent())
           System.out.println(resultUsingLongStreamForMin.getAsLong());

        System.out.println("Using IntStream to calculate the average which returns an OptionalDouble");
        OptionalDouble average = aggregateFunctionAverage();
        if(average.isPresent())
           System.out.println(average.getAsDouble());
    }
}
