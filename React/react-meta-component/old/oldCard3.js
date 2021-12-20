export default function Card({ deck, index }) {
  const baseUrl = "Images/";

  if (deck[index] != undefined) {
    return (
      <img src={baseUrl + deck[index].Image.src} alt={deck[index].Image.alt} />
    );
  } else {
    return (
      <img src={baseUrl + "tux.svg"} alt={"Card not found; Tux says hi"} />
    );
  }
}
