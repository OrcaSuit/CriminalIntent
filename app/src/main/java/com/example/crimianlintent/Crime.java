package com.example.crimianlintent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;
//    public Date now;
//    private String mtime;
//    private DateFormat mDateFmt;

    public Crime(){
        mId = UUID.randomUUID();
        mDate =  new Date(); // 문제 발생.
//      now = new Date();
//      mtime=mDateFmt.format(now);

    }

//    public String gettime(){return mtime;}

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public Date getDate( ) {
        return mDate;
    }

    public void setDate(Date date) { mDate = date; }

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
