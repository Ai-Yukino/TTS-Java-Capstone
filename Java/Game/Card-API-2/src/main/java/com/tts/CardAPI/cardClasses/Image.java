package com.tts.CardAPI.cardClasses;

public record Image(String src, String alt) {

    public String getSrc() {
        return src;
    }

    public String getAlt() {
        return alt;
    }
}