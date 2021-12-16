// import cardFunction from "../returnsFunction/cardFunction";

export default function Card({ shuffledDeck, index }) {
  const baseUrl = "Images/";

  return <div>{checkDeck(shuffledDeck, index)()}</div>;

  // 📝 Checks if deck has been loaded before rendering
  function checkDeck(deck, index) {
    if (deck[index] != undefined) {
      return () => {
        return (
          <img
            src={baseUrl + deck[index].Image.src}
            alt={baseUrl + deck[index].Image.alt}
          />
        );
      };
    } else {
      return () => {
        return (
          <img src={baseUrl + "tux.svg"} alt={baseUrl + "Card not found"} />
        );
      };
    }
  }
}
