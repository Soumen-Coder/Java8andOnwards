package org.soumen.futuresAndCF;

import java.util.concurrent.Callable;

public class PaymentAcceptor implements Callable<String> {
    private boolean inventoryPresent;

    public PaymentAcceptor(Boolean inventoryPresent){
        this.inventoryPresent = inventoryPresent;
    }

    public String call() throws Exception {
       Thread.sleep(200);
        //return the thread name executing this callable task
        System.out.println("In Payment Acceptor");

        if(inventoryPresent){
            return Thread.currentThread().getName() + " Payment accepted";
        }
        else{
            return Thread.currentThread().getName() + " Payment not accepted";
        }
    }

}