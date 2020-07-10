package com.example.kutchhi;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kutchhi.Fragments.FragmentColors;
import com.example.kutchhi.Fragments.FragmentFamily;
import com.example.kutchhi.Fragments.FragmentFood;
import com.example.kutchhi.Fragments.FragmentGrammar;
import com.example.kutchhi.Fragments.FragmentGreeting;
import com.example.kutchhi.Fragments.FragmentMeasurements;
import com.example.kutchhi.Fragments.FragmentNumbers;
import com.example.kutchhi.Fragments.FragmentPhrases;

public class HolderActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holder);
        String FragmentId = getIntent().getStringExtra("FragmentId");
        switch(FragmentId){
            case "1":
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new FragmentNumbers())
                        .commit();
                setTitleInBar("Numbers");
                break;
            case "2":
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new FragmentColors())
                        .commit();
                setTitleInBar("Colors");
                break;
            case "3":
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new FragmentFamily())
                        .commit();
                setTitleInBar("Family");
                break;
            case "4":
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new FragmentPhrases())
                        .commit();
                setTitleInBar("Phrases");
                break;
            case "5":
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new FragmentGreeting())
                        .commit();
                setTitleInBar("Greetings");
                break;
            case "6":
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new FragmentFood())
                        .commit();
                setTitleInBar("Food");
                break;
            case "7":
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new FragmentMeasurements())
                        .commit();
                setTitleInBar("Measurements");
                break;
            case "8":
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new FragmentGrammar())
                        .commit();
                setTitleInBar("Grammar");
                break;

            default:
                Log.e("App Crashed","Maa chudao");

        }
    }

    private void setTitleInBar(String title) {
        SpannableString s;
        s = new SpannableString(title);
        s.setSpan(new ForegroundColorSpan(Color.parseColor("#324755")), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(s);
        getSupportActionBar().setElevation(0);
    }
}