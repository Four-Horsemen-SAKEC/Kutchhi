package com.example.kutchhi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_category);
        CardView colorsCard = (CardView) findViewById(R.id.card_view_colors); // creating a CardView and assigning a value.
        CardView numbersCard = (CardView) findViewById(R.id.card_view_numbers);
        CardView phrasesCard = (CardView) findViewById(R.id.card_view_phrases);
        CardView familyCard = (CardView) findViewById(R.id.card_view_family);
        colorsCard.setOnClickListener(this);
        numbersCard.setOnClickListener(this);
        familyCard.setOnClickListener(this);
        phrasesCard.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        Intent mainActivity = new Intent(getApplicationContext(),  HolderActivity.class);
        startActivity(mainActivity);

    }


}