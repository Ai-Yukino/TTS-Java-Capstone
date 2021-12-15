import { useEffect } from "react";
import { useState } from "react";

export default function Card() {
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
