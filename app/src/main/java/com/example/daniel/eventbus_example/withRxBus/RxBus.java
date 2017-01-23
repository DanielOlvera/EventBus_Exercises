package com.example.daniel.eventbus_example.withRxBus;

import com.hwangjr.rxbus.Bus;

/**
 * Created by Daniel on 1/23/17.
 */
public class RxBus {
    private static Bus ourInstance = new Bus();

    public static Bus getInstance() {
        return ourInstance;
    }

    protected RxBus() {
    }
}
