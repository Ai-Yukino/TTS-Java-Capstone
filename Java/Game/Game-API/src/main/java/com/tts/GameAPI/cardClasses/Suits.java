package com.tts.GameAPI.cardClasses;

public enum Suits {

    CLUBS("C", "clubs"),
    DIAMONDS("D", "diamonds"),
    HEARTS("H", "hearts"),
    SPADES("S", "spades");

    String suitID;
    String altText;

    Suits(String suitID, String altText) {
        this.suitID = suitID;
        this.altText = altText;
    }

    public String getSuitID() {
        return suitID;
    }

    public String getAltText() {
        return altText;
    }

    // public static void test() {
    //     Suits[] suits = Suits.values();
    //     for (Suits s : suits) {
    //         System.out.printf("enum constant: %s\n", s);
    //         System.out.printf("suitID: %c\n", s.suitID);
    //         System.out.printf("altText: %s\n", s.altText);
    //     }
    // }
}
