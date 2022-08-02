package org.soumen.futuresAndCF;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.*;

//Timer
//Change number of threads

public class FutureExample1 {

    //One order time taken from one stage to another 200+200+200 + some warm up time = 633ms
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Instant start = Instant.now();

        OrderFetcher orderFetcher = new OrderFetcher();
        Future<Integer> future1 = executor.submit(orderFetcher);

        InventoryChecker inventoryChecker = new InventoryChecker(future1.get());
        System.out.println("Order No is:- "+future1.get());
        Future<Boolean> future2 = executor.submit(inventoryChecker);

        PaymentAcceptor paymentAcceptor = new PaymentAcceptor(future2.get());
        System.out.println("IsInventoryPresent:- "+future2.get());

        Future<String> future3 = executor.submit(paymentAcceptor);
        System.out.println(future3.get());

        Instant end = Instant.now();
        long timeElapsed = Duration.between(start, end).toMillis();
        System.out.println("Total time: " + timeElapsed);
        executor.shutdown();

    }

}