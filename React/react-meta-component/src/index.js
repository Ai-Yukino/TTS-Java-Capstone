import ReactDOM from "react-dom";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import "./index.css";
import Game from "./routes/Game";
import Results from "./routes/Results";

ReactDOM.render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<Game />} />
      {/* <Results /> */}
    </Routes>
  </BrowserRouter>,
  document.getElementById("root")
);
