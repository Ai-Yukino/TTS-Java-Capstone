# noteStateFlow

##

`Service 1` --{`state 1`}-->  
`Service 2` --{...}-->  
`Service 3`, `Service 4`, `Service 5`

`Service 4` --{`state 1`, `state 2`}-->
`Service 6`

End result: `Service 1` sends out `state 1`, and it is passed down to `Service 3` - `Service 6`. `Service 6` also receives `state 2` from `Service 4`.

## Final product

### At game start:

Java API --{individual card}-->  
React front-end --{...}-->  
`Game.js` --{...}-->
`Card.js`

## Draft product

### At game start:

`public/Data/Testing/deckShuffled.json`  
--{`deckShuffled`}-->  
React front-end --{...}-->  
`Game.js`

### On player action, e.g. hit/draw

`Game.js` --{`nextCard`}-->  
`Card.js`
