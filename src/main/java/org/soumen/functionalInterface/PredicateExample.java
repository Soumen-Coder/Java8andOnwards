package org.soumen.functionalInterface;

import java.util.function.Predicate;

public class PredicateExample {
    static Predicate<Integer> p1 = i -> i % 2 == 0;
    static Predicate<Integer> p2 = i -> i>0 && i % 5==0;

    public static void main(String[] args) {
        boolean result = p1.and(p2).test(30);
        System.out.println(result);

        predicateAnd();
        predicateOr();
        predicateNegate();
    }

    public static void predicateAnd(){
        System.out.println(p1.and(p2).test(6));
        System.out.println(p1.and(p2).test(30));
    }

    public static void predicateOr(){
        System.out.println(p1.or(p2).test(6));
        System.out.println(p1.or(p2).test(22));
    }

    public static void predicateNegate(){
        System.out.println(p1.or(p2).negate().test(6));
        System.out.println(p1.and(p2).negate().test(30));
    }

}
