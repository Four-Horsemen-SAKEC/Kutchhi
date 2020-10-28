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

public class FragmentFamily extends Fragment {


    public FragmentFamily(){

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

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.word_list, container, false);


        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("father", "Adhha/Baapu","बापू  ", R.drawable.family_father,R.raw.placeholder_audio));
        words.add(new Word("mother", "Maa","माँ ", R.drawable.family_mother,R.raw.placeholder_audio));
        words.add(new Word("son", "Pottar","पोत्तर ", R.drawable.family_son,R.raw.placeholder_audio));
        words.add(new Word("daughter", "Dhee","धी ", R.drawable.family_daughter,R.raw.placeholder_audio));
        words.add(new Word("older brother", "Vado bhaa","वडो भा ", R.drawable.family_older_brother,R.raw.placeholder_audio));
        words.add(new Word("younger brother", "Nendho Bhaa","नंधो भा ", R.drawable.family_younger_brother,R.raw.placeholder_audio));
        words.add(new Word("older sister", "Vadi Bhenn","वडी भेण ", R.drawable.family_older_sister,R.raw.placeholder_audio));
        words.add(new Word("younger sister", "Nendhi Bhenn","नंढी  भेण ", R.drawable.family_younger_sister,R.raw.placeholder_audio));
        words.add(new Word("grandmother ", "Daadi (paternal) / Naani (maternal)","दादी / नानी ", R.drawable.family_grandmother,R.raw.placeholder_audio));
        words.add(new Word("grandfather", "Daada (paternal) / Naana (maternal)","दादा / नाना ", R.drawable.family_grandfather,R.raw.placeholder_audio));

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