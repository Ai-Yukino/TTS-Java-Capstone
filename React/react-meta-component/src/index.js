import ReactDOM from "react-dom";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import "./index.css";
import Game from "./routes/Game";

ReactDOM.render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<Game />} />
    </Routes>
  </BrowserRouter>,
  document.getElementById("root")
);
