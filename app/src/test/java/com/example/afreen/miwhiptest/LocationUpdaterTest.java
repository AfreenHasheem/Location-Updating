package com.example.afreen.miwhiptest;

import android.content.Context;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class LocationUpdaterTest {

    @Test
    public void http_test() {
        LocationUpdater locationUpdater = new LocationUpdater();

        String response = locationUpdater.updateLocation(0.0 , 0.0);
        assertTrue(response.contains("Location Updated"));
    }
}