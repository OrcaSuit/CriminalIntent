package com.example.crimianlintent;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

public class CrimeLab {
    private static CrimeLab sCrimeLab;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
        mContext = context.getApplicationContext();
        Realm.init(mContext);
    }

    public void addCrime(final Crime c) {
        Realm mRealm = Realm.getDefaultInstance();
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                CrimeRO crime = realm.createObject(CrimeRO.class);
                crime.mId = c.getId().toString();
                crime.mTitle = c.getTitle();
                crime.mDate = c.getDate();
                crime.mSolved = c.isSolved();
            }
        });
        mRealm.close();
    }

    public List<Crime> getCrimes() {
        List<Crime> crimes = new ArrayList<>();
        Realm mRealm = Realm.getDefaultInstance();

        try {
            RealmResults<CrimeRO> results = mRealm.where(CrimeRO.class).findAll();

            for (int i = 0; i < results.size(); i++) {
                Crime crime = new Crime();

                crime.setId(results.get(i).mId);
                crime.setTitle(results.get(i).mTitle);
                crime.setDate(results.get(i).mDate);
                crime.setSolved(results.get(i).mSolved);

                crimes.add(crime);
            }
        } finally {
            if (mRealm != null) {
                mRealm.close();
            }
        }

        mRealm.close();

        return crimes;
    }

    public Crime getCrime(UUID id) {

        Realm mRealm = Realm.getDefaultInstance();
        CrimeRO result = mRealm.where(CrimeRO.class).equalTo("mId", id.toString()).findFirst();

        Crime crime = new Crime();

        crime.setId(result.mId);
        crime.setTitle(result.mTitle);
        crime.setDate(result.mDate);
        crime.setSolved(result.mSolved);

        mRealm.close();

        return crime;
    }

    public void updateCrime(final Crime crime) {

        Realm mRealm = Realm.getDefaultInstance();
        final CrimeRO result = mRealm.where(CrimeRO.class).equalTo("mId", crime.getId().toString()).findFirst();

        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                result.mTitle = crime.getTitle();
                result.mDate = crime.getDate();
                result.mSolved = crime.isSolved();
            }
        });

        mRealm.close();
    }
}
