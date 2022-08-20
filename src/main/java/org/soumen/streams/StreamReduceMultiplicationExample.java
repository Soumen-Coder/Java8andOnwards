package org.soumen.streams;

import java.util.Arrays;
import java.util.List;

//Stream API - reduce is a terminal operation
//It reduces the entire stream to a single value
//reduce takes in two params
        //First is a default or an initial value
        //Second is the BinaryOperator<T> - it is an operator which accepts two params of the same type and returns output of the same type
public class StreamReduceMultiplicationExample {
    public static Integer multiplication(List<Integer> integerList){
        return integerList.stream() //Stream<Integer>
                //stream passes the integer one by one to the reduce function
                //reduce first assigns a nd b to the inditial default value i.e a and b to 1
                //Then the result of the first compution is assigned to a and the next number in the stream is taken as b
                //a=1 b=1 , result = 1
                //a=result=1 , b=3 , result = 3
                //a=result=3 , b=5 , result = 15
                //a=result=15 , b=7, result = 105
                //returns the result as output
                .reduce(1, (a,b) -> a*b);
    }
    public static void main(String[] args) {
        Integer result =  multiplication(Arrays.asList(1,3,5,7));
        System.out.println(result);
    }
}
