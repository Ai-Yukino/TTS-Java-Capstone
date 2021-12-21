package com.tts.CardAPI.gameLogic;
//My intellij is being weird, so I have to manually do that ^. make sure that's right~


// For now, I assume a shuffled deck already exists, with certain properties. basically meaning this can't run or anything yet
public class Gameplay (Deck) {
    int dealerAceCount = 0;
    int aceCount = 0;
    int currIndex = 0; // This one may not be needed if instead the choosing of the next card is handled by the deck itself
    int playerSum = 0;
    int dealerSum = 0;
    int mainBet = 0;
    int sideBet = 0;
//    int splitBet = 0; // I'm going to ignore this one because it fundamentally depends on how this works, and if we choose to keep this in this way
    boolean stillPlaying = true;
    boolean gameOver = false;
    boolean blackjackWin = false;
    boolean win = false;
    boolean draw = false;
    boolean insuranceBet = false;
//    boolean splitBet = false;
    boolean surrender = false;
    ArrayList<Card> playerHand = new ArrayList<Card>;
    ArrayList<Card> dealerHand = new ArrayList<Card>;
//    ^something like that I assume?

    public startingBet() {
        mainBet = 10; //placeholder bc I have no idea what I'm doing
        return mainBet
    }

    public startingHand() {
        // method/class at bottom (idk what words mean)
        hit(playerHand, playerSum)
        hit(dealerHand, dealerSum)
        hit(playerHand, playerSum)
        hit(dealerHand, dealerSum)


        //It's at this point I would do stuff with my aceCounters, but I guess we might be dealing with that a different way, so I'll ignore that for now
    }
    public insuranceBetPlacing() {
        sideBet = 0.5*mainBet;
    }

    public insuranceBetCheck() {
        if(dealerHand[0].value+dealerHand[1].value) {
            insuranceBet = true;
        }
        payout(insuranceBet, blackjackWin, surrneder, win, draw, playerChipsTotal);
        break; // end game
    }

    public playerSurrender() {
        surrender = true;
        return surrender;
    }

    public doubleDown() {
        playerChipsTotal -= mainBet;
        mainBet *= 2;
        hit(playerHand, playerSum)
        if(playerSum>21) {
            gameOver = true;
            break // start a new game I guess
        }
        else {
            dealerTurn(playerSum); // I hope this is how java works...
        }
    }

//    probably need things in the () for this. and many of the other parts tbf
    public BlackJack() {
        playerChipsTotal -= mainBet
        if(playerSum = 21) {
            blackjackWin = true;
            payout(insuranceBet, blackjackWin, surrneder, win, draw, playerChipsTotal)
            break // Basically, we don't need to run anything after this if this is true
        }
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
        dealerTurn(playerSum)
    }

    public dealerTurn(playerSum) {
        while(dealerSum < 17) {
            dealerHand.add(Deck[currIndex]);
            dealerSum += dealerHand[currIndex].value;
            currIndex += 1;
        }
        if(dealerSum >21) {
            win = true;
        }
        if(dealerSum = playerSum) {
            draw = true;
        }
        payout(insuranceBet, blackjackWin, surrneder, win, draw, playerChipsTotal)
//        I instinctively want to add a return statement, but uh. what to return. hope I don't need it.
    }


    public payout(insuranceBet, blackjackWin, surrneder, win, draw, playerChipsTotal) {
        if(insuranceBet) {
            playerChipsTotal += sideBet*3
        }
        if(blackjackWin) {
            playerChipsTotal += mainBet*2.5
        }
        else if(surrender) {
            playerChipsTotal += mainBet*0.5;
        }
        else if(win) {
            playerChipsTotal += mainBet*2;
        }
        else if(draw) {
            playerChipsTotal += mainBet
        }
        return playerChipsTotal // Don't think this should be necessary?
    }

    public hit(hand, sum) {
        hand.add(Deck[currIndex]);
        sum += Deck[currIndex].value;
        currIndex += 1;
    }

}