import '../css/atomic-DEFCON2.css';
import {Link} from 'react-router-dom';

export default function Menu() {
  return (
    <div className="position-center-flex">
      <div className={
      "colorBG-charcoal" +
      " " +
      "colorBorder-darkGreen" +
      " " +
      "dimension-div-menu" +
      " " +
      "position-center-flex"}>
        <div className={
        "colorBG-darkBrown" +
        " " +
        "colorBorderBottom-darkGreen" +
        " " +
        "dimension-div-menuBar" +
        " " +
        "position-top-flex" +
        " " +
        "positionText-center-flex"}>
          <h1 className="positionTest-center-flex">
          ♦️♣️ BlackJack-TTS ♠️♥️
          </h1>
        </div>
        <div className={
          "position-overlay" +
          " " +
          "style-remove-hyperlinks" +
          " " +
          "position-column-flex"
          }>
          <Link to="/game">♥️ Log In</Link>
          <Link to="/game">♠️ Create Account</Link>
          <Link to="/how-to">♦️ How To Play</Link>
          <Link to="">♣️ Results</Link>
        </div>
      </div>
    </div>
  );
}
