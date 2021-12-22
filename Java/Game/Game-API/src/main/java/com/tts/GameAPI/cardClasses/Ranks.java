package com.tts.GameAPI.cardClasses;

public enum Ranks {
    TWO(2, "2", "Two"),
    THREE(3, "3", "Three"),
    FOUR(4, "4", "Four"),
    FIVE(5, "5", "Five"),
    SIX(6, "6", "Six"),
    SEVEN(7, "7", "Seven"),
    EIGHT(8, "8", "Eight"),
    NINE(9, "9", "Nine"),
    TEN(10, "10", "Ten"),
    JACK(10, "J", "Jack"),
    QUEEN(10, "Q", "Queen"),
    KING(10, "K", "King"),
    ACE(1, 10, "A", "Ace");

    int firstValue;
    int secondValue;
    String rankID;
    String altText;

    Ranks(int value, String rankID, String altText) {
        this.firstValue = value;
        this.secondValue = value;
        this.rankID = rankID;
        this.altText = altText;
    }

    Ranks(int firstValue, int secondValue, String rankID, String altText) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.rankID = rankID;
        this.altText = altText;
    }

    public int getFirstValue() {
        return firstValue;
    }

    public int getSecondValue() {
        return secondValue;
    }

    public String getRankID() {
        return rankID;
    }

    public String getAltText() {
        return altText;
    }

    // public static void test() {
    //     Ranks[] ranks = Ranks.values();
    //     for (Ranks rank : ranks) {
    //         System.out.printf("Rank: %s\n", rank);
    //         System.out.printf("firstValue: %d\n", rank.firstValue);
    //         System.out.printf("secondValue: %d\n", rank.secondValue);
    //         System.out.printf("rankID: %s\n", rank.rankID);
    //     }
    // }
}
