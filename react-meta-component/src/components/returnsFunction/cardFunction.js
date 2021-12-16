// 📝 Nesting is apparently because
// we need to deal with the stale closure problem
export default function cardFunction(shuffledDeck, index) {
  const baseUrl = "Images/";
  if (shuffledDeck[index] != undefined) {
    return () => {
      return (
        <img
          src={baseUrl + shuffledDeck[index].Image.src}
          alt={baseUrl + shuffledDeck[index].Image.alt}
        />
      );
    };
  } else {
    return () => {
      return <img src={baseUrl + "tux.svg"} alt={baseUrl + "Card not found"} />;
    };
  }
}

// 📝 Old code
// export default function Card({ src, alt }) {
//   return <img src={src} alt={alt} />;
// }

// import { useEffect } from "react";
// import { useState } from "react";

// export default function Card() {
//   const [gameState, setGameState] = useState();

//   useEffect(() => {
//     async function fetchData(url) {
//       const response = await fetch(url);
//       const data = await response.json();

//       console.log(data);
//       setGameState(data);
//       console.log(data);
//     }

//     console.log(gameState);
//     fetchData("Data/deck.json");
//     console.log(gameState);
//   }, []);

//   const showCard = () => {
//     return (
//       <div>
//         <img
//           src={"Images/" + gameState[33].Image.src}
//           alt="gameState[33].Image.alt"
//         />
//         <img
//           src={"Images/" + gameState[3].Image.src}
//           alt="gameState[33].Image.alt"
//         />
//         <img
//           src={"Images/" + gameState[39].Image.src}
//           alt="gameState[33].Image.alt"
//         />
//         <img
//           src={"Images/" + gameState[13].Image.src}
//           alt="gameState[33].Image.alt"
//         />
//       </div>
//     );
//   };

//   const displayCard =
//     gameState && gameState.length > 0
//       ? showCard
//       : () => {
//           return <div>Ain't no cards here!</div>;
//         };

//   return <div className="App">{displayCard()}</div>;
// }
