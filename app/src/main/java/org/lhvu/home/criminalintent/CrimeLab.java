package org.lhvu.home.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Hung on 18/12/2016.
 */

public class CrimeLab {
    private static CrimeLab sCrimeLab;

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {
        for(Crime crime: mCrimes) {
            //id could be serialized so wrong to compare object
            if (crime.getId().toString().equals(id.toString())) {
                return crime;
            }
        }
        return null;
    }


    public int getPosition(UUID id) {
        for(int i = 0; i< mCrimes.size(); i++) {
            Crime crime = mCrimes.get(i);
            //id could be serialized so wrong to compare object
            if (crime.getId().toString().equals(id.toString())) {
                return i;
            }
        }
        return -1;
    }

    private List<Crime> mCrimes;

    //singleton
    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    //singleton
    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
        for (int i = 0; i<100; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime #"+i);
            crime.setSolved(i%2==0); // every even one
            mCrimes.add(crime);
        }
    }


}
