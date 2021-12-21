package com.tts.CardAPI;

import com.tts.CardAPI.cardClasses.Image;
import com.tts.CardAPI.cardClasses.Ranks;
import com.tts.CardAPI.cardClasses.Suits;

public record Card(int cardID, Suits suit, Ranks rank, Image data) {

    public int getCardID() {
        return cardID;
    }

    public Suits getSuit() {
        return suit;
    }

    public Ranks getRank() {
        return rank;
    }

    public Image getData() {
        return data;
    }

}
