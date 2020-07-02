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
import androidx.core.content.ContextCompat;

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

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(word.getMiwokTranslation());
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(word.getDefaultTranslation());
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

