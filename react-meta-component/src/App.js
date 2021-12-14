import {React, useEffect} from 'react';
import './App.css';
import { useState } from "react";
import Game from './data/game.json';
import cardImage from "./assets/favicon.svg";

function App() {
  const [gameState, setGameState] = useState({});

  useEffect(() => {
    async function fetchData(url) {
      const response = await fetch(url);
      const data = await response.json();
      setGameState(data);
    }

    fetchData("./src/data/game.json");
  }, []);

  let cardDisplay = () => {
    if (gameState.cards && gameState.cards.length > 0) {
      return <div><img src={gameState.cards[0]} /></div>
    }
    else {
      return <div>Ain't no cards here!</div>
    }
  } 

  return (
    <div className="App">
      {cardDisplay()}
    </div>
  );
}

export default App;  
