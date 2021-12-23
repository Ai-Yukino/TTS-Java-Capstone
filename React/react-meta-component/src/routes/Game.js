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
      <div
        className={
          "flex" +
          " " +
          "direction-column" +
          " " +
          "justify-space-between" +
          " " +
          "fixed-height-100vh"
        }
      >
        <div
          className={
            "bgColor-cherry-blossom" +
            " " +
            "flex" +
            " " +
            "justify-space-between" +
            " " +
            "fixed-height-70vh"
          }
        >
          <div
            className={
              "bgColor-coarse-wool" +
              " " +
              "flex" +
              " " +
              "direction-column" +
              " " +
              "justify-space-between" +
              " " +
              "fixed-width-15-percent" +
              " " +
              "margin-2-percent"
            }
          >
            <div
              className={
                "bgColor-cypress-bark" + " " + "fixed-height-7_5-percent"
              }
            ></div>
            <div
              className={
                "bgColor-lapis-lazuli" + " " + "fixed-height-91-percent"
              }
            ></div>
          </div>
          <div
            className={
              "bgColor-young-bamboo" +
              " " +
              "fixed-width-75-percent" +
              " " +
              "margin-2-percent"
            }
          >
            {/* <div className={"bgColor" + " "}></div> */}
          </div>
        </div>
        <div
          className={
            "bgColor-wisteria" + " " + "flex" + " " + "fixed-height-25vh"
          }
        ></div>
      </div>
    );
  } else {
    return <></>;
  }
}

// 📝 playerActions
// stand, hit, doubleDown, split, surrender

{
  /* <h2>Cards remaining: {shuffledDeck.length}</h2>; */
}
