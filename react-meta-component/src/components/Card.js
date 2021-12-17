export default function Card({
  src = undefined,
  alt = undefined,
  width = "15%",
  height = undefined,
}) {
  const baseUrl = "Images/";
  if (src != undefined && alt != undefined) {
    return <img src={src} alt={alt} width={width} height={height} />;
  } else {
    return (
      <img
        src={baseUrl + "tux.svg"}
        alt={"Card not found; Tux says hi"}
        width={width}
        height={height}
      />
    );
  }
}

// export default function Card({ deck, index }) {
//   const baseUrl = "Images/";

//   if (deck[index] != undefined) {
//     return (
//       <img src={baseUrl + deck[index].Image.src} alt={deck[index].Image.alt} />
//     );
//   } else {
//     return (
//       <img src={baseUrl + "tux.svg"} alt={"Card not found; Tux says hi"} />
//     );
//   }
// }
