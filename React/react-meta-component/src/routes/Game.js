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
      <div>
        <div className={"min-height-100vh" + " " + "bgColor"}>
          <div
            className={
              "min-height-75vh" + " " + "bgColor-burlywood" + " " + "flex"
            }
          >
            <div className={"bgColor-red"}>yo</div>
            <div className={"bgColor-blue"}>hi</div>
          </div>
          <div className={"bgColor-antiquewhite"}></div>
        </div>
        {/* <h2>Cards remaining: {shuffledDeck.length}</h2> */}
      </div>
    );
  } else {
    return <></>;
  }
}

// 📝 playerActions
// stand, hit, doubleDown, split, surrender
