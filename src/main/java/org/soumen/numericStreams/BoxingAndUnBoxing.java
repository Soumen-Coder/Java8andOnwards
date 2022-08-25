package org.soumen.numericStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoxingAndUnBoxing {

    public static List<Integer> boxing(){
        return IntStream.rangeClosed(1,6) // stream of int(primitive)
                .boxed()   //converted to Stream<Integer>
                .collect(Collectors.toList());
    }

    public static int unBoxing(List<Integer> integerList){
        return integerList.stream()  //Stream<Integer>
                .mapToInt(Integer::intValue) //converted to int primitive using the Integer class's method intValue
                .sum();
    }

    public static long mapToLong(){
        return IntStream.rangeClosed(1,6)  //Stream of int
                .mapToLong((i) -> i) //converted to long primitive - Converting each value of int to long
                .sum();  //calculating the sum and producing back a long
    }

    //This is a very useful method, can be used with Custom objects as well
    public static List<Integer> mapToObj(){
        return IntStream.range(1,10)  //stream of int
                .mapToObj((i) -> Integer.valueOf(i)) //converting every value of steam of int to Integer object
                .collect(Collectors.toList());//converted to int primitive using the Integer class's method intValue
    }

    public static double mapToDouble(List<Integer> integerList){
        return integerList.stream()  //Stream<Integer>
                .mapToDouble((i) -> i) //converted to double primitive - Converting each value of Integer to double
                .sum(); //calculating the sum and producing back a double
    }

    public static void main(String[] args) {
        System.out.println("Boxing :- Primitive to Wrapper");
        List<Integer> integerListUsingBoxing = boxing();
        System.out.println(integerListUsingBoxing);

        System.out.println("UnBoxing :- Wrapper to Primitive");
        int resultOfMapToInt = unBoxing(Arrays.asList(1,2,3,4,5,6,7,8));
        System.out.println(resultOfMapToInt);

        System.out.println("Mapping Integer Stream to long value");
        long resultOfMapToLong = mapToLong();
        System.out.println(resultOfMapToLong);

        System.out.println("Converting IntStream values to Integer List - sort of Boxing");
        List<Integer> integerListUsingMapToObj = mapToObj();
        System.out.println(integerListUsingMapToObj);

        System.out.println("Mapping Integer Stream to double value");
        double resultOfMapToDouble = mapToDouble(Arrays.asList(1,2,3,4,5,6,7,8));
        System.out.println(resultOfMapToDouble);

    }
}
