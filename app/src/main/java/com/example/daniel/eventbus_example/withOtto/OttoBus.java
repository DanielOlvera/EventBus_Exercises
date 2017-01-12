package com.example.daniel.eventbus_example.withOtto;

import com.squareup.otto.Bus;

/**
 * Created by Daniel on 1/12/17.
 */

public final class OttoBus {

    private static final Bus BUS = new Bus();

    public static Bus getInstance() {
        return BUS;
    }

    protected OttoBus() {
    }
}
