Rule source: [https://www.pagat.com/banking/blackjack.html](https://www.pagat.com/banking/blackjack.html)

## Page order/program requirements

`index.html`

Welcome component + Navigation choices (

- Log in
- Create account
- How to play
- View high score(s)

)

Variables

House account: (i.e. dealer money)

Player account: (i.e player money)

Game structure

1. Player makes blind bets (i.e. no cards dealt)
2. Dealer deals one card face-up to player
3. Dealer deals one card face-up to dealer
4. Dealer deals second card face-up to player
5. Dealer deals second card face-down to dealer
6. 🤵Insurance bet:
    1. Necessary conditions:
        1. The dealer's face-up card is of rank 10 (e.g. ace or face card)
    2. Betting:
        1. `Current bet => current bet`
        2. `Insurance bet => 0.5 * (current bet)`
    3. Player places insurance bet: `do b`
    4. Player does not play insurance bet: `continue`
7. Dealer checks blackjack (if insurance bets are made!!):
    1. If they have blackjack, they reveal card and round ends. Appropriate payouts given (if we have only one player, this would mean collecting players bets and that's it)
    2. If not, they collect insurance bets, and game continues
8. Player can now make informed bets:
    1. Double-down: `Current bet ⇒ (current bet) * 2`
        1. can only be done during starting hand (no hits, no splits)
        2. Dealer deals one card face-up to player
        3. Player must stand regardless of result
    2. Split: if the player's two cards are of same rank (both the same, or both face cards) player may split their hand, and play two games
       1. this requires an additional bet, equal to the original bet in order to play the other hand. Following the split, each split is dealt another card, and the game continues as normal
       2. Worth noting, any blackjack resulting from the additional card will not be considered a blackjack (this is relevant only for payout purposes, since a blackjack has a higher payout).
          1. an Ordinary 21 is beaten by a blackjack, in all situations except this one. Additionally, this hand would beat other ordinary 21s (reminder, you're only playing against the dealer)
             1. this sounds confusing, but generally speaking, game ends immediately when a blackjack is in play, so it makes sense with that in mind. I think
    3. Surrender (apparently uncommon to be offered now?)
       1. Player has option to immediately surrender, and collect half of their initial bet back
          1. can only be done at the start, immediately after all cards are dealt
9. Dealer's turn
    1. If it reaches dealer's term, the play is simple:
        1. Dealer always hits at `<=16`
        2. Dealer stands at `>16`
10. Payout (we have some liberty, and can change the payout rates as needed)
    1. Normal Win: Receive bet back + amount bet as winnings
       1. example: a win from a bet of $10, results in receiving $20 total, for a profit of $10.
    2. Blackjack win: Receive bet back + 1.5*original bet as winnings
       1. example: a win from a bet of $10, results in receiving $25 total, for a profit of $15
    3. Insurance win: receive bet back + double what was bet as winnings
       1. example: a win from a bet of $10, results in receiving $30 total, for a profit of $20
          1. note that this would usually mean the player loses their original bet (in this case would be $20), so the actual payout is 0 (unless the player themselves has blackjack as well, in which case the $20 profit remains as is.)
    4. In the event of a draw, the bet money is returned, and no additional money is shared.