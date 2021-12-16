import { useEffect } from "react";
import { useState } from "react";

export default function Card() {
  const [gameState, setGameState] = useState({});

  useEffect(() => {
    fetch("data/game.json")
      .then((res) => res.json())
      .then((data) => setGameState(data));
  }, []);

  // useEffect(() => {
  //   async function fetchData(url) {
  //     const response = await fetch(url);

  //   }
  // })

  // useEffect(() => {
  //   async function fetchData(url) {
  //     const response = await fetch(url);
  //     const data = await response.json();
  //     setProductsData(data);
  //   }

  //   fetchData("./src/data/products.json");
  //   // console.log(typeof products[2].name);
  // }, []);
  // // console.log(typeof products[2].name);

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
