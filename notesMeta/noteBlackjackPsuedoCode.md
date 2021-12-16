Putting down certain things I things that may be helpful

###Also, I think I did this whole thing with Java in mind instead of JavaScript. If this is done in React, then I guess I should use JavaScript. Wasn't sure what was happening when I started. Doesn't make much difference since this isn't actual code, but just keep that in mind

### Generating Random deck

    List<Integer> deckID = new ArrayList<>();
    for (int i = 1; i <= 52; i++) {
        deckID.add(i);
    }
    Collections.shuffle(solution);
I'm not sure if that code is applicable to what we need (as in... don't think this is react applicable code since it's java...). if it is, and if we want to use 3 decks or something, that isn't difficult to implement

    List<Integer> deckID = new ArrayList<>();
    for (int i=1; i<=3*52; i++) {
        deckID.add(i%52+1)
    }
    Collections.shuffle(solution);
doing something like that allows the array of ID's to match with the card, and let's us add as many decks as we want (just change the 3 to however many decks you want). I assume we can change this to what we need so should still be helpful

### dealing cards:
    int dealerAceCount = 0;
    int aceCount = 0;
    int currIndex = 0;

    //Not exactly sure how to implement, but this is the idea
    give deckID[currIndex] == card.id to dealer
    currIndex += 1;
    give deckID[currIndex] == card.id to dealer
    currIndex += 1;
    give deckID[currIndex] == card.id to player
    etc.

    for(cards in dealerHand) {
        if(card = Ace) {
          dealerAceCount += 1
        }
    }

do same for player

    for(cards in playerHand) {
        if(card = Ace) {
            aceCount += 1
        }
    }

### Actual Game
#### Player
    int sum = 0;
    int mainBet = 0;
    int sideBet = 0;
    int splitBet = 0;
    boolean stillPlaying = true;
    boolean gameOver = false;
    boolean blackjackWin = false;
    boolean win = false;
    boolean draw = false;
    boolean insuranceBet = false;
    boolean splitBet = false; //this last one may not be necessary, depends on how this is implemented
    boolean surrender = false;
    
- player must place bet here. Based on the payout method, and certain other aspects, it would be ideal to set the bets to be multiples of 10 (obviously we can handle decimals, but that'll probably look kinda bad)
  - At this point (the very start), the bet button should be clickable.
    - idea: clicking button increases bet by 10. Button present to bet 100 immediately, or go all in maybe.
- Starting chips should also be decided beforehand probably, I think like 250 or 500 or something is good, but deal with that later
- Something I realized later, probably something needed to limit options in the even there are not enough chips to place a bit (if for whatever reason you go all in on your initial bet, you can't make any side bets)


    playerChipsTotal -= mainBet;

Then, cards are dealt

    for(int i=0; i<2; i++) {
        give deckID[currIndex] == card.id to player
        currIndex += 1;
        sum += card.value
        // I want Aces to default to 11
    }
    for(int i=0; i<2; i++) {
        give cards in same way
    }

###### Insurance bet check
We first check if it's even possible (Only if shown card is Ace or of value 10). By the order in which cards are dealt, the first one (so index 0) should be the dealer's face up card

    if(dealerhand[0].value >= 10) {
        insurance bet button should now appear and be clickable.
    }

At this point, player makes a choice regarding what to do next. In ths case


    if(insuranceButtonClicked) {
        sideBet = 0.5*mainBet
        playerChipsTotal -= sideBet;
        if(insuranceWon) {
            insuranceBet = true;
            payout;
            if(sum=21) {
                blackjackWin = true;
            }
            BREAK //as in, game ends/skip to payout;
        }
        hide button (insurance, split if it was available, double down)
    }
###### Split check

    if(playerHand[0].value == playerHand[1].value) {
        Split button becomes available and clickable
    }
The player can now choose to play two separate hands

    if(splitButtonClicked) {
        splitHand[0] = playerHand[1];
        splitBet = mainBet;
        playerChipsTotal -= splitBet;
        hide button (split, insurance if it was available)
        Need some way to specify that two different games will be played at this point
    }

This next portion is the general play with everything put together. First option, is the double down option

    while(stillPlaying) {
        if(sum = 21) {
            blackjackWin = true;
            break; //to dealers turn (just check if they have blackjack)
        }
        if(playerDoubleDownClicked) {
            playerChipsTotal -= mainBet;
            mainBet *= 2; // this is pseudocode so I'm allowing bad things, but worth noting that this should also take into account which hand is being played
            hide buttons (double hit, surrender, split if it was available, insurance if it was available)
            give deckID[currIndex] == card.id to player;
            currIndex += 1;
            sum += card.value;
            if(sum>21) {
                gameOver = true;
                break (break completely down to payout/new game)
            }
            break (skip to dealer's turn)
            //reminder: if doubleHit is done, player is forced to hit once, then stand, no matter what.
        }
        if(surrenderButtonClicked) {
            surrender = true;
            payout; //I am kinda assuming the payout would be a single function, idk if it would be better to split them
            break; //game over
        }
        if(playerHits) {
            //give card, make sure it isn't duplicate
            sum += newCard.value
            if(sum>21) {
                do the While(Testing) thing a few lines down
            }
        }
        if(playerStays) {
            stillPlaying = false;
            break
        }
        boolean testing = true;
        While(testing) {
            While(sum>21 && aceCount>0) {
                for(cards in hand) {
                    if(card = Ace) {
                        Ace.value = 1;
                        Ace.name = One;
                        //In the event there are two+ Aces, need some way to make sure code works as intended
                        aceCount -= 1;
                    }
                }
            If(sum > 21 && aceCount = 0) {
                stillPlaying = false;
                testing = false;
                gameOver = true;
                break;
                //Game over Loss
            }
#### Dealer

    if(!gameOver) {
        for(cards in hand) {
            dealerSum += card.value
        }

        //Per blackjack rules (not rules, but I guess math or something idk), dealer only hits if their sum is 16 or less
        while(dealerSum < 17 && !blackjackWin) {
            dealerHit
            //apply similar logic to that of the player
        }
        
        while(dealerSum<sum && dealerSum < 22) {
            dealer hit
        }

        if(dealerSum>sum && dealerSum <22)  {
            dealer wins;
            payout;
            break;
        }

        if(dealerSum>21) {
            win = true;
            payout;
            break;
        }

        if(dealerSum=sum) {
            draw = true
        }

probably a bit messy, but that's the idea. Last thing that is needed, is the payout (which may also be messy. Lots of Booleans and breaks to keep track of, assuming this is implemented in this way.)

    Payout() {
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
    }
game end;