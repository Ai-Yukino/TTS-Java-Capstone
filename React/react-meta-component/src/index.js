import ReactDOM from "react-dom";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import "./index.css";
// We still need to import the rest of the route compoments
import Game from "./routes/Game";
import Menu from "./routes/Menu";

ReactDOM.render(
  <BrowserRouter>
    <Routes>
      {/* We still need to route the rest of the route compoments btw */}
      <Route path="/" element={<Game />} />
      <Route path="/Menu" element={<Menu />} />
    </Routes>
  </BrowserRouter>,
  document.getElementById("root")
);
