package biotrop.hrtz.mushroomcultivation;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.VideoView;

/**
 * Created by Webmaster on 9/13/2016.
 */
public class FragmentBaglogTreatment extends Fragment {
    private TextView tvAlat, tvCara;


    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.content_baglog_treatment, parent, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        tvAlat = (TextView)view.findViewById(R.id.baglog_treatment_tv_alatbahan);
        tvCara = (TextView)view.findViewById(R.id.baglog_treatment_tv_procedure);


        String alat = getResources().getString(R.string.baglog_treatment_tool);
        tvAlat.setText(Html.fromHtml(alat, null, new MyTagHandler()));
        String langkah = getResources().getString(R.string.baglog_treatment_procedure);
        tvCara.setText(Html.fromHtml(langkah, null, new MyTagHandler()));

//                "<iframe style='display: block; max-width:100%;' src=\"https://www.youtube.com/embed/Ml8oFMlhMvU\"" +
//                " frameborder=\"0\" allowfullscreen></iframe></html>";
//        Log.d("width", frameVideo);
//        displayVideo.setWebViewClient(new WebViewClient(){

    }

}
