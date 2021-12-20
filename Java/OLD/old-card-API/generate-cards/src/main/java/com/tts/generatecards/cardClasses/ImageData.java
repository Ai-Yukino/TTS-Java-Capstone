package com.tts.generatecards.cardClasses;

public class ImageData {
    private final String src;
    private final String alt;

    ImageData(String url, String altText) {
        src = url;
        alt = altText;
    }

    public String getSrc() {
        return src;
    }

    public String getAlt() {
        return alt;
    }
}
