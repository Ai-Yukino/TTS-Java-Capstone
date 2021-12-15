import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
// import App from "./App";
import Game from "./routes/Game.js";

ReactDOM.render(
  <React.StrictMode>
    <Game />
  </React.StrictMode>,
  document.getElementById("root")
);
