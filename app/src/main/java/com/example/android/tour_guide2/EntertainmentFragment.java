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

public class EntertainmentFragment extends Fragment {

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

    public EntertainmentFragment() {
        //Required empty public contructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_listview, container, false);

        //Need that ArrayList to contain all the locations
        final ArrayList<Location> locations = new ArrayList<Location>();

        locations.add(new Location("Great BalloonFest", R.drawable.ic_launcher_background, "Thursday, April 26, 2018", "Bowman Field/The Kentucky Exposition Center", 38.2286909, -85.6696377, 16));
        locations.add(new Location("Great Bed Races", R.drawable.ic_launcher_background, "Monday, April 30, 2018", "Broadbent Arena", 38.2005961, -85.7477826, 17));
        locations.add(new Location("Derby of the Dead Presented By Louisville Zombie Walk", R.drawable.ic_launcher_background, "Friday, April 27, 2018", "Waterfront, Great Lawn", 38.2588016, -85.746803, 18));
        locations.add(new Location("Horseshoe Foundation FamFest", R.drawable.ic_launcher_background, "Wednesday, April 11, 2018", "Downtown New Albany (Next to YMCA)", 38.2826687, -85.82391, 18));
        locations.add(new Location("Spring Fashion Show", R.drawable.ic_launcher_background, "Thursday, March 29, 2018", "Showroom, Horseshoe Southern Indiana", 38.179638, -85.9076035, 17));
        locations.add(new Location("Fest-a-Ville", R.drawable.ic_launcher_background, "Thursday, April 26, 2018", "Waterfront Park", 38.2597871, -85.7460685, 17));
        locations.add(new Location("Pegasus Parade", R.drawable.ic_launcher_background, "Thursday, May 3, 2018", "West on Broadway from Campbell to 9th St", 38.2445351, -85.7396596, 17));
        locations.add(new Location("Great Steamboat Race - Riverfront", R.drawable.ic_launcher_background, "Wednesday, May 2, 2018 ", "Riverfront", 38.2587993, -85.7570198, 16));
        locations.add(new Location("Texas Ho Ho Hold’Em Tournament", R.drawable.ic_launcher_background, "Saturday, November 4, 2017", "Horseshoe Casino Southern Indiana", 38.179638, -85.9076035, 17));
        locations.add(new Location("Texas Hold’Em Tournament", R.drawable.ic_launcher_background, "Tuesday, May 1, 2018", "Belle of Cincinnati, Docked at Kroger’s Fest-a-Ville", 38.2597607, -85.7442052, 16));
        locations.add(new Location("THUNDER OVER LOUISVILLE", R.drawable.ic_launcher_background, "Saturday, April 13, 2019", "Riverfront", 38.2636466, -85.7447083, 16));

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
