package com.example.crimianlintent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


public class Crime {
    private UUID mId;
    private String mTitle;
    private DateFormat mDate;
    private boolean mSolved;
    public Date now;
    private String mtime;

    public Crime(){
        mId = UUID.randomUUID();
        mDate =  new SimpleDateFormat("EEE, MMM d, ''yy");
        now = new Date();
        mtime=mDate.format(now);

    }

    public String gettime(){
        return mtime;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public DateFormat getDate( ) {
        return mDate;
    }

    public void setDate(DateFormat date) { mDate = date; }

    public UUID getId(){
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title){
        mTitle = title;
    }
}
