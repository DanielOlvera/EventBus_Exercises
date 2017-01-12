package com.example.daniel.eventbus_example.withoutEventBus;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.daniel.eventbus_example.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SenderFragment extends Fragment{

    private static final String TAG = "SenderFragmentTAG_";
    Button senderButton;
    EditText senderEditText;

    FragmentsCommunicator fragmentsCommunicator;


    public SenderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_sender, container, false);

        View view = inflater.inflate(R.layout.fragment_sender, container, false);

        senderEditText = (EditText) view.findViewById(R.id.wE_nameEdTxt);
        senderButton = (Button) view.findViewById(R.id.wE_senderBtn);

        senderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usrName = senderEditText.getText().toString();
                fragmentsCommunicator.setName(usrName);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        try {
            fragmentsCommunicator = (FragmentsCommunicator) getActivity();
        } catch (Exception e){
            Log.d(TAG, "onActivityCreated: ");
        }

    }

}
