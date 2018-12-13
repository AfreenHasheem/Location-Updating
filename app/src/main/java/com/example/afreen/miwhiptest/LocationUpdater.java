package com.example.afreen.miwhiptest;

import android.app.Activity;
import android.app.ProgressDialog;
import android.location.Location;
import android.os.AsyncTask;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class LocationUpdater extends AsyncTask<Location,Void, String> {


    OnDataSendToActivity dataSendToActivity;
    private ProgressDialog progressDialog;


    public LocationUpdater(Activity activity) {

        progressDialog = new ProgressDialog(activity);
        dataSendToActivity = (OnDataSendToActivity)activity;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.setMessage("Fetching response, please wait...");
        progressDialog.show();
    }

    public String updateLocation(Double latitude, Double longitude) {

        Map<String, String> parameters = new HashMap<>();
        parameters.put("latitude", latitude.toString());
        parameters.put("longitude", longitude.toString());
        HttpHandler httpHandler = new HttpHandler();
        return httpHandler.performPostCall("http://miwhip.casperon.co/loc_update.php", parameters);
    }

    @Override
    protected String doInBackground(Location... locations) {

            Location location = locations[0];
            return updateLocation(location.getLatitude(), location.getLongitude());
    }

    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);

        Log.d("onPostExec Response" , response);
        dataSendToActivity.sendData(response);
        if(progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }


    }
}
