import "../../css/atomic.css";

function Button() {
  return (
    <div className={"bgColor-celadon" + " " + "fixed-height-35-percent"}></div>
  );
}

export default function FakeButton({ n = 1 }) {
  let buttons = [];
  for (let i = 0; i < n; i++) {
    buttons[i] = <Button />;
  }
  return (
    <div
      className={
        "bgColor-daylily" +
        " " +
        "flex" +
        " " +
        "direction-column" +
        " " +
        "justify-space-around" +
        " " +
        "fixed-width-15-percent"
      }
    >
      {buttons}
    </div>
  );
}
