import { React, useEffect } from "react";
import "./App.css";
import { useState } from "react";
import Game from "./data/game.json";
import cardImage from "./assets/favicon.svg";

function App() {
  const [gameState, setGameState] = useState({});

  // useEffect(() => {
  //   async function fetchData(url) {
  //     const response = await fetch(url);
  //     const data = await response.json();
  //     setGameState(response);
  //   }

  //   console.log(gameState);
  //   // fetchData("./src/data/game.json");
  //   fetchData("data/game.json");
  //   console.log(gameState);
  // }, []);

  useEffect(() => {
    fetch("data/game.json")
      .then((res) => res.json())
      .then((data) => setGameState(data));
  });

  //   useEffect(() => {
  //     fetch("Products.json")
  //     .then(res => res.json())
  //     .then(data => setItems(data));
  // }, [] )

  // let cardDisplay = () => {
  //   if (gameState.cards && gameState.cards.length > 0) {
  //     return (
  //       <div>
  //         <img src={gameState.cards[0].image} />
  //       </div>
  //     );
  //   } else {
  //     return <div>Ain't no cards here!</div>;
  //   }
  // };

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

  // Code from slack
  // const itemsMap = () => {
  //   return items.map(
  //     function(it){
  //       return <Item obj={ it } key={ it.id }/>;
  //     });
  // };

  // const emptyList = () => {
  //   return  <div>No items to show</div>;
  // };

  // const displayItems = (items.length > 0) ? itemsMap : emptyList;

  return <div className="App">{displayCard()}</div>;
}

export default App;
