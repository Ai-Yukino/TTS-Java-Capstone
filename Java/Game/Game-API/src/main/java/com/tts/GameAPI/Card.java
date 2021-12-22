package com.tts.GameAPI;

import com.tts.GameAPI.cardClasses.Image;
import com.tts.GameAPI.cardClasses.Ranks;
import com.tts.GameAPI.cardClasses.Suits;

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

