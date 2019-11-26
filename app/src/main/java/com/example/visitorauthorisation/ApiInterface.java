package com.example.visitorauthorisation;

import com.example.visitorauthorisation.Status;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

        @GET("{ledno}/{state}")
        Call<Status> controlLED(
                @Path("ledno") int ledno,
                @Path("state") String state
        );


}
