import React, { useContext } from "react";
import "./Works.css";
import firstwork from "../../img/icons8-anonymous-48.png"
import secwork from "../../img/icons8-assistance-68.png"
import thirdwork from "../../img/icons8-counseling-64.png"
import fourthwork from "../../img/Assistance.png"
import fifthwork from "../../img/icons8-social-64.png"
import { themeContext } from "../../Context";
import { motion } from "framer-motion";
const Works = () => {
  // context
  const theme = useContext(themeContext);
  const darkMode = theme.state.darkMode;

  // transition
  return (
    <div className="works" id="works">
      {/* left side */}
      <div className="w-left">
        <div className="awesome">
          {/* dark Mode */}
          <span style={{ color: darkMode ? "white" : "" }}>
          HOW CAN WE HELP?
          </span>
          <span></span>
          <spane>
          With personalized support, local resources, and habit tracking features,
            <br />
             we're committed to aiding your journey towards recovery. Let's take positive steps together.           
            <br />
            Subscribe for exclusive access to video assistance and inspiring content. 
            
            <br />
          </spane>
          <div
            className="blur s-blur1"
            style={{ background: "#ABF1FF94" }}
          ></div>
        </div>

        {/* right side */}
      </div>
      <div className="w-right">
        <motion.div
          initial={{ rotate: 45 }}
          whileInView={{ rotate: 0 }}
          viewport={{ margin: "-40px" }}
          transition={{ duration: 3.5, type: "spring" }}
          className="w-mainCircle"
        >
          <div className="w-secCircle">
            <img src={firstwork} alt="" />
          </div>
          <div className="w-secCircle">
            <img src={secwork} alt="" />
          </div>
          <div className="w-secCircle">
            <img src={thirdwork} alt="" />
          </div>{" "}
          <div className="w-secCircle">
            <img src={fourthwork} alt="" />
          </div>
          <div className="w-secCircle">
            <img src={fifthwork} alt="" />
          </div>
        </motion.div>
        {/* background Circles */}
        <div className="w-backCircle blueCircle"></div>
        <div className="w-backCircle yellowCircle"></div>
      </div>
    </div>
  );
};

export default Works;
