package com.example.daniel.eventbus_example.withEventBus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.daniel.eventbus_example.POJOevent.MessageEvent;
import com.example.daniel.eventbus_example.R;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Daniel on 1/11/17.
 */

public class SenderEBFragment extends Fragment {

    Button senderEBButton;
    EditText senderEBEdtTxt;

    public SenderEBFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_sender, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        senderEBButton = (Button) getView().findViewById(R.id.wE_senderBtn);
        senderEBEdtTxt = (EditText) getView().findViewById(R.id.wE_nameEdTxt);

        senderEBButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new MessageEvent("Welcome " + senderEBEdtTxt.getText().toString()));
            }
        });

    }

}
