package com.example.daniel.eventbus_example.withoutEventBus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daniel.eventbus_example.R;

public class ReceiverFragment extends Fragment {

    private TextView rcvrTxtVw;

    public ReceiverFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_receiver, container, false);

        View view = inflater.inflate(R.layout.fragment_receiver, container, false);

        rcvrTxtVw = (TextView) view.findViewById(R.id.wE_receiverTxtVw);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //rcvrTxtVw = (TextView) getView().findViewById(R.id.wE_receiverTxtVw);
        //rcvrTxtVw = (TextView) getActivity().findViewById(R.id.wE_receiverTxtVw);

    }

    public void updateInfo(String name){
        rcvrTxtVw.setText("Welcome " + name + "!");
        rcvrTxtVw.setVisibility(View.VISIBLE);
    }
}
