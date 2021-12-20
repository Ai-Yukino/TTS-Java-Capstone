package com.tts.CardAPI.cardClasses;

// 🔗 https://stackoverflow.com/a/50284177
// 👤 Elliott Frisch:
// 👤 https://stackoverflow.com/users/2970947/elliott-frisch
//
// and
// 🔗 https://stackoverflow.com/a/19600768
// 👤 tbodt:
// 👤 https://stackoverflow.com/users/1455016/tbodt
// 👤 approxiblue:
// 👤 https://stackoverflow.com/users/880772/approxiblue
//
// Also see:
// 🔗 http://tutorials.jenkov.com/java/enums.html
public enum BlackjackValue {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10),
    ACE(1, 11);

    private final int value;
    private final int secondValue;

    // Single-value constructor
    private BlackjackValue(int value) {
        this.value = value;
        this.secondValue = value;
    }

    // Multi-value constructor
    private BlackjackValue(int value, int secondValue) {
        this.value = value;
        this.secondValue = secondValue;
    }

    public int getValue() {
        return value;
    }

    public int getSecondValue() {
        if (secondValue != 0) {
            return secondValue;
        } else {
            return -1;
        }
    }
}
