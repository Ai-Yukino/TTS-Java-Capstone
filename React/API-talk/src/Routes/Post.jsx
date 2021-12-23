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
      let date = new Date();
      date.setTime(date.getTime()+(1*60*60*1000));
      document.cookie = "access_token " + " = " + token + "; expires = " + date.toGMTString();

      //view cookie
      // let cookie = document.cookie.split(';');
      // console.log('cookie : ', cookie);
     
      
  
    }
    
    
    myPost();
  });
  return <div>Get the JWT?</div>;
}
