import { useEffect } from "react";
import "./App.css";
import { useState } from "react";

function App() {
  const [gameState, setGameState] = useState({});

  useEffect(() => {
    fetch("data/game.json")
      .then((res) => res.json())
      .then((data) => setGameState(data));
  });

  const showCard = () => {
    return (
      <div>
        <img src={gameState["cards"][0].image} />
      </div>
    );
  };

  const displayCard =
    gameState["cards"] && gameState["cards"].length > 0
      ? showCard
      : () => {
          return <div>Ain't no cards here!</div>;
        };

  return <div className="App">{displayCard()}</div>;
}

export default App;
