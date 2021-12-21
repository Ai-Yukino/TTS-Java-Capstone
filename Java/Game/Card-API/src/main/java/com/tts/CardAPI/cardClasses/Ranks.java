package com.tts.CardAPI.cardClasses;

public enum Ranks {
    ONE(1, "1"),
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "10"),
    JACK(10, "J"),
    QUEEN(10, "Q"),
    KING(10, "K"),
    ACE(1, 10, "A");

    int firstValue;
    int secondValue;

    String rankID;

    Ranks(int value, String rankID) {
        this.firstValue = value;
        this.secondValue = value;
        this.rankID = rankID;
    }

    Ranks(int firstValue, int secondValue, String rankID) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.rankID = rankID;
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
