import React from "react";
import "./Footer.css";

const Footer = () => {
  return (
    <>
    <div className="footerMain">
<footer class="footer">
  <div class="footer__addr">
    <h1 class="footer__logo">SANKALP</h1>
        
    <h2>Contact</h2>
    
    <address>
      INDIA<br/>
          
      <a class="footer__btn" href="mailto:example@gmail.com">Email Us</a>
    </address>
  </div>
  
  <ul class="footer__nav">
    <li class="nav__item">
      <h2 class="nav__title">Useful Links:</h2>

      <ul class="nav__ul">
        <li>
          <a href="#">Articles</a>
        </li>

        <li>
          <a href="#">Resources</a>
        </li>
            
        <li>
          <a href="#">Helplines</a>
        </li>
      </ul>
    </li>
    
    <li class="nav__item nav__item--extra">
      <h2 class="nav__title">Support Groups:</h2>
      
      <ul class="nav__ul nav__ul--extra">
        <li>
          <a href="#">Local/online groups</a>
        </li>
      </ul>
    </li>
    <li class="nav__item nav__item--extra">
      <h2 class="nav__title">Support Groups:</h2>
      
      <ul class="nav__ul nav__ul--extra">       
        <li>
          <a href="#">Community organizations</a>
        </li>
      </ul>
    </li>
    
    <li class="nav__item">
      <h2 class="nav__title">Legal</h2>
      
      <ul class="nav__ul">
        <li>
          <a href="#">Privacy Policy</a>
        </li>
        
        <li>
          <a href="#">Terms of Use</a>
        </li>
        
        {/* <li>
          <a href="#">Sitemap</a>
        </li> */}
      </ul>
    </li>
  </ul>
  
  <div class="legal">
    <p>&copy; 2024 SANKALP. All rights reserved.</p>
    
    <div class="legal__links">
      <span>Made with <span class="heart">♥</span> by Team SANKALP</span>
    </div>
  </div>
</footer>
</div>
</>
  );
};

export default Footer;
