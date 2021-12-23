import '../css/atomic-DEFCON2.css';
import {Link} from 'react-router-dom';

export default function HowToPlay() {
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
          "position-column-flex" +
          " " +
          "text-align-center"
          }>
            <a target="_blank" href="https://www.blackjack.org/blackjack/how-to-play/">📔 DA RULES</a>
            <a target="_blank" href="https://en.wikipedia.org/wiki/Blackjack#Rules_of_play_at_casinos">📄 Wikipedia and Ties with the Casino</a>
        </div>
      </div>
    </div>
  );
}
