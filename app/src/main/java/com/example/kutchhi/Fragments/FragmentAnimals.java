package com.example.kutchhi.Fragments;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.kutchhi.R;
import com.example.kutchhi.Word;
import com.example.kutchhi.WordAdapter;

import java.util.ArrayList;

/**
Taken From Phrases
 */
public class FragmentAnimals extends Fragment {

    private MediaPlayer mediaPlayer;

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer.start();
            }
            else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);


        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Monkey", "vāñdro","वांद्रो",R.raw.placeholder_audio));
        words.add(new Word("Cat", "bilādee","बिलाड़ी",R.raw.placeholder_audio));
        words.add(new Word("Dog", "kūtto","कोत्तो",R.raw.placeholder_audio));
        words.add(new Word("Tiger", "vāgha","वाघ",R.raw.placeholder_audio));
        words.add(new Word("Elephant", "hāthee","हाथि",R.raw.placeholder_audio));
        words.add(new Word("Lion", "siñh","सिँह",R.raw.placeholder_audio));
        words.add(new Word("Snake", "sāpa","सप",R.raw.placeholder_audio));
        words.add(new Word("Camel", "Ūṇṭa","ऊंट",R.raw.placeholder_audio));
        words.add(new Word("Horse", "ghōḍō","गोडो",R.raw.placeholder_audio));
        words.add(new Word("Buffalo", "bhēnsa","भैंस",R.raw.placeholder_audio));
        words.add(new Word("Donkey", "dhaggo","ढगो",R.raw.placeholder_audio));
        words.add(new Word("Cow", "gāya","गाय",R.raw.placeholder_audio));
        WordAdapter adapter = new WordAdapter(getActivity(), words);
        ListView listView = (ListView) rootView.findViewById(R.id.wordlist);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                Word word= words.get(position);
                mediaPlayer = MediaPlayer.create(getActivity(), word.getAudioResource());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
        return rootView;
    }
}