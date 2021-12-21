import ReactDOM from "react-dom";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import "./index.css";
<<<<<<< HEAD
// We still need to import the rest of the route compoments
import Game from "./routes/Game";
import Menu from "./routes/Menu";
=======

import Game from "./routes/Game";
import HowToPlay from "./routes/HowToPlay";
import Login from "./routes/Login";
import Menu from "./routes/Menu";
import Results from "./routes/Results";
>>>>>>> origin/main

ReactDOM.render(
  <BrowserRouter>
    <Routes>
<<<<<<< HEAD
      {/* We still need to route the rest of the route compoments btw */}
      <Route path="/" element={<Game />} />
      <Route path="/Menu" element={<Menu />} />
=======
      <Route path="/" element={<Menu />} />
      <Route path="/game" element={<Game />} />
      <Route path="/how-to" element={<HowToPlay />} />
      <Route path="/login" element={<Login />} />
      <Route path="/results" element={<Results />} />
>>>>>>> origin/main
    </Routes>
  </BrowserRouter>,
  document.getElementById("root")
);
