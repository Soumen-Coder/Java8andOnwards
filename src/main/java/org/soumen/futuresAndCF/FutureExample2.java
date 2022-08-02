package org.soumen.futuresAndCF;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Instant start = Instant.now();

        //the time increases linearly with order, series execution - 1 order in FExample took 618ms, 10 orders here took 6189ms
        //issues : return to main for each stage of order 9*3 = 27times
        //Callable mechanism for passing value : Need to wait for previous stages return value before submitting task to executor service
        //Problems of using futures
        for(int i=0; i<=9; i++) {
            OrderFetcher orderFetcher = new OrderFetcher();
            Future<Integer> future1 = executor.submit(orderFetcher);

            InventoryChecker inventoryChecker = new InventoryChecker(future1.get());
            System.out.println("Order No is:- " + future1.get());
            Future<Boolean> future2 = executor.submit(inventoryChecker);

            PaymentAcceptor paymentAcceptor = new PaymentAcceptor(future2.get());
            System.out.println("IsInventoryPresent:- " + future2.get());

            Future<String> future3 = executor.submit(paymentAcceptor);
            System.out.println(future3.get());
        }

            Instant end = Instant.now();
            long timeElapsed = Duration.between(start, end).toMillis();
            System.out.println("Total time: " + timeElapsed);
            executor.shutdown();

    }
}
