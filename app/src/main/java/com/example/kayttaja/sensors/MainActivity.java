package com.example.kayttaja.sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    SensorManager sensorManager;
    SensorEventListener sensorEventListener;
    SensorEvent event;

    float mValues[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //compassView = (CompassView)this.findViewById(R.id.compassView);

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);

        Sensor valo = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorManager.registerListener(sensorEventListener, valo, SensorManager.SENSOR_DELAY_FASTEST);

        private final SensorEventListener sensorEventLsitener = new SensorEventListener {
            public void onSensorChanged(SensorEvent event)
            {
                int apu=0;

                if (event.sensor.getType() == Sensor.TYPE_LIGHT)
                    mValues = event.values;   // palauttaa arvot taulukkona
                apu = apu + (int) event.values[0];
                System.out.println(apu);
            }
        }

        public void onAccuracyChanged(Sensor sensor, int accuracy)
        {}
    }


}
