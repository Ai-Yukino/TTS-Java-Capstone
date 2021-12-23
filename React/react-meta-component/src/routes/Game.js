import { useEffect, useState } from "react";
import Card from "../components/Card";

import DealerDisplay from "../components/DealerDisplay";
import CardRow from "../components/layoutTesting/CardRow";
import FakeButton from "../components/layoutTesting/FakeButton";
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
                "bgColor-cypress-bark" +
                " " +
                "flex" +
                " " +
                "justify-center" +
                " " +
                "fixed-height-7_5-percent"
              }
            >
              <div
                className={"bgColor-patina" + " " + "fixed-width-60-percent"}
              ></div>
            </div>
            <div
              className={
                "bgColor-lapis-lazuli" +
                " " +
                "flex" +
                " " +
                "direction-column" +
                " " +
                "fixed-height-91-percent"
              }
            >
              <div
                className={
                  "bgColor-vine-grape" +
                  " " +
                  "fixed-height-20-percent" +
                  " " +
                  "margin-8-percent"
                }
              ></div>
            </div>
          </div>
          <div
            className={
              "bgColor-young-bamboo" +
              " " +
              "flex" +
              " " +
              "justify-center" +
              " " +
              "fixed-width-75-percent" +
              " " +
              "margin-2-percent"
            }
          >
            <div
              className={
                "bgColor-gamboge" +
                " " +
                "flex" +
                " " +
                "direction-column" +
                " " +
                "justify-space-between" +
                " " +
                "fixed-width-95-percent"
              }
            >
              <CardRow n={2} />
              <CardRow n={5} />
            </div>
          </div>
        </div>
        <div
          className={
            "bgColor-wisteria" +
            " " +
            "flex" +
            " " +
            "direction-column" +
            " " +
            "justify-space-between" +
            " " +
            "fixed-height-25vh"
          }
        >
          <div
            className={
              "bgColor-cypress-bark" +
              " " +
              "flex" +
              " " +
              "justify-center" +
              " " +
              "fixed-height-5-vh"
            }
          >
            <div
              className={"bgColor-patina" + " " + "fixed-width-15-percent"}
            ></div>
          </div>
          <div
            className={
              "bgColor-lapis-lazuli" +
              " " +
              "flex" +
              " " +
              "direction-column" +
              " " +
              "align-center" +
              " " +
              "justify-center" +
              " " +
              "fixed-height-18_5vh"
            }
          >
            <div
              className={
                "bgColor-mousy-wisteria" +
                " " +
                "flex" +
                " " +
                "justify-space-between" +
                " " +
                "fixed-height-16vh" +
                " " +
                "fixed-width-80vw"
              }
            >
              <div
                className={
                  "bgColor-bellflower" + " " + "fixed-width-25-percent"
                }
              >
                <div
                  className={
                    "bgColor-young-bamboo" +
                    " " +
                    "fixed-height-80-percent" +
                    " " +
                    "margin-5-percent"
                  }
                ></div>
              </div>
              <div
                className={
                  "bgColor-mulberry" +
                  " " +
                  "flex" +
                  " " +
                  "justify-space-around" +
                  " " +
                  "fixed-width-72_5-percent"
                }
              >
                <FakeButton />
                <FakeButton n={2} />
                <FakeButton />
                <FakeButton />
              </div>
            </div>
          </div>
        </div>
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
