package com.example.daniel.eventbus_example.withRxBus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daniel.eventbus_example.POJOevent.MessageEvent;
import com.example.daniel.eventbus_example.R;
import com.hwangjr.rxbus.annotation.Subscribe;

/**
 * Created by Daniel on 1/23/17.
 */

public class ReceiverRxBFragment extends Fragment {

    private TextView nameRxBTxtVw;

    public ReceiverRxBFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_receiver, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        nameRxBTxtVw = (TextView) getView().findViewById(R.id.wE_receiverTxtVw);
    }

    @Subscribe
    public void onMessage(MessageEvent event){
        nameRxBTxtVw.setText(event.getMessage() + "!");
    }

    @Override
    public void onStart() {
        super.onStart();
        RxBus.getInstance().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RxBus.getInstance().unregister(this);
    }
}
