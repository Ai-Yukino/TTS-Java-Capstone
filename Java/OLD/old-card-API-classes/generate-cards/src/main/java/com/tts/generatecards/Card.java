package com.tts.generatecards;

import com.tts.generatecards.cardClasses.BlackjackValue;
import com.tts.generatecards.cardClasses.ImageData;
import com.tts.generatecards.cardClasses.Suit;

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

}
