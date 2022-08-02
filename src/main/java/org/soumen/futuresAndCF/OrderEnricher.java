package org.soumen.futuresAndCF;

import java.util.concurrent.Callable;

public class OrderEnricher implements Callable<String> {
    public OrderEnricher(String Order){
    }
    public String call() throws Exception {
        Thread.sleep(200);
        //return the thread name executing this callable task
        System.out.println("In Order Enricher");

        return Thread.currentThread().getName() + "order enriched";
    }

}