import React from 'react';
import './App.css';
import cards from './data/cards.json';
import { useState } from "react";

function App() {
  const [cardState, setCardState] = useState(cards.image);

  return (
    <div className="App">
      <div className="deck">
        This card is a(n) <img src={deck.card.image}></img>.
      </div>
      <button onClick={() => setCardState("King")}></button>
c    </div>
  );
}

export default App;  
