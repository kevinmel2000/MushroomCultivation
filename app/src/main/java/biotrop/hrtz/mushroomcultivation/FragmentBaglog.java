package biotrop.hrtz.mushroomcultivation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

/**
 * Created by Webmaster on 9/13/2016.
 */
public class FragmentBaglog extends Fragment {
    private TextView tvAlat, tvCara;
    private YouTubePlayer YPlayer;

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.content_baglog, parent, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        tvAlat = (TextView)view.findViewById(R.id.baglog_tv_alatbahan);
        tvCara = (TextView)view.findViewById(R.id.baglog_tv_procedure);
        String alat = getResources().getString(R.string.baglog_tool);
        tvAlat.setText(Html.fromHtml(alat, null, new MyTagHandler()));
        String langkah = getResources().getString(R.string.baglog_procedure);
        tvCara.setText(Html.fromHtml(langkah, null, new MyTagHandler()));
        YouTubePlayerSupportFragment youTubePlayerFragment = (YouTubePlayerSupportFragment) getChildFragmentManager()
                .findFragmentById(R.id.youtube_fragment);

        youTubePlayerFragment.initialize(KEYS.DEVELOPER_KEY, new YouTubePlayer.OnInitializedListener() {

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider arg0, YouTubePlayer youTubePlayer, boolean b) {
                if (!b) {
                    YPlayer = youTubePlayer;
                    YPlayer.cueVideo("yYT0d6JHUEk");
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider arg0, YouTubeInitializationResult arg1) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getContext(), YoutubePlayerActivity.class);
                intent.putExtra("videoID", "yYT0d6JHUEk");
                startActivity(intent);
            }
        });

    }

    @Override
    public void onPause() {
        Log.d("pause", "is called");
        if(YPlayer != null)YPlayer.pause();
        super.onPause();
    }
}
