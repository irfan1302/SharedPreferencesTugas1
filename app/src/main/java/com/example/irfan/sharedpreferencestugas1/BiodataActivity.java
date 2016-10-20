package com.example.irfan.sharedpreferencestugas1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by irfan on 10/20/2016.
 */

public class BiodataActivity extends AppCompatActivity {


    TextView no, nam;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.biodata);

        no = (TextView) findViewById(R.id.nim);
        nam = (TextView) findViewById(R.id.nama);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(BiodataActivity.this);
        String ni = sharedPreferences.getString(MainActivity.KEY_SHARED, null);
        String na = sharedPreferences.getString(MainActivity.KEY_SHARED_TWO, null);

        no.setText(ni);
        nam.setText(na);



    }
}