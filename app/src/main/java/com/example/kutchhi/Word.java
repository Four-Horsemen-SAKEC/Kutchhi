package com.example.kutchhi;

public class Word {
    private String mDefaultTranslation;
    private String mKutchhiTranslation;
    private int mResourceID = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mAudioResource;
    public Word(String defaultTranslation, String kutchhiTranslation,int mAudioResource){
        mDefaultTranslation = defaultTranslation; mKutchhiTranslation = kutchhiTranslation;
        this.mAudioResource=mAudioResource;

    }
    public Word(String defaultTranslation, String kutchhiTranslation,int ResourceID,int mAudioResource){
        mDefaultTranslation = defaultTranslation; mKutchhiTranslation = kutchhiTranslation;
        mResourceID = ResourceID;
        this.mAudioResource = mAudioResource;
    }

    public int getmResourceID() {
        return mResourceID;
    }
    public int getAudioResource() {
        return mAudioResource;
    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }
    public String getKutchhiTranslation(){
        return mKutchhiTranslation;
    }
    public boolean hasImage(){
        return mResourceID!=NO_IMAGE_PROVIDED;
    }

}
