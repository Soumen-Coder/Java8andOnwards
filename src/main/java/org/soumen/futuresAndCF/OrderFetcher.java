package org.soumen.futuresAndCF;

import java.util.Random;
import java.util.concurrent.Callable;

import static java.lang.Thread.sleep;

public class OrderFetcher implements Callable<Integer> {
    public static Random random;

    public OrderFetcher(){
        random = new Random();
    }

    public Integer call() throws Exception {
        sleep(200);// Network and DB calls simulator
        return random.nextInt(6);
    }
}
