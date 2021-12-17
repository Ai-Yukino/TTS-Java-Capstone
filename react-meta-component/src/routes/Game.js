import { useEffect, useState, useLayoutEffect } from "react";

import DealerDisplay from "../components/DealerDisplay";
import PlayerDisplay from "../components/PlayerDisplay";

import "../css/atomic.css";
import "../index.css";

export default function Game() {
  // 📝 Initialize state so VSCode doesn't cry
  const [shuffledDeck, setShuffledDeck] = useState([
    {
      id: -1,
      Suit: "",
      Rank: "",
      BlackjackValue: -1,
      Image: { src: "", alt: "" },
    },
  ]);

  const [numCardsInPlay, setNumCardsInPlay] = useState(0);

  useEffect(() => {
    async function fetchData(url) {
      const response = await fetch(url);
      const data = await response.json();
      setShuffledDeck(data);
    }
    fetchData("Data/Testing/shuffledDeck.json");
  }, []);

  console.log(shuffledDeck);

  if (shuffledDeck.length != 1) {
    return (
      <div>
        <div>Number of cards: {shuffledDeck.length}</div>
        <DealerDisplay />
        <PlayerDisplay />
        {/* <div className={"flex"}>
          <Card deck={shuffledDeck} index={123} />
          <Card deck={shuffledDeck} index={99} />
          <Card deck={shuffledDeck} index={156} />
          <Card deck={shuffledDeck} index={43} />
          <Card deck={shuffledDeck} index={9} />
        </div> */}
      </div>
    );
  } else {
    return (
      <div
        className={
          "bgColor-red" +
          " " +
          "height-100vh" +
          " " +
          "width-100vw" +
          " " +
          "flex" +
          " " +
          "font-size" +
          " " +
          "center"
        }
      >
        👀
      </div>
    );
  }
}

// 📝 playerActions
// stand, hit, doubleDown, split, surrender
