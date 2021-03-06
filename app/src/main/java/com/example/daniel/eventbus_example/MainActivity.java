package com.example.daniel.eventbus_example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.daniel.eventbus_example.withEventBus.WithEventBus;
import com.example.daniel.eventbus_example.withOtto.WithOTTO;
import com.example.daniel.eventbus_example.withRxBus.WithRxBus;
import com.example.daniel.eventbus_example.withRxJava.WithRxJava;
import com.example.daniel.eventbus_example.withoutEventBus.WithoutEventBus;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void woEventBus(View view) {
        Intent intent = new Intent(getApplicationContext(), WithoutEventBus.class);
        startActivity(intent);
    }

    public void wEventBus(View view) {
        Intent intent = new Intent(getApplicationContext(), WithEventBus.class);
        startActivity(intent);
    }

    public void wOTTO(View view) {
        Intent intent = new Intent(getApplicationContext(), WithOTTO.class);
        startActivity(intent);
    }

    public void wRxJava(View view) {
        Intent intent = new Intent(getApplicationContext(), WithRxJava.class);
        startActivity(intent);
    }

    public void wRxBus(View view) {
        Intent intent = new Intent(getApplicationContext(), WithRxBus.class);
        startActivity(intent);
    }
}

/*
References:

    http://gunhansancar.com/ease-communication-between-activities-fragments-services/#content-8
 */