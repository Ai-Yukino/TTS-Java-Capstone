package com.tts.CardAPI;

import com.tts.CardAPI.cardClasses.BlackjackValue;
import com.tts.CardAPI.cardClasses.ImageData;
import com.tts.CardAPI.cardClasses.Suit;

public class Card {
    private final int id;
    private final Suit suit;
    private final BlackjackValue value;
    private final ImageData data;

    public Card(int id, Suit suit, BlackjackValue value, ImageData data) {
        this.id = id;
        this.suit = suit;
        this.value = value;
        this.data = data;
    }

    public Suit getSuit() {
        return suit;
    }

    public BlackjackValue getValue() {
        return value;
    }

    public ImageData getData() {
        return data;
    }
}
