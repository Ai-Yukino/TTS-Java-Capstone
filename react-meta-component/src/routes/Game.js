import { useEffect, useState } from "react";
import Card from "../components/small/Card";
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

  useEffect(() => {
    async function fetchData(url) {
      const response = await fetch(url);
      const data = await response.json();
      setShuffledDeck(data);
    }
    fetchData("Data/Testing/shuffledDeck.json");
    console.log(shuffledDeck);
  }, []);

  return (
    <div>
      <div>Number of cards: {shuffledDeck.length}</div>
      <div className={"flex" + " " + "space-around"}>
        <Card shuffledDeck={shuffledDeck} index={123} />
        <Card shuffledDeck={shuffledDeck} index={99} />
        <Card shuffledDeck={shuffledDeck} index={43} />
        <Card shuffledDeck={shuffledDeck} index={9} />
      </div>
    </div>
  );
}
