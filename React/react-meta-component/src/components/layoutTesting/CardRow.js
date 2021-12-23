import "../../css/atomic.css";
import FakeCards from "./FakeCards";

export default function CardRow({ n }) {
  return (
    <div
      className={
        "bgColor-white-mouse" +
        " " +
        "flex" +
        " " +
        "justify-center" +
        " " +
        "align-center" +
        " " +
        "fixed-height-47_5-percent"
      }
    >
      <FakeCards n={n} />
    </div>
  );
}
