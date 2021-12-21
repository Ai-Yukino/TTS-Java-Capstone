import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import Index from "./Routes/Index";
import Get from "./Routes/Get";
import Post from "./Routes/Post";

ReactDOM.render(
  <BrowserRouter>
    <Routes>
      <Route path="/GET" element={<Get />} />
      <Route path="/POST" element={<Post />} />
      <Route path="/" element={<Index />} />
    </Routes>
  </BrowserRouter>,
  document.getElementById("root")
);
