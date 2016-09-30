package biotrop.hrtz.mushroomcultivation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Webmaster on 9/13/2016.
 */
public class FragmentHarvest extends Fragment {
    private TextView tvAlat, tvCara;


    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.content_harvest, parent, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        tvAlat = (TextView)view.findViewById(R.id.harvest_tv_alatbahan);
        tvCara = (TextView)view.findViewById(R.id.harvest_tv_procedure);


        String alat = getResources().getString(R.string.harvest_tool);
        tvAlat.setText(Html.fromHtml(alat, null, new MyTagHandler()));
        String langkah = getResources().getString(R.string.harvest_procedure);
        tvCara.setText(Html.fromHtml(langkah, null, new MyTagHandler()));

    }

    public void cvClicked(View v){

    }
}
