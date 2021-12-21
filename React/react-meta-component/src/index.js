import ReactDOM from "react-dom";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import "./index.css";

import Game from "./routes/Game";
import HowToPlay from "./routes/HowToPlay";
import Login from "./routes/Login";
import Menu from "./routes/Menu";
import Results from "./routes/Results";

ReactDOM.render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<Menu />} />
      <Route path="/game" element={<Game />} />
      <Route path="/how-to" element={<HowToPlay />} />
      <Route path="/login" element={<Login />} />
      <Route path="/results" element={<Results />} />
    </Routes>
  </BrowserRouter>,
  document.getElementById("root")
);
