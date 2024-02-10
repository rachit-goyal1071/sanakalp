import React from 'react'
import "./FAQ.css"

const FAQ = () => {
  return (
    <div class="accordion">
    <h1>Frequently Asked Questions</h1>
    <div class="accordion-item">
        <input type="checkbox" id="accordion1"/>
        <label for="accordion1" class="accordion-item-title"><span class="icon"></span>Are the counselors certified professionals?</label>
        <div class="accordion-item-desc">Yes, all counselors on our platform are certified professionals with expertise in drug addiction counseling. They undergo rigorous training and adhere to strict ethical guidelines.</div>
    </div>

    <div class="accordion-item">
        <input type="checkbox" id="accordion2"/>
        <label for="accordion2" class="accordion-item-title"><span class="icon"></span>Can I access support from local organizations through the app?</label>
        <div class="accordion-item-desc">Absolutely, we collaborate with NGOs to offer users access to local resources, treatment facilities, and community support groups, providing comprehensive assistance tailored to your location and needs.</div>
    </div>

    <div class="accordion-item">
        <input type="checkbox" id="accordion3"/>
        <label for="accordion3" class="accordion-item-title"><span class="icon"></span>How does the habit tracking feature help users?</label>
        <div class="accordion-item-desc">Our habit tracking feature allows users to set goals, monitor progress, and build positive routines. With streaks to motivate consistency, users can visualize their achievements and stay focused on breaking harmful habits and fostering healthier ones.</div>
    </div>

    <div class="accordion-item">
        <input type="checkbox" id="accordion4"/>
        <label for="accordion4" class="accordion-item-title"><span class="icon"></span>Is my data secure and confidential?</label>
        <div class="accordion-item-desc">Yes, we prioritize the security and confidentiality of your data. We use encryption and other security measures to safeguard your information, ensuring that your conversations and personal details remain private.</div>
    </div>

    <div class="accordion-item">
        <input type="checkbox" id="accordion5"/>
        <label for="accordion5" class="accordion-item-title"><span class="icon"></span>Are there any additional costs for accessing certain features or services?</label>
        <div class="accordion-item-desc">No, all features and services included in the app are covered by the subscription fee. There are no hidden costs or additional charges for accessing premium content or support from certified professionals.</div>
    </div>

</div>
  )
}

export default FAQ
