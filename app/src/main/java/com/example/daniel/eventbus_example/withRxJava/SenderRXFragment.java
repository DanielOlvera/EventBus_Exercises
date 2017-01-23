package com.example.daniel.eventbus_example.withRxJava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.daniel.eventbus_example.POJOevent.MessageEvent;
import com.example.daniel.eventbus_example.R;

/**
 * Created by Daniel on 1/12/17.
 */

public class SenderRXFragment extends Fragment {

    private static final String TAG = "SenderRXFragmentTAG_";
    private Button senderRxBtn;
    private EditText nameRxEdTxt;

    public SenderRXFragment() {
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

        nameRxEdTxt = (EditText) getView().findViewById(R.id.wE_nameEdTxt);
        senderRxBtn = (Button) getView().findViewById(R.id.wE_senderBtn);

        senderRxBtn.setOnClickListener(view -> MyRxBus
                .getInstance()
                .post(new MessageEvent("Welcome " + nameRxEdTxt.getText().toString())));

        Log.d(TAG, "onActivityCreated: ");
    }
}
