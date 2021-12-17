import { useEffect, useState, useLayoutEffect } from "react";
import Card from "../components/small/Card";
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

  useEffect(() => {
    async function fetchData(url) {
      const response = await fetch(url);
      const data = await response.json();
      setShuffledDeck(data);
    }
    fetchData("Data/Testing/shuffledDeck.json");
  }, []);

  console.log(shuffledDeck);

  const baseUrl = "Images/";

  if (shuffledDeck.length != 1) {
    return (
      <div>
        <div>Number of cards: {shuffledDeck.length}</div>
        <div className={"flex"}>
          <Card deck={shuffledDeck} index={123} />
          <Card deck={shuffledDeck} index={99} />
          <Card deck={shuffledDeck} index={156} />
          <Card deck={shuffledDeck} index={43} />
          <Card deck={shuffledDeck} index={9} />
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
