Putting down certain things I things that may be helpful

## dealing cards:
    int dealerAceCount = 0;
    int aceCount = 0;

    //randomly draw two cards and give to dealer (ensure that duplicates can't occur)

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
    boolean stillPlaying = true;
    boolean gameOver = false;

    for(cards in hand) {
        sum += card.value
        // I want Aces to default to 11
    }

    while(stillPlaying) {
        //this would be a react thing I assume
        if(playerHits) {
            //give card, make sure it isn't duplicate
            sum += newCard.value
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
                        aceCount -= 0;
                    }
                }
            If(sum > 21 && aceCount = 0) {
                stillPlaying = false;
                testing = false;
                gameOver = true;
                break;
                //Game over Loss
            }
### Dealer

    if(!gameOver) {
        for(cards in hand) {
            dealerSum += card.value
        }

        //Per blackjack rules (not rules, but I guess math or something idk), dealer only hits if their sum is 16 or less
        if(dealerSum < 17) {
            dealerHit
            //apply similar logic to that of the player
        }
        
        if(dealerSum<sum) {
            dealer hit
        }

        if(dealerSum>sum && dealerSum <22)  {
            dealer wins
        }

probably a bit messy, but that's the idea