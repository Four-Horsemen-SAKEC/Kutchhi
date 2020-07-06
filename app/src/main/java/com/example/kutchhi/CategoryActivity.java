package com.example.kutchhi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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
        CardView greetingCard = (CardView) findViewById(R.id.card_view_greeting);
        CardView foodCard = (CardView) findViewById(R.id.card_view_food);
        CardView measurementCard = (CardView) findViewById(R.id.card_view_measurements);
        CardView grammarCard = (CardView) findViewById(R.id.card_view_grammar);
        colorsCard.setOnClickListener(this);
        numbersCard.setOnClickListener(this);
        familyCard.setOnClickListener(this);
        phrasesCard.setOnClickListener(this);
        greetingCard.setOnClickListener(this);
        foodCard.setOnClickListener(this);
        measurementCard.setOnClickListener(this);
        grammarCard.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.card_view_numbers:
                intent = new Intent(getApplicationContext(), HolderActivity.class);
                intent.putExtra("FragmentId", "1");
                startActivity(intent);
                break;
            case R.id.card_view_colors:
                intent = new Intent(getApplicationContext(), HolderActivity.class);
                intent.putExtra("FragmentId", "2");
                startActivity(intent);
                break;
            case R.id.card_view_family:
                intent = new Intent(getApplicationContext(), HolderActivity.class);
                intent.putExtra("FragmentId", "3");
                startActivity(intent);
                break;
            case R.id.card_view_phrases:
                intent = new Intent(getApplicationContext(), HolderActivity.class);
                intent.putExtra("FragmentId", "4");
                startActivity(intent);
                break;
            case R.id.card_view_greeting:
                intent = new Intent(getApplicationContext(), HolderActivity.class);
                intent.putExtra("FragmentId", "5");
                startActivity(intent);
                break;
            case R.id.card_view_food:
                intent = new Intent(getApplicationContext(), HolderActivity.class);
                intent.putExtra("FragmentId", "6");
                startActivity(intent);
                break;
            case R.id.card_view_measurements:
                intent = new Intent(getApplicationContext(), HolderActivity.class);
                intent.putExtra("FragmentId", "7");
                startActivity(intent);
                break;
            case R.id.card_view_grammar:
                intent = new Intent(getApplicationContext(), HolderActivity.class);
                intent.putExtra("FragmentId", "8");
                startActivity(intent);
                break;
            default:
                break;
        }
    }


}