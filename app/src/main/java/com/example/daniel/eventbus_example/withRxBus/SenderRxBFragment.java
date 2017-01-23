package com.example.daniel.eventbus_example.withRxBus;

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

/**
 * Created by Daniel on 1/23/17.
 */

public class SenderRxBFragment extends Fragment {

    private EditText nameRxBEdTxt;
    private Button senderRxbBtn;

    public SenderRxBFragment() {
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

        nameRxBEdTxt = (EditText) getView().findViewById(R.id.wE_nameEdTxt);
        senderRxbBtn = (Button) getView().findViewById(R.id.wE_senderBtn);

        senderRxbBtn.setOnClickListener(view -> RxBus
                .getInstance()
                .post(new MessageEvent("Welcome " + nameRxBEdTxt.getText().toString())));
    }
}
