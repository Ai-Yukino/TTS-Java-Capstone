import { useEffect } from "react";

export default function Post() {
  useEffect(() => {
    async function myPost() {
      let url = "http://localhost:8080/login";
      let request = {
        method: "POST",
        mode: "cors",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          username: "admin",
          password: "nimda",
        }),
      };

      const response = await fetch(url, request);
      // const json = await response.json();
      console.log(response);
    }
    myPost();
  });
  return <div>Get the JWT?</div>;
}
