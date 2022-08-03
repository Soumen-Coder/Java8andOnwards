package org.soumen.collections;

import java.util.Comparator;

//With my own implementation
public class ComparatorLambdas {
    public static void main(String[] args) {
        //prior Java 8
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2){
                    return 5;
                }if(o1<o2){
                    return 1;
                }else
                    return 9;
            }
        };

        System.out.println(comparator.compare(8, 5));


        //After Java 8
        Comparator<Integer> comparatorNew = (o1, o2) -> {
            if(o1>o2){
                return 5;
            }if(o1<o2){
                return 1;
            }else
                return 9;
        };

        System.out.println(comparatorNew.compare(3, 5));
    }
}
