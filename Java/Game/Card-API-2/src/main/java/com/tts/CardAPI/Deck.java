package com.tts.CardAPI;

// 📝 TODO: Deck class for game calculations only!
// The deck will hold exactly n * 52 cards in a random order where $n\in\mathbb{N}$. In production, the react app in `react-meta-component` will only be sent individual cards rather than a deck.

import java.util.ArrayList;

public class Deck {

    int n;

    private ArrayList<Card> cardPool = new ArrayList<>();
    private static final String[] suitPool = new String[]{"Clubs", "Diamonds", "Hearts", "Spades"};
    private static final String[] rankPool = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};

    private ArrayList<Card> cards = new ArrayList<>();

    // 📝 Constructs deck of 52 cards "in order"
    public Deck() {
    }
}
