package com.example.kutchhi;

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mResourceID = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    public Word(String defaultTranslation, String miwokTranslation){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }
    public Word(String defaultTranslation, String miwokTranslation,int ResourceID){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mResourceID = ResourceID;
    }

    public int getmResourceID() {
        return mResourceID;
    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }
    public boolean hasImage(){
        return mResourceID!=NO_IMAGE_PROVIDED;
    }

}
