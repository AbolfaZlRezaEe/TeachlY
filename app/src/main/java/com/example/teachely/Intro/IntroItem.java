package com.example.teachely.Intro;

public class IntroItem {

    private String tvTitle;
    private String tvDescription;
    private int ivIntro;

    public IntroItem(String tvTitle, String tvDescription, int ivIntro) {
        this.tvTitle = tvTitle;
        this.tvDescription = tvDescription;
        this.ivIntro = ivIntro;
    }

    public String getTvTitle() {
        return tvTitle;
    }

    public void setTvTitle(String tvTitle) {
        this.tvTitle = tvTitle;
    }

    public String getTvDescription() {
        return tvDescription;
    }

    public void setTvDescription(String tvDescription) {
        this.tvDescription = tvDescription;
    }

    public int getIvIntro() {
        return ivIntro;
    }

    public void setIvIntro(int ivIntro) {
        this.ivIntro = ivIntro;
    }
}
