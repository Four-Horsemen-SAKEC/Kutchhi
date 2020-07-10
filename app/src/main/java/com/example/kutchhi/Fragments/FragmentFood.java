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
        words.add(new Word("Dabeli", "Ḍābēlī","दाबेली", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("Jalebi", "Jalēbī","जलेबी", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("Thepla", "Thēpalā","थेपला", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("Khakhra", "Khākharā","खाखरा", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("Khichdi", "Khīcaḍī","खिचड़ी", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("Kadhi", "Kaḍhī","कढ़ी", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("Undhiyo", "Undhīyu","ऊंधियो", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("Rotlo", "Rōṭalō","रोटलो", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("Kharibhat", "Khārībhātha","खारीभाथ", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("Pakwan", "Pakavāna","पकवान", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("Sata", "Sātā","साटा", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("Khandvi", "Khaṇḍavī","खांडवी", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("Patra", "Pātrā","पात्रा", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("Khaman", "Khamaṇa","खमण", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("Muthia", "Muthiyā","मुठिया", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("Osaman", "Ōsōmana","ओसामण", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("Lachko", "Lacakō","लच्चको", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("Chhai (aka Kutchi Beer)", "Chāya","छाय", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("Monhan thal", "Mōhanathāḷa","मोहनथाल", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
        words.add(new Word("Lilva Kachori", "Līlavā kacōrī","लिलवा कचोरी", R.drawable.ic_launcher_foreground,R.raw.placeholder_audio));
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