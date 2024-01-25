package com.sarmadali.checkingsensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

    // Check for pedometer sensor
        Sensor pedometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        boolean hasPedometer = pedometerSensor != null;

    // Check for step detector sensor
        Sensor stepDetectorSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
        boolean hasStepDetector = stepDetectorSensor != null;


        if (hasPedometer || hasStepDetector) {
            // Allow the app to function
            Toast.makeText(this, "Padometer | Step Detector found", Toast.LENGTH_SHORT).show();
        } else {
            // Display a message to the user indicating the sensor requirements
            Toast.makeText(this, "Required Sensor not Found!", Toast.LENGTH_SHORT).show();
        }




    }
}