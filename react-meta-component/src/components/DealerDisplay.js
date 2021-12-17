import Card from "./Card";

import "../css/atomic.css";

export default function DealerDisplay({
  cardHand = [],
  PlayerActions = {
    insuranceBet: false,
    stand: false,
    hit: false,
    doubleDown: false,
    split: false,
    surrender: false,
  },
}) {
  return (
    <div className={"flex" + " " + "column" + " " + "center-align"}>
      <div
        className={
          "flex" +
          " " +
          "center" +
          " " +
          "bgColor-antiquewhite" +
          " " +
          "set-width-60vw" +
          " " +
          "padding-top" +
          " " +
          "padding-bottom" +
          " " +
          "border-radius-10px" +
          " " +
          "margin-bottom"
        }
      >
        <div
          className={
            "flex" + " " + "space-evenly-justify" + " " + "set-width-100percent"
          }
        >
          <Card src={"Images/AH.svg"} alt={"Ace of hearts"} width={"200px"} />
          <Card src={undefined} alt={"Ace of hearts"} width={"200px"} />
        </div>
      </div>
    </div>
  );
}
