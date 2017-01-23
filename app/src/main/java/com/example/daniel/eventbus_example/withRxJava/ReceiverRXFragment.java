package com.example.daniel.eventbus_example.withRxJava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daniel.eventbus_example.POJOevent.MessageEvent;
import com.example.daniel.eventbus_example.R;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by Daniel on 1/12/17.
 */

public class ReceiverRXFragment extends Fragment {

    private TextView nameTxtVw;

    private Subscription subscription;

    public ReceiverRXFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_receiver, container, false);

        nameTxtVw = (TextView) view.findViewById(R.id.wE_receiverTxtVw);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

       subscription = MyRxBus.getInstance().getEvents().subscribe(new Action1<Object>() {
           @Override
           public void call(Object o) {
               if(o instanceof MessageEvent){
                   // do something
                   nameTxtVw.setText(((MessageEvent) o).getMessage() + "!");
               }
           }
       });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        subscription.unsubscribe();
    }
}
