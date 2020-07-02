package com.example.kutchhi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentColors extends Fragment {

    public FragmentColors() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        // Inflate the layout for this fragment
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("red", "weṭeṭṭi", R.drawable.color_red));
        words.add(new Word("green", "chokokki", R.drawable.color_green));
        words.add(new Word("brown", "ṭakaakki", R.drawable.color_brown));
        words.add(new Word("gray", "ṭopoppi", R.drawable.color_gray));
        words.add(new Word("black", "kululli", R.drawable.color_black));
        words.add(new Word("white", "kelelli", R.drawable.color_white));
        words.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow));
        words.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow));
        WordAdapter itemsAdapter = new WordAdapter(getActivity(), words);
        ListView listView = (ListView) rootView.findViewById(R.id.wordlist);
        listView.setAdapter(itemsAdapter);
        return rootView;
    }
}