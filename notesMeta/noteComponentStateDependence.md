# noteComponentStateDependence

## `PlayerDisplay.js`

`PlayerDisplay.js` only needs to track

```
cardHands = [[...],[...]]
```

which is an array of potentially two hands (i.e. when split) and

```
bet = {
    baseBet: 0,
    insuranceBet: false,
    doubleDown: false,
    surrender: false,
  }
```

which is the initial base bet `baseBet` for the current game and other player actions that can affect the bet.

## `DealerDisplay.js`

`DealerDisplay.js` only needs to track the dealer's single hand

```
cardHand = [...]
```

and the player's actions

```
PlayerActions = {
    insuranceBet: false,
    stand: false,
    hit: false,
    doubleDown: false,
    split: false,
    surrender: false,
  }
```

since the dealer only reacts (heh) to what the player does.
