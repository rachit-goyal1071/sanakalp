import React, { useContext } from "react";
import "./Services.css";
import Card from "../Card/Card";
import first from "../../img/Assistance.png";
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
  <div className="heading"> WHAT WE OFFER </div>
    <div className="row">
        <div className="col-md-3 col-sm-6">
            <div className="serviceBox">
                <div className="service-icon">
                    <span><img src={first} alt="" className="first"/></span>
                </div>
                <h3 className="title">Counseling:</h3>
                <p className="description"> Access professional drug user counseling anonymously through our app.</p>
            </div>
        </div>
        <div className="col-md-3 col-sm-6">
            <div className="serviceBox pink">
                <div className="service-icon">
                <span><img src={first} alt="" className="first"/></span>
                </div>
                <h3 className="title">NGO Support:</h3>
                <p className="description"> Receive additional assistance and resources through partnerships with NGOs.</p>
            </div>
        </div>
        <div className="col-md-3 col-sm-6">
            <div className="serviceBox">
                <div className="service-icon">
                <span><img src={first} alt="" className="first"/></span>
                </div>
                <h3 className="title">Subscription Model: </h3>
                <p className="description">Get personalized video assistance from experts with our subscription-based service.</p>
            </div>
        </div>
        <div className="col-md-3 col-sm-6">
            <div className="serviceBox">
                <div className="service-icon">
                <span><img src={first} alt="" className="first"/></span>
                </div>
                <h3 className="title">Habit Tracking:</h3>
                <p className="description"> Track progress and build positive habits with streaks feature. Plus, find inspiration in our reel section.</p>
            </div>
        </div>
    </div>
</div>
  );
};

export default Services;
