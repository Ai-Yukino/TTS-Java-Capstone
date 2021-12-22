package com.tts.GameAPI;

// 📝 TODO: Deck class for game calculations only!
// The deck will hold exactly n * 52 cards in a random order where $n\in\mathbb{N}$. In production, the react app in `react-meta-component` will only be sent individual cards rather than a deck.

import com.tts.GameAPI.cardClasses.Image;
import com.tts.GameAPI.cardClasses.Ranks;
import com.tts.GameAPI.cardClasses.Suits;

import java.util.ArrayList;

public class Deck {

    int n;
    private ArrayList<Card> cardPool = new ArrayList<>();
    private ArrayList<Card> cards = new ArrayList<>();

    // 📝 Constructs deck of 52 cards "in order"
    public Deck() {
        n = 1;
        int numCards = 0;
        Suits suits[] = Suits.values();
        Ranks ranks[] = Ranks.values();

        // 📝 Generate `cardPool`
        for (Suits suit : suits) {
            for (Ranks rank : ranks) {
                numCards++;
                cardPool.add(new Card(numCards, suit, rank,
                        new Image(rank.getRankID() + suit.getSuitID() + ".svg",
                                rank.getAltText() + " of " + suit.getAltText())));
            }
        }

        // 📝 Generate `cards`
        cards = cardPool;
    }

    public void printDeck() {
        System.out.print("\n---\n\n");
        for (Card card : cards) {
            System.out.printf("id: %d\n", card.id());
            System.out.printf("suit: %s\n", card.suit().getAltText());
            System.out.printf("rank: %s\n", card.rank().getAltText());
            System.out.printf("image: {src: %s, alt: %s}\n\n", card.image().src(), card.image().alt());
        }
        System.out.print("---");
    }

    ;
}
