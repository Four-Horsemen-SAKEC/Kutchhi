package com.example.kutchhi;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class HolderActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_holder);
        String FragmentId = getIntent().getStringExtra("FragmentId");
        switch(FragmentId){
            case "1":
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new FragmentNumbers())
                        .commit();
                break;
            case "2":
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new FragmentColors())
                        .commit();
                break;
            case "3":
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new FragmentFamily())
                        .commit();
                break;
            case "4":
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new FragmentPhrases())
                        .commit();
                break;
            case "5":
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new FragmentGreeting())
                        .commit();
                break;
            case "6":
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new FragmentFood())
                        .commit();
                break;
            case "7":
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new FragmentMeasurements())
                        .commit();
                break;
            case "8":
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new FragmentGrammar())
                        .commit();
                break;

            default:
                Log.e("App Crashed","Maa chudao");

        }
    }
}