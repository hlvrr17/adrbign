package org.lhvu.home.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by Hung on 18/12/2016.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
