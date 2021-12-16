import ReactDOM from "react-dom";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import "./index.css";
import Card from "./components/Card";

ReactDOM.render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<Card />} />
    </Routes>
  </BrowserRouter>,
  document.getElementById("root")
);
