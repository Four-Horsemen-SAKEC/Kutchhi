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


public class FragmentPhrases extends Fragment {

    public FragmentPhrases() {
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);


        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you going?", "ein kadā vannotā?","आईं कडा वनोता",R.raw.phra1));
        words.add(new Word("What is your name?", "aanjo nālo koro aaye?","आंजो नालो कोरो आय ?",R.raw.phra2));
        words.add(new Word("My name is (Name)", "Mujho nālo (Name) aaye","मुजो  नालो (name ) आय। ",R.raw.phra3));
        words.add(new Word("How are you?", "ein ki aayo?","आयीँ क़ि अयो ?",R.raw.phra4));
        words.add(new Word("I’m good.", "aaun majja me aiyan","आऊं मज्जामें अऐयां ",R.raw.phra5));
        words.add(new Word("Are you coming?", "ein aachotā?","आईं अच्चोंता?",R.raw.phra6));
        words.add(new Word("Yes, I’m coming.", "Haan, Aaun accha to(male)/ti(female)","हाँ, आऊं अच्चा तो/ती",R.raw.phra7));
        words.add(new Word("I’m coming.", "Aaun accha to(male)/ti(female)","आऊं अच्चा तो/ती",R.raw.phra8));
        words.add(new Word("Let’s go.", "hallaw","हलो",R.raw.phra9));
        words.add(new Word("Come here.", "heda acch","हेडा अच्च",R.raw.phra10));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(getActivity(), words);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.wordlist);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
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

        // Inflate the layout for this fragment
        return rootView;
    }
}