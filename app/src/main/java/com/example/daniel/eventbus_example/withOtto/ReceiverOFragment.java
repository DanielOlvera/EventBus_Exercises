package com.example.daniel.eventbus_example.withOtto;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daniel.eventbus_example.POJOevent.MessageEvent;
import com.example.daniel.eventbus_example.R;
import com.squareup.otto.Subscribe;

/**
 * Created by Daniel on 1/12/17.
 */

public class ReceiverOFragment extends Fragment {

    private TextView nameTxtVw;

    public ReceiverOFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_receiver, container, false);

        nameTxtVw = (TextView) view.findViewById(R.id.wE_receiverTxtVw);

        return view;
    }

    @Subscribe
    public void onMessage(MessageEvent event){
        nameTxtVw.setText(event.getMessage());
    }

    @Override
    public void onStart() {
        super.onStart();
        OttoBus.getInstance().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        OttoBus.getInstance().unregister(this);
    }
}
