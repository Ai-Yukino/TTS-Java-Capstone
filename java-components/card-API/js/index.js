$.post(
  "http://localhost:8080/login",
  JSON.stringify({ username: "admin", password: "nimda" }),
  (response) => {
    console.log(response);
  }
);
