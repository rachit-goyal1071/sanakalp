import Navbar from "./components/Navbar/Navbar";
import "./App.css";
import { useContext } from "react";
import { themeContext } from "./Context";
import Intro from "./components/Intro/Intro";
import Services from "./components/Services/Services";
import Experience from "./components/Experience/Experience";
import Works from "./components/Works/Works";
import FAQ from "./components/FAQ/FAQ";
import Contact from "./components/Contact/Contact";
import Footer from "./components/Footer/Footer";

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
      <Contact/>
      <Footer/>
    </div>
  );
}

export default App;