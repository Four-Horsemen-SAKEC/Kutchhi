package com.example.kutchhi;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class HolderActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holder);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new FragmentColors())
                .commit();
    }
}