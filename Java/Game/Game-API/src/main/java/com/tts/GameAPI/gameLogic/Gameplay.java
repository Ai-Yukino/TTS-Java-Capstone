 package com.tts.GameAPI.gameLogic;
// //My intellij is being weird, so I have to manually do that ^. make sure that's right~
//
// // For now, I assume a shuffled deck already exists, with certain properties. basically meaning this can't run or anything yet
 import java.util.ArrayList;
 import java.util.Scanner;

 public class Gameplay {

     static int dealerAceCount = 0;
     static int playerAceCount = 0;
     static int playerChipsTotal = 500; //placeholder
     static int currIndex = 0; // This one may not be needed if instead the choosing of the next card is handled by the deck itself
     static int playerSum = 0;
     static int dealerSum = 0;
     static int mainBet = 0;
     static int sideBet = 0;
     //    int splitBet = 0; // I'm going to ignore this one because it fundamentally depends on how this works, and if we choose to keep this in this way
     static boolean stillPlaying = true;
     static boolean gameOver = false;
     static boolean blackjackWin = false;
     static boolean win = false;
     static boolean draw = false;
     static boolean insuranceBet = false;
     //    boolean splitBet = false;
     static boolean surrender = false;
     static ArrayList<Card> playerHand = new ArrayList<Card>();
     static ArrayList<Card> dealerHand = new ArrayList<Card>();
     static private Deck Deck;
//    ^something like that I assume?

     //main method, playable single game in console. Starting chips: 500. Have fun!
     public static void main(String[] args) {
         while(stillPlaying) {
             startingBet();
             startingHand();
             System.out.println("Current chips: " + playerChipsTotal);
             System.out.println("This is your hand: " + playerHand);
             System.out.println("And this is your hands current value: " + playerSum);
             System.out.println("This is the dealer's first card: " + dealerHand.get(0));
             if (playerSum == 21) {
                 blackjackWin = true;
                 payout(insuranceBet, blackjackWin, surrender, win, draw);
                 System.out.println("Congratulations! You got blackjack. Here us your new chip total: " + playerChipsTotal);
             }
             System.out.println("Would you like to hit (hit), stand (stand), or double down (dd)? (typo means automatic stand)");
             String playHit = "hit";
             String playStand = "stand";
             String playDouble = "dd";
             String playCont = "cont";
             while(playerSum<21) {
                 Scanner play = new Scanner(System.in);
                 String nextPlay = play.next();
                 if(nextPlay.equals(playHit)) {
                     hit(playerHand);
                     playerSum += Deck.getCard(currIndex).getValue();
                     if(Deck.getCard(currIndex).getValue() == 11) {
                         playerAceCount += 1;
                     }
                     currIndex += 1;
                     System.out.println("Your current hand: " + playerHand);
                     System.out.println("Your current hand value: " + playerSum);
                     if(playerSum>21 && playerAceCount>0) {
                         aceCheck(playerHand);
                         playerAceCount -= 1;
                         playerSum -= 10;
                         System.out.println("You're updated hand value after changing your Ace: " + playerSum);
                     }
                     else if(playerSum>21 && playerAceCount == 0) {
                         stillPlaying = false;
                         gameOver = true;
                         System.out.println("Sorry, you've lost this round!");
                         System.out.println(" ");
                     }
                     else if(playerSum == 21) {
                         dealerTurn();
                         System.out.println("The dealer's final hand: " + dealerHand);
                         break;
                     }
                 }
                 else if(nextPlay.equals(playDouble)) {
                     doubleDown();
                     break;
                 }
                 else{
                     dealerTurn();
                     System.out.println("The dealer's final hand: " + dealerHand);
                     break;
                 }
             }
             System.out.println("Would you like to continue (cont) playing? (Typo ends session)");
             Scanner cont = new Scanner(System.in);
             String Cont = cont.next();
             if(Cont.equals(playCont)) {
                 playerHand.clear();
                 dealerHand.clear();
                 stillPlaying = true;
                 playerSum = 0;
                 dealerSum = 0;
                 currIndex = 0;
                 playerAceCount = 0;
                 dealerAceCount = 0;
                 blackjackWin = false;
                 win = false;
                 draw = false;
                 insuranceBet = false;
                 surrender = false;
                 System.out.println(" ");
             }
             else{
                 System.out.println("Thank you for playing!");
                 stillPlaying = false;
             }
         }

     }

     public static void startingBet() {
         mainBet = 10; //placeholder bc I have no idea what I'm doing
         playerChipsTotal -= mainBet;
         Deck = new Deck();
         Deck.shuffle();
     }

     public static void startingHand() {
         // method/class at bottom (idk what words mean)
         hit(playerHand);
         playerSum += Deck.getCard(currIndex).getValue();
         if(Deck.getCard(currIndex).getValue() == 11) {
             playerAceCount += 1;
         }
         currIndex += 1;
         hit(dealerHand);
         dealerSum += Deck.getCard(currIndex).getValue();
         if(Deck.getCard(currIndex).getValue() == 11) {
             dealerAceCount += 1;
         }
         currIndex += 1;
         hit(playerHand);
         playerSum += Deck.getCard(currIndex).getValue();
         if(Deck.getCard(currIndex).getValue() == 11) {
             playerAceCount += 1;
         }
         currIndex += 1;
         hit(dealerHand);
         dealerSum += Deck.getCard(currIndex).getValue();
         if(Deck.getCard(currIndex).getValue() == 11) {
             dealerAceCount += 1;
         }
         currIndex += 1;
     }
     public static void insuranceBetPlacing() {
         sideBet = (int) (0.5*mainBet);
     }

     public static void insuranceBetCheck() {
         if(dealerHand.get(0).getValue() + dealerHand.get(1).getValue()==21) {
             insuranceBet = true;
         }
         payout(insuranceBet, blackjackWin, surrender, win, draw);
//        break; // end game
     }

     public boolean playerSurrender() {
         surrender = true;
         return surrender;
     }

     public static void doubleDown() {
         playerChipsTotal -= mainBet;
         mainBet *= 2;
         hit(playerHand);
         playerSum += Deck.getCard(currIndex).getValue();
         currIndex += 1;
         if(playerSum>21) {
             gameOver = true;
             System.out.println("You're final hand: " + playerHand);
             System.out.println("Sorry, you've lost this round!");
             System.out.println(" ");
//            break // start a new game I guess
         }
         else {
             System.out.println("You're final hand: " + playerHand);
             dealerTurn();
             System.out.println("The dealer's final hand: " + dealerHand);
         }
     }

     //    probably need things in the () for this. and many of the other parts tbf
     public static void BlackJack() {
         if(playerSum == 21) {
             blackjackWin = true;
             payout(insuranceBet, blackjackWin, surrender, win, draw);
//            break // Basically, we don't need to run anything after this if this is true
         }



//        boolean playerStands = false;
//        boolean playerHits = true;
//        while(stillPlaying) {
//            // I don't know how else to write things that depend on react buttons being clicked
//            if(playerHits) {
//                hit(playerHand);
//                playerSum += Deck.getCard(currIndex).getValue();
//                currIndex += 1;
//                if(playerSum>21 && playerAceCount>0) {
//                    aceCheck(playerHand);
//                    playerAceCount -= 1;
//                    playerSum -= 10;
//                }
//                else if(playerSum>21 && playerAceCount == 0) {
//                    stillPlaying = false;
//                    gameOver = true;
//                    break; // end game
//                }
//                if(playerStands) {
//                    stillPlaying = false;
//                }
//            }
//        }
//        dealerTurn();
     }

     public static void dealerTurn() {
         while(dealerSum < 17) {
             hit(dealerHand);
             dealerSum += Deck.getCard(currIndex).getValue();
             currIndex += 1;
         }
         if(dealerSum > 21) {
             win = true;
             System.out.println("Congradulations, you won this round!");
             payout(insuranceBet, blackjackWin, surrender, win, draw);
             System.out.println("You're new chip total is: " + playerChipsTotal);
         }
         if(dealerSum < 21 && dealerSum < playerSum) {
             win = true;
             System.out.println("Congradulations, you won this round!");
             payout(insuranceBet, blackjackWin, surrender, win, draw);
             System.out.println("You're new chip total is: " + playerChipsTotal);
         }
         if(dealerSum == playerSum) {
             draw = true;
             System.out.println("Close but no cigar. It's a draw!");
             payout(insuranceBet, blackjackWin, surrender, win, draw);
             System.out.println("You're new chip total is: " + playerChipsTotal);
         }
         if(dealerSum == 21 && playerSum<21) {
             System.out.println("Seems you've lost this round!");
         }
     }


     public static void payout(boolean insuranceBet, boolean blackjackWin, boolean surrender, boolean win, boolean draw) {
         if(insuranceBet) {
             playerChipsTotal += sideBet*3;
         }
         if(blackjackWin) {
             playerChipsTotal += mainBet*2.5;
         }
         if(surrender) {
             playerChipsTotal += mainBet*0.5;
         }
         if(win) {
             playerChipsTotal += mainBet*2;
         }
         if(draw) {
             playerChipsTotal += mainBet;
         }
     }

     public static void hit(ArrayList<Card> hand) {
         hand.add(Deck.nextCard());
     }

     public static void aceCheck(ArrayList<Card> hand) {
         for(int i=0; i<hand.size(); i++) {
             if(hand.get(i).getValue() == 11) {
                 hand.get(i).setValue(1);
             }
         }
     }
 }