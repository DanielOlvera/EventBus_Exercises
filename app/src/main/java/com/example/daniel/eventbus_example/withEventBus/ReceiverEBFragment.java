package com.example.daniel.eventbus_example.withEventBus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daniel.eventbus_example.POJOevent.MessageEvent;
import com.example.daniel.eventbus_example.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by Daniel on 1/11/17.
 */

public class ReceiverEBFragment extends Fragment {

    private TextView nameTxtVw;

    private EventBus eventBus = EventBus.getDefault();

    public ReceiverEBFragment() {
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
        Toast.makeText(getActivity(), event.message, Toast.LENGTH_SHORT).show();
        nameTxtVw.setText(event.message + "!");
    }

    @Override
    public void onStart() {
        super.onStart();
        eventBus.register(this); //Registering this fragment in the bus
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        eventBus.unregister(this); //Unregistering this fragment in the bus
    }


}
