import { useEffect } from "react";

export default function GetAPI() {
  useEffect(() => {
    async function myPost() {
      let url = "http://localhost:8080/login/";
      let request = {
        method: "POST",
        mode: "cors",
        headers: {
          "Content-Type": "application/json",
        },
      };

      const response = await fetch(url, request);
      const json = await response.json();
      console.log(json);
    }
    myPost();
  });
  return <div>Get the JWT?</div>;
}
