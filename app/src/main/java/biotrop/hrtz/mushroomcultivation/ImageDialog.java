package biotrop.hrtz.mushroomcultivation;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Webmaster on 9/6/2016.
 */
public class ImageDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = ((Activity)getActivity()).getLayoutInflater();
        View alertView = inflater.inflate(R.layout.dialog_image_gallery, null);
        builder.setView(alertView);

        // Create the AlertDialog object and return it
        return builder.create();
    }
}
