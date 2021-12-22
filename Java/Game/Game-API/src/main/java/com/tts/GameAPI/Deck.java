package com.tts.GameAPI;

// 📝 TODO: Deck class for game calculations only!
// The deck will hold exactly n * 52 cards in a random order where $n\in\mathbb{N}$. In production, the react app in `react-meta-component` will only be sent individual cards rather than a deck.

//Source of this: https://gist.github.com/MelissaBruno/cabf119e2f6573de4fe5

import com.tts.GameAPI.cardClasses.Image;
import com.tts.GameAPI.cardClasses.Ranks;
import com.tts.GameAPI.cardClasses.Suits;
import java.io.Serializable;
import java.util.Random;

import java.util.ArrayList;


public class Deck extends Exception implements Serializable
{

    private int nextCardIndex;


    Card[] deck = new Card[52];

    public Deck(){

        int count = 0;
        for (int i = 1; i <= 13; i++) {
            deck[count++] = new Card('H', i);
        }
        for (int i = 1; i <= 13; i++) {
            deck[count++] = new Card('S', i);
        }
        for (int i = 1; i <= 13; i++) {
            deck[count++] = new Card('C', i);
        }
        for (int i = 1; i <= 13; i++) {
            deck[count++] = new Card('D', i);
        }
        nextCardIndex = 0;
    }


    public String toString(){

        String str = "";

        for (int i = 0; i < deck.length; i++) {
            str +=	deck[i].toString() + " ";
        }
        return str;
    }


    private void swapCards(int index1, int index2) {
        Card hold;

        hold = deck[index1];
        deck[index1] = deck[index2];
        deck[index2] = hold;
    }

    public void shuffle() {
        Random rn = new Random();
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < deck.length; j++) {
                swapCards(i, rn.nextInt(52));
            }
        }
        nextCardIndex = 0;
    }

    public Card getCard(int index){
        return deck[index];
    }



    public boolean compareTo(Deck otherDeck){
        for (int i=0; i < deck.length; i++){
            if (! deck[i].compareTo(otherDeck.getCard(i)) ) {
                return false;
            }
        }
        return true;
    }

    public Card nextCard() {

        if (nextCardIndex < 0 || nextCardIndex > 51) {
            System.out.println("Future exception goes here");
        }
        return deck[nextCardIndex++];
    }


}









//public class Deck {
//
//    int n;
//    private ArrayList<Card> cardPool = new ArrayList<>();
//    private ArrayList<Card> cards = new ArrayList<>();
//
//    // 📝 Constructs deck of 52 cards "in order"
//    public Deck() {
//        n = 1;
//        int numCards = 0;
//        Suits suits[] = Suits.values();
//        Ranks ranks[] = Ranks.values();
//
//        // 📝 Generate `cardPool`
//        for (Suits suit : suits) {
//            for (Ranks rank : ranks) {
//                numCards++;
//                cardPool.add(new Card(numCards, suit, rank,
//                        new Image(rank.getRankID() + suit.getSuitID() + ".svg",
//                                rank.getAltText() + " of " + suit.getAltText())));
//            }
//        }
//
//        // 📝 Generate `cards`
//        cards = cardPool;
//    }
//
//    public void printDeck() {
//        System.out.print("\n---\n\n");
//        for (Card card : cards) {
//            System.out.printf("id: %d\n", card.id());
//            System.out.printf("suit: %s\n", card.suit().getAltText());
//            System.out.printf("rank: %s\n", card.rank().getAltText());
//            System.out.printf("image: {src: %s, alt: %s}\n\n", card.image().src(), card.image().alt());
//        }
//        System.out.print("---");
//    }
//
//    ;
//}
