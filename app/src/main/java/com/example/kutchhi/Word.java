package com.example.kutchhi;

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mResourceID = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mAudioResourceID;
    public Word(String defaultTranslation, String miwokTranslation,int audioResourceID){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceID =  audioResourceID;
    }
    public Word(String defaultTranslation, String miwokTranslation,int ResourceID,int audioResourceID){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mResourceID = ResourceID;
        mAudioResourceID =  audioResourceID;
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

    public int getmAudioResourceID() {
        return mAudioResourceID;
    }
}
