import React from 'react';
import './App.css';
import deck from './data/deck.json';
import { useState } from "react";

import cardImage from "./assets/favicon.svg";

function App() {
  const [cardState, setCardState] = useState(deck.image);

  return (
    <div className="App">
      <div className="deck">
        This card is a(n) <img src={cardImage}></img>.
      </div>
      <button onClick={() => setCardState("King")}></button>
    </div>
  );
}

export default App;  
