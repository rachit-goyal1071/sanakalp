import Navbar from "./components/Navbar/Navbar";
import "./App.css";
import { useContext } from "react";
import { themeContext } from "./Context";
import Intro from "./components/Intro/Intro";
import Services from "./components/Services/Services";
import Experience from "./components/Experience/Experience";
import Works from "./components/Works/Works";
import FAQ from "./components/FAQ/FAQ";

function App() {
  const theme = useContext(themeContext);
  const darkMode = theme.state.darkMode;
  return (
    <div
      className="App"
      style={{
        background: darkMode ? "black" : "",
        color: darkMode ? "white" : "",
      }}
    >
      <Navbar />
      <Intro/>
      <Services/>
      <Experience/>
      <Works/>
      <FAQ/>
    </div>
  );
}

export default App;
