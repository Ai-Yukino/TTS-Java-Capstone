import { useEffect, useState } from "react";
import Card from "../components/small/Card";

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

  const baseUrl = "Images/";

  return (
    <div>
      <Card
        src={baseUrl + shuffledDeck[99].Image.src}
        alt={baseUrl + shuffledDeck[99].Image.alt}
      />
    </div>
  );
}
