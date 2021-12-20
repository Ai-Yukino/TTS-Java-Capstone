import { useEffect, useState } from "react";
import Card from "../components/Card";

import DealerDisplay from "../components/DealerDisplay";
import PlayerDisplay from "../components/PlayerDisplay";

import "../css/atomic.css";

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
    // fetchData("Data/Testing/shuffledDeck.json");
    fetchData("Data/non-API/shuffledDeck.json");
  }, []);

  console.log(shuffledDeck);

  if (shuffledDeck.length != 1) {
    return (
      <div className={"flex" + " " + "column"}>
        <h2>Cards remaining: {shuffledDeck.length}</h2>
        <div>
          <DealerDisplay />
          <PlayerDisplay />
        </div>
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

// 📝 cards for quick testing
// <Card
//   src={"Images/" + shuffledDeck[99].Image.src}
//   alt={shuffledDeck[99].Image.alt}
//   width={"10%"}
//   height={"10%"}
// />
// <Card
//   src={"Images/" + shuffledDeck[50].Image.src}
//   alt={shuffledDeck[50].Image.alt}
//   width={"10%"}
//   height={"10%"}
// />
// <Card
//   src={"Images/" + shuffledDeck[23].Image.src}
//   alt={shuffledDeck[23].Image.alt}
//   width={"10%"}
//   height={"10%"}
// />
// <Card
//   src={"Images/" + shuffledDeck[2].Image.src}
//   alt={shuffledDeck[2].Image.alt}
//   width={"10%"}
//   height={"10%"}
// />
// <Card
//   src={"Images/" + shuffledDeck[109].Image.src}
//   alt={shuffledDeck[109].Image.alt}
//   width={"10%"}
//   height={"10%"}
// />
