import React, { useContext } from "react";
import "./Intro.css";
import frnds from "../../img/Truefriends.svg"
// import { themeContext } from "../../Context";
// import { motion } from "framer-motion";
// import { Link } from "react-scroll";
const Intro = () => {
  // Transition

  // context

  return (
    <div className="Intro" id="Intro">
      <div class="container">
	<div class="avatar">
    <div> hello World</div>
			<img src={frnds} alt="Skytsunami" />
	</div>
  </div>
    </div>
  );
};

export default Intro;
