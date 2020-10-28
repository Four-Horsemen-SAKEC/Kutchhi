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

public class FragmentColors extends Fragment {

    public FragmentColors() {
        // Required empty public constructor
    }

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        // Inflate the layout for this fragment
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("red", "Laal","लाल", R.drawable.color_red,R.raw.placeholder_audio));
        words.add(new Word("green", "Haro","हरो", R.drawable.color_green,R.raw.placeholder_audio));
        words.add(new Word("brown", "Bhuro","भूरो", R.drawable.color_brown,R.raw.placeholder_audio));
        words.add(new Word("gray", "Bhūkharā","भूखारा", R.drawable.color_gray,R.raw.placeholder_audio));
        words.add(new Word("black", "Kaado","काळो", R.drawable.color_black,R.raw.placeholder_audio));
        words.add(new Word("white", "dhhoro","धोरो", R.drawable.color_white,R.raw.placeholder_audio));
        words.add(new Word("yellow", "peedo","पीळो", R.drawable.color_mustard_yellow,R.raw.placeholder_audio));
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