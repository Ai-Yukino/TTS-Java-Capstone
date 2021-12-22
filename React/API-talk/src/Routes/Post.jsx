import { useEffect } from "react";


export default function Post() {
  useEffect(() => {
    async function myPost() {
      let url = "http://localhost:8080/login";
      let request = {
        method: "POST",
        mode: "cors",
        headers: {
          'Accept': 'application/json',
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          username: "admin",
          password: "nimda",
        }),
      };

      
      let response = await fetch(url, request);

      var token = response.headers.get('authorization');
      console.log(token);
      localStorage.setItem('token', token);
      var x = localStorage.getItem('token');
      console.log("Token: " + x);

      for(const header of response.headers){
        console.log(header);
     }
     
      
        
    }
    
    
    myPost();
  });
  return <div>Get the JWT?</div>;
}
