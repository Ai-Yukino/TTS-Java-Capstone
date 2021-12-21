import { useEffect } from "react";

export default function Get() {
  useEffect(() => {
    async function myGet(baseURL, query) {
      let request = {
        method: "GET",
        mode: "cors",
        headers: {
          "Content-Type": "application/json",
        },
      };

      const response = await fetch(baseURL + query, request);
      const data = await response.json();
      console.log(data);
    }

    const baseURL = "http://localhost:8080";
    // const noQuery = "/greeting";
    const query = "/greeting?name=" + "Daniel";
    myGet(baseURL, query);
  });
  return <div>Get the JSON?</div>;
}
