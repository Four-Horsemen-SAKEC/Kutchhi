package com.example.kutchhi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    public WordAdapter(Context context, ArrayList<Word> words){
        super(context,0,words);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // return super.getView(position, convertView, parent);
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Word word = getItem(position);
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        TextView kutchhiTextView = (TextView) listItemView.findViewById(R.id.kutchhi_text_view);
        kutchhiTextView.setText(word.getKutchhiTranslation());
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(word.getDefaultTranslation());
        TextView kutchEngTextView = (TextView) listItemView.findViewById(R.id.kutch_eng_text_view);
        kutchEngTextView.setText(word.getKutchEngTranslation());
        if(word.hasImage()){
            imageView.setImageResource(word.getmResourceID());
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            imageView.setVisibility(View.GONE);
        }
        View textContainer = listItemView.findViewById(R.id.text_container);
        return listItemView;

    }
}

