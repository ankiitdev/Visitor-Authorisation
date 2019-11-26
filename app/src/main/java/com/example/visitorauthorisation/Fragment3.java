package com.example.visitorauthorisation;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Fragment3 extends Fragment {

    ApiInterface apiInterface;
    Switch switch1,switch2;
    String state;
    int ledno;
    LinearLayout linearLayout;
    Snackbar snackbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ){
        final View view = inflater.inflate(R.layout.fragment_fragment3,container,false);

        switch1 = view.findViewById(R.id.switch1);
        switch2 = view.findViewById(R.id.switch2);
        linearLayout = view.findViewById(R.id.linearLayout);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                     state = "on";
                     ledno = 4;
                     controlLED();

                     snackbar = Snackbar.make(linearLayout,"Green LED is turned on!",Snackbar.LENGTH_SHORT);
                     snackbar.show();
                } else {
                    state = "off";
                    ledno = 4;
                    controlLED();
                    snackbar = Snackbar.make(linearLayout,"Green LED is turned off!",Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }
            }
        });

        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    state = "on";
                    ledno = 5;
                    controlLED();
                    snackbar = Snackbar.make(linearLayout,"White LED is turned on!",Snackbar.LENGTH_SHORT);
                    snackbar.show();
                } else {
                    state = "off";
                    ledno = 5;
                    controlLED();
                    snackbar = Snackbar.make(linearLayout,"White LED is turned off!",Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }
            }
        });


        return view;
    }

    private void controlLED(){
       apiInterface = APIClient.getClient().create(ApiInterface.class);
       Call<Status> call = apiInterface.controlLED(ledno,state);

       call.enqueue(new Callback<Status>() {
           @Override
           public void onResponse(Call<Status> call, Response<Status> response) {

               //Toast.makeText(getActivity(), "Success!", Toast.LENGTH_SHORT).show();

           }

           @Override
           public void onFailure(Call<Status> call, Throwable t) {
              // Toast.makeText(getActivity(), "Failure!", Toast.LENGTH_SHORT).show();
           }
       });
    }
}
