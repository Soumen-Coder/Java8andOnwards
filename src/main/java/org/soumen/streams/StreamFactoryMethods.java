package org.soumen.streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

//There are three factory methods of stream API : of(), iterate() and generate()
//of() takes in an infinite list of values
//iterate(seed, <UnaryOperator>) takes in a seed and a unary operator and generates an infinite stream, you can use limit to limit the number of values
//generate(<Supplier>) takes in a supplier to generate infinite values
public class StreamFactoryMethods {
    public static void main(String[] args) {
        Stream<Integer> integerStreamOf = Stream.of(1,2,3,4,5,6,7,8,9,10);

        Stream<Integer> integerStreamIterate = Stream.iterate(1, x->x*2).limit(10);

        Random random = new Random();
        Supplier<Integer> integerSupplier = () -> random.nextInt(100);
        Stream<Integer> integerStreamGenerate = Stream.generate(integerSupplier).limit(10);

        System.out.println("Stream using the of() factory method :- ");
        integerStreamOf.forEach(System.out::println);
        System.out.println("Stream using the iterate() factory method :- ");
        integerStreamIterate.forEach(System.out::println);
        System.out.println("Stream using the generate() factory method :- ");
        integerStreamGenerate.forEach(System.out::println);
    }
}
