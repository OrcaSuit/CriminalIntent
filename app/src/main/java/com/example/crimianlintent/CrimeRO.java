package com.example.crimianlintent;

import java.util.Date;

import io.realm.RealmObject;

public class CrimeRO extends RealmObject {
    public String mId;
    public String mTitle;
    public Date mDate;
    public boolean mSolved;
}
