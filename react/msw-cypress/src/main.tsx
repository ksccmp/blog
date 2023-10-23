import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App.tsx";

// if(process.env.NODE_ENV === 'development') { // 개발에서만 msw 동작
//   worker.start();
// }

ReactDOM.createRoot(document.getElementById("root")!).render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
);
