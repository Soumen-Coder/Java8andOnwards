package org.soumen.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//Remember to always use Optional with Max and Min
//Never even used the default or initial value parameter that comes with reduce, otherwise the result might be wrong in cases such as empty list and with initial value as 0
public class StreamMaxMinExample {

    public static int findMax(List<Integer> integerList){
        return integerList.stream()
                .reduce(0, (x,y) -> x>y ? x : y);

    }

    public static int findMin(List<Integer> integerList){
        return integerList.stream()
                .reduce(0, (x,y) -> x<y ? x : y);

    }

    public static Optional<Integer> findMaxWithOptional(List<Integer> integerList){
        return integerList.stream()
                .reduce(Integer::max);

    }

    public static Optional<Integer> findMinWithOptional(List<Integer> integerList){
        return integerList.stream()
                .reduce(Integer::min);
    }

    public static void main(String[] args) {
        List<Integer> arrayList = Arrays.asList(6,7,8,9,10);
        List<Integer> emptyList = new ArrayList<>();

        System.out.println(findMax(emptyList));  //we expect to get a NULL, since the list is empty but it gives a 0 as Max value which is wrong
        System.out.println(findMin(emptyList)); // we expect to get a NULL, since the list is empty but it gives a 0 as Min value which is wrong

       Optional<Integer> theMaxValue =  findMaxWithOptional(emptyList);
       Optional<Integer> theMinValue = findMinWithOptional(emptyList);

        Optional<Integer> theMaxValueWithOptional = findMaxWithOptional(arrayList);

       if(theMaxValue.isPresent()){
           System.out.println(theMaxValue.get());
       }else{
           System.out.println(theMaxValue);
           System.out.println("The input list is empty");
       }

        if(theMinValue.isPresent()){
            System.out.println(theMinValue.get());
        }else{
            System.out.println(theMinValue);
            System.out.println("The input list is empty");
        }

        if(theMaxValueWithOptional.isPresent()){
            System.out.println(theMaxValueWithOptional);
            System.out.println(theMaxValueWithOptional.get());
        }else{
            System.out.println(theMaxValueWithOptional);
            System.out.println("The input list is empty");
        }
    }
}
