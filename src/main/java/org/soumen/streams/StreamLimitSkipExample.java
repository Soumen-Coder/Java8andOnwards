package org.soumen.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//Stream API : Limit(n) - To limit the number of elements to be processed by the stream - Just those number of elements will be processed
//Stream API : skip(n) - To skip the number of elements from the stream
//These are also known for short-circuiting, since you don't have to travel the entire stream, also anyMatch() can be considered the same
public class StreamLimitSkipExample {

    public static Optional<Integer> limit(List<Integer> integerList){
        return integerList.stream()
                .limit(2)
                .reduce(Integer::sum);

    }

    public static Optional<Integer> skip(List<Integer> integerList){
        return integerList.stream()
                .skip(2)
                .reduce(Integer::sum);

    }

    public static void main(String[] args) {
        Optional<Integer> limitTwoElements = limit(Arrays.asList(1,2,3,4,5));
        Optional<Integer> skipTwoElements = skip(Arrays.asList(1,2,3,4,5));

        limitTwoElements.ifPresent(System.out::println);
        skipTwoElements.ifPresent(System.out::println);
    }
}
