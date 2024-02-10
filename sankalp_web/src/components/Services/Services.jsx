import React, { useContext } from "react";
import "./Services.css";
import Card from "../Card/Card";
// import HeartEmoji from "../../img/heartemoji.png";
// import Glasses from "../../img/glasses.png";
// import Humble from "../../img/humble.png";
import { themeContext } from "../../Context";
// import { motion } from "framer-motion";
// import Resume from './resume.pdf';

const Services = () => {
  // context
  const theme = useContext(themeContext);
  const darkMode = theme.state.darkMode;

  // transition
  // const transition = {
  //   duration: 1,
  //   type: "spring",
  // };

  return (
   
<div className="container">
  <div> WHAT WE DO </div>
    <div className="row">
        <div className="col-md-3 col-sm-6">
            <div className="serviceBox">
                <div className="service-icon">
                    {/* <span><i className="fa fa-globe"></i></span> */}
                </div>
                <h3 className="title">1</h3>
                <p className="description">Lorem ipsum dolor sit amet conse ctetur adipisicing elit. Qui quaerat fugit quas veniam perferendis repudiandae sequi, dolore quisquam illum.</p>
            </div>
        </div>
        <div className="col-md-3 col-sm-6">
            <div className="serviceBox pink">
                <div className="service-icon">
                    {/* <span><i className="fa fa-rocket"></i></span> */}
                </div>
                <h3 className="title">2</h3>
                <p className="description">Lorem ipsum dolor sit amet conse ctetur adipisicing elit. Qui quaerat fugit quas veniam perferendis repudiandae sequi, dolore quisquam illum.</p>
            </div>
        </div>
        <div className="col-md-3 col-sm-6">
            <div className="serviceBox">
                <div className="service-icon">
                    {/* <span><i className="fa fa-globe"></i></span> */}
                </div>
                <h3 className="title">3</h3>
                <p className="description">Lorem ipsum dolor sit amet conse ctetur adipisicing elit. Qui quaerat fugit quas veniam perferendis repudiandae sequi, dolore quisquam illum.</p>
            </div>
        </div>
        <div className="col-md-3 col-sm-6">
            <div className="serviceBox">
                <div className="service-icon">
                    {/* <span><i className="fa fa-globe"></i></span> */}
                </div>
                <h3 className="title">4</h3>
                <p className="description">Lorem ipsum dolor sit amet conse ctetur adipisicing elit. Qui quaerat fugit quas veniam perferendis repudiandae sequi, dolore quisquam illum.</p>
            </div>
        </div>
    </div>
</div>
  );
};

export default Services;
