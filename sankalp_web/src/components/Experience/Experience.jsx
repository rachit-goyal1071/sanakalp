import React, { useContext } from "react";
import { themeContext } from "../../Context";
import "./Experience.css";
const Experience = () => {
  const theme = useContext(themeContext);
  const darkMode = theme.state.darkMode;

  return (
    <div className="experience" id='experience'>
      <div className="achievement">
        {/* darkMode */}
        <div className="circle" style={{color: darkMode?'var(--orange)':''}}>9.4L+</div>
        <span  style={{color: darkMode?'white':''}}> </span>
        <span>Cocain</span>
      </div>
      <div className="achievement">
        <div className="circle" style={{color: darkMode?'var(--orange)':''}}>70%</div>
        <span  style={{color: darkMode?'white':''}}> </span>
        <span>Suicides</span>
      </div>
      <div className="achievement">
        <div className="circle" style={{color: darkMode?'var(--orange)':''}}>98.6%</div>
        <span  style={{color: darkMode?'white':''}}> </span>
        <span>Considers serious</span>
      </div>
    </div>
  );
};

export default Experience;
