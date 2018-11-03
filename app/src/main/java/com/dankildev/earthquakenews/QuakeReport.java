package com.dankildev.earthquakenews;

public class QuakeReport {

    private double mMagnitude;
    private String mLocation;
    private long mTimeInMilliseconds;

    public QuakeReport(double magnitude, String location, long timeInMilliseconds){
        this.mMagnitude = magnitude;
        this.mLocation = location;
        this.mTimeInMilliseconds = timeInMilliseconds;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }
}
