package biotrop.hrtz.mushroomcultivation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Budi on 10/1/2016.
 */

public class SeedAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public SeedAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FragmentF0 tab1 = new FragmentF0();
                return tab1;
            case 1:
                FragmentF1 tab2 = new FragmentF1();
                return tab2;
            case 2:
                FragmentF2 tab3 = new FragmentF2();
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
