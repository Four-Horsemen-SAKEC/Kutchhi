package com.example.kutchhi;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class FragmentNumbers extends Fragment {


    public FragmentNumbers() {
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
        words.add(new Word("one", "Hakāḍō","हकडो", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("two", "Ba","ब", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("three", "Ṭrā'ī","त्रै", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("four", "Cāra","चार", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("five", "Pān̄ca","पंज", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("six", "Cha","छः", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("seven", "Sat","सत", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("eight", "Ath","अठ", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("nine", "Nau","नॅा", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("ten", "one","डों", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("eleven", "Agyaaro","अग्यारो", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("twelve", "Bārō","बारो", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("thirteen", "Tērā'u","तेरौ", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("fourteen", "Cōḍḍō","चौडों", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("fifteen", "Pāṇḍrō","पंद्रो", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("sixteen", "Sōdō","सोळो", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("seventeen", "Satrō","सत्रौ", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("eighteen", "Ēlaḷō","एलळो", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("nineteen", "Ōganīsa","औगनीस", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("twenty", "Vīsa","वीस", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
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