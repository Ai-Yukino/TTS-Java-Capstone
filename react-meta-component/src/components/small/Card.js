import cardFunction from "../returnsFunction/cardFunction";

export default function Card({ shuffledDeck, index }) {
  return <div>{cardFunction(shuffledDeck, index)()}</div>;
}
