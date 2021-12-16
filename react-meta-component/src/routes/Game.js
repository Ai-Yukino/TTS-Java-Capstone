import { useEffect, useState } from "react";
import Card from "../components/small/Card";

export default function Game() {
  // 📝 Initialize state so VSCode doesn't cry
  const [shuffledDeck, setShuffledDeck] = useState([]);

  useEffect(() => {
    async function fetchData(url) {
      const response = await fetch(url);
      const data = await response.json();
      setShuffledDeck(data);
    }
    console.log(shuffledDeck);
    fetchData("Data/Testing/shuffledDeck.json");
    console.log(shuffledDeck);
  }, []);

  const baseUrl = "Images/";

  return (
    <Card
      src={baseUrl + shuffledDeck[99].Image.src}
      alt={baseUrl + shuffledDeck[99].Image.alt}
    />
  );
}
