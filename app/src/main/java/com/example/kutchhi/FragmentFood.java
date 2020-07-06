package com.example.kutchhi;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
Taken From Numbers
 */
public class FragmentFood extends Fragment {

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
        words.add(new Word("one", "lutti", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("two", "otiiko", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("three", "tolookosu", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("four", "oyyisa", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("five", "massokka", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("six", "temmokka", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("seven", "kenekaku", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("eight", "kawinta", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("nine", "wo’e", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("ten", "na’aacha", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        WordAdapter itemsAdapter = new WordAdapter(getActivity(), words);
        ListView listView = (ListView) rootView.findViewById(R.id.wordlist);
        listView.setAdapter(itemsAdapter);
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