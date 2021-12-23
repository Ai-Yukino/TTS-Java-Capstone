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
        "positionTest-center-flex"}>
          <h1 className="positionTest-center-flex">
            Foo
          </h1>
        </div>
        <Link to={<Game />}>Log In</Link>
      </div>
    </div>
  );
}
