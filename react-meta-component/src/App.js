import React from 'react';
import './App.css';
import cards from './data/cards.json';
import { useState } from "react";

function App() {
  const [cardState, setCardState] = useState(cards.image);

  return (
    <div className="App">
      <div className="cards">
        This card is a(n) <img src={cards.image}></img>.
      </div>
      <button onClick={() => setCardState("King")}></button>
    </div>
  );
}

export default App;
