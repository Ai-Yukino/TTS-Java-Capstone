import { useEffect, useState } from "react";

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

  console.log(shuffledDeck);

  const baseUrl = "Images/";

  function renderCard(index) {
    return (index) => {
      return (
        <img
          src={baseUrl + shuffledDeck[index].Image.src}
          alt={baseUrl + shuffledDeck[index].Image.alt}
        />
      );
    };
  }

  return (
    <div>
      <div>Number of cards: {shuffledDeck.length}</div>
      <div>
        <div>
          {shuffledDeck[120] != null ? renderCard()(120) : <>No card found</>}
        </div>
        <div>
          {shuffledDeck[99] != null ? renderCard()(99) : <>No card found</>}
        </div>
        <div>
          {shuffledDeck[54] != null ? renderCard()(54) : <>No card found</>}
        </div>
        <div>
          {shuffledDeck[123] != null ? renderCard()(123) : <>No card found</>}
        </div>
      </div>
    </div>
  );
}
