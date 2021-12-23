import "../../css/atomic.css";

export default function FakeCards({ n }) {
  let cards = [];
  for (let i = 0; i < n; i++) {
    cards[i] = <FakeCard />;
  }

  return (
    <div
      className={
        "bgColor-washed-out-crimson" +
        " " +
        "flex" +
        " " +
        "justify-space-around"
      }
    >
      {cards}
    </div>
  );
}

function FakeCard() {
  return (
    <div
      className={
        "bgColor-unbleached-silk" +
        " " +
        "fixed-width-17_5-vh" +
        " " +
        "fixed-height-24_5-vh" +
        " " +
        "margin-0-1-vw"
      }
    ></div>
  );
}
