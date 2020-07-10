package com.example.kutchhi.OnStart;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.kutchhi.CategoryActivity;
import com.example.kutchhi.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter;
    TabLayout tsbIndicator;
    int position;
    Button getStartedBtn;
    Animation btnAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if(restorePrefsData()) {

            Intent mainActivity = new Intent(getApplicationContext(), SplashScreen.class);
            startActivity(mainActivity);
            finish();
        }

       getSupportActionBar().hide();

        setContentView(R.layout.activity_intro);
        tsbIndicator = findViewById(R.id.tab_indicator);
        getStartedBtn = findViewById(R.id.btn_get_started);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation);



        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Understand Kutchhi",R.drawable.s1));
        mList.add(new ScreenItem("Read. Listen. Learn",R.drawable.s2));
        mList.add(new ScreenItem("Interact",R.drawable.s3));

        screenPager=findViewById(R.id.screen_viewpager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this,mList);

        screenPager.setAdapter(introViewPagerAdapter);
        tsbIndicator.setupWithViewPager(screenPager);
        position=screenPager.getCurrentItem();
        tsbIndicator.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener()  {
            @Override
            public void onTabSelected(@NonNull TabLayout.Tab tab) {
                if(tab.getPosition() == mList.size()-1)  {
                    loadLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        getStartedBtn.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {

                Intent mainActivity = new Intent(getApplicationContext(), CategoryActivity.class);
                startActivity(mainActivity);
                savePrefsData();
                finish();
            }


        });

    }

    private boolean restorePrefsData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        return pref.getBoolean("isIntroOpened",false);
    }

    private void savePrefsData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpened",true).apply();
    }

    private void loadLastScreen() {
        getStartedBtn.setVisibility(View.VISIBLE);
        tsbIndicator.setVisibility(View.INVISIBLE);
        getStartedBtn.setAnimation(btnAnim);
    }
}