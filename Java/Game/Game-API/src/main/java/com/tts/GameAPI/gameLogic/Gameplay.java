 package com.tts.GameAPI.gameLogic;
// //My intellij is being weird, so I have to manually do that ^. make sure that's right~
//
// // For now, I assume a shuffled deck already exists, with certain properties. basically meaning this can't run or anything yet
 public class Gameplay(Deck) {
    static int dealerAceCount = 0;
    static int aceCount = 0;
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

    public static void main(String[] args) {
            startingBet();
            startingHand();
            System.out.println(playerSum);
            System.out.println(dealerSum);
            payout(true, true, true, true, true);
    //        doubleDown();
            }

    public static void startingBet() {
            mainBet = 10; //placeholder bc I have no idea what I'm doing
            playerChipsTotal -= mainBet;
            Deck = new Deck();
            Deck.shuffle();
            }

    public static void startingHand() {
            // method/class at bottom (idk what words mean)
            hit(playerHand, playerSum);
            hit(dealerHand, dealerSum);
            hit(playerHand, playerSum);
            hit(dealerHand, dealerSum);


            //It's at this point I would do stuff with my aceCounters, but I guess we might be dealing with that a different way, so I'll ignore that for now
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
            hit(playerHand, playerSum);
            if(playerSum>21) {
            gameOver = true;
    //            break // start a new game I guess
            }
            else {
            dealerTurn(); // I hope this is how java works...
            }
            }

    //    probably need things in the () for this. and many of the other parts tbf
    public static void BlackJack() {
    //        playerChipsTotal -= mainBet;
            if(playerSum == 21) {
            blackjackWin = true;
            payout(insuranceBet, blackjackWin, surrender, win, draw);
    //            break // Basically, we don't need to run anything after this if this is true
            }
            boolean playerStands = false;
            boolean playerHits = true;
            while(stillPlaying) {
            // I don't know how else to write things that depend on react buttons being clicked
            if(playerHits) {
            hit(playerHand, playerSum);
            if(playerSum>21) {
            stillPlaying = false;
            gameOver = true;
            break; // end game
            }
            if(playerStands) {
            stillPlaying = false;
            }
            }
            }
            dealerTurn();
            }

    public static void dealerTurn() {
            while(dealerSum < 17) {
            hit(dealerHand, dealerSum);
            }
            if(dealerSum > 21) {
            win = true;
            }
            if(dealerSum == playerSum) {
            draw = true;
            }
            payout(insuranceBet, blackjackWin, surrender, win, draw);
    //        I instinctively want to add a return statement, but uh. what to return. hope I don't need it.
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

    public static void hit(ArrayList<Card> hand, int sum) {
            hand.add(Deck.nextCard());
            sum += Deck.getCard(currIndex).getValue();
            currIndex += 1;
            }
 }