package org.soumen.futuresAndCF;

import java.util.concurrent.Callable;

import static java.lang.Thread.sleep;

public class InventoryChecker implements Callable {
    private Integer order;

    public InventoryChecker(Integer order) {
        this.order = order;
    }

    public Boolean call() throws Exception {
        sleep(200);
        if(this.order % 2 == 0)
            return Boolean.TRUE;
        else
            return Boolean.FALSE;
    }
}
