# MiWhipCodingTest
The APK can be run by cloning the project from the link https://github.com/AfreenHasheem/MiWhipCodingTest.git

Tool required to run the project : Android Studio
Once you clone the project, open it using Android Studio and run it on a real Android Device as this has been tested on a real device.
MainActivity.class consists of the UI changes and initial permissions required from the user's end for the application to access the phone's gps functionality. Only once the user allows will the data be sent to the server.



```
public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
            }
        }
    }
```

The latitude and longitude are sent to the server using the LocationManager . The paramaters(latitude and longitude) and sent Asynchronously in the LocationUpdater class. When the app is launched, a progress bar is shown until the data is fetched from the server. The data is written to the server through the link http://miwhip.casperon.co/loc_update.php. Once the latitude and longitude coordinates are fetched, the data is sent to the server using http POST request. The coordinates are sent continuously until GPS is on. If GPS is turned off, the location is fetched using the NETWORK_PROVIDER.
Once the data is fetched, the acknowledgement response is displayed on the app screen. For every fetch wait, there is a progress bar displayed for user interaction purposes.

The network connection is handled in the HttpHandler class.
LocationUpdaterTest is the unit testing module in this project
