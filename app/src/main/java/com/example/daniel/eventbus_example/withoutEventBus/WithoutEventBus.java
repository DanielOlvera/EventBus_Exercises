package com.example.daniel.eventbus_example.withoutEventBus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.daniel.eventbus_example.R;

public class WithoutEventBus extends AppCompatActivity implements FragmentsCommunicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_without_event_bus);
    }


    @Override
    public void setName(String name) {
        ReceiverFragment receiver = (ReceiverFragment)
                getSupportFragmentManager().findFragmentById(R.id.wE_receiverFrag);

        receiver.updateInfo(name);
    }
}


/*
References:
    https://www.youtube.com/watch?v=2c0Iog5rfxo
 */