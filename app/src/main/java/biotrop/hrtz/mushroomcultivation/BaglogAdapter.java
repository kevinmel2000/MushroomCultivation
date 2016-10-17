package biotrop.hrtz.mushroomcultivation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Budi on 10/1/2016.
 */

public class BaglogAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public BaglogAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FragmentBaglog tab1 = new FragmentBaglog();
                return tab1;
            case 1:
                FragmentBaglogTreatment tab2 = new FragmentBaglogTreatment();
                return tab2;
            case 2:
                FragmentHarvest tab3 = new FragmentHarvest();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
