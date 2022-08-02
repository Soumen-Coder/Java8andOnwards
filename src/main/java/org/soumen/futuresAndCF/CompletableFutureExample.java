package org.soumen.futuresAndCF;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.lang.Thread.sleep;

//Executes in parallel
//All orders are fetched in parallel though it waits for the prev stage to process and consume but it executes in parallel
//Does return to main after each stage of an order
//only 250ms to complete the 10 order tasks
public class CompletableFutureExample {

    public CompletableFutureExample() {
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Instant start = Instant.now();
        System.out.println("Start time :- "+start);

        Supplier<Integer> orderFetcher = () -> {
            try {
                sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int random = ThreadLocalRandom.current().nextInt(6);
            System.out.println("Order :- "+ random+" generated");
            return random;
        };

        Function<Integer, Boolean> inventoryChecker = orderNumber -> {
            try {
                sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(orderNumber % 2 == 0)
                return Boolean.TRUE;
            else
                return Boolean.FALSE;
        };

        Consumer<Boolean> paymentAcceptor = isInventoryPresent -> {
            try {
                sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(isInventoryPresent){
                System.out.println("Payment accepted");
            }else{
                System.out.println("Payment not accepted");
            }
            Instant end = Instant.now();
            System.out.println("End time :-"+end);
        };

        for(int i=0; i<=9; i++) {
            CompletableFuture cf1 = CompletableFuture.supplyAsync(orderFetcher, executorService)
                    .thenApply(inventoryChecker)
                    .thenAccept(paymentAcceptor);
        }
        executorService.shutdown();
    }
}
