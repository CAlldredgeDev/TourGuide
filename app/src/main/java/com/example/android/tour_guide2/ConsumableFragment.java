package com.example.android.tour_guide2;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

//import android.support.annotation.Nullable;

public class ConsumableFragment extends Fragment {

    /**
     * Handles the actual playing of audio files
     */
    private MediaPlayer mMediaPlayer;

    /**
     * Handles audio focus when playing a sound file
     */
    private AudioManager mAudioManager;

    /**
     * This listener gets triggered whenever the audio focus changes
     * (i.e., we gain or lose audio focus because of another app or device).
     */
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };
    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    public ConsumableFragment() {
        //Required empty public contructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_listview, container, false);

        //Need that ArrayList to contain all the locations
        final ArrayList<Location> locations = new ArrayList<Location>();

        locations.add(new Location("BeerFest", R.drawable.ic_launcher_background, "Wednesday, May 2, 2018", "The Overlook", 38.2597607, -85.7442052, 16));
        locations.add(new Location("BourbonVille", R.drawable.ic_launcher_background, " Thursday, April 12, 2018", "The Louisville Palace", 38.2480633, -85.7578437, 17));
        locations.add(new Location("Chow Wagon", R.drawable.ic_launcher_background, "Thursday, April 26, 2018", "Waterfront Park", 38.2597871, -85.7460685, 17));
        locations.add(new Location("Night At Vincenzo’s", R.drawable.ic_launcher_background, "Sunday, June 10, 2018", "Vincenzo’s", 38.2556246, -85.7585259, 17));
        locations.add(new Location("Taste of Derby Festival", R.drawable.ic_launcher_background, "Tuesday, April 17, 2018", "Louisville Slugger Field", 38.256692, -85.7445172, 17));

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
        //Create the LocationAdpter that will read our Location. The adapter know how to create the list items.
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        return rootView;

    }

    @Override
    public void onStop() {
        super.onStop();

        //When the activity is stopped, release the media player resources because we won't
        //be playing any more sounds.
        releaseMediaPlayer();

    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();
            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

}
