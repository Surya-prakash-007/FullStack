import React from 'react';
import Footer from './Footer';
import Navbar from '../../components/Navbar';
import '/src/assets/css/About.css';

function About() {
  return (
    
    <div>
      <Navbar/>
    <div className="about-container">
    <div>
    <h1>About Us</h1>
    </div>
      
      <p>
        Welcome to Students Enquiry, where we are passionate about nurturing students enthusiasts and helping them reach their full potential in the game of chess.
      </p>
      <p>
        At Students course, we believe that chess is more than just a game; it's a journey of strategic thinking, skill development, and intellectual growth. Our mission is to provide a platform for players of all levels, from beginners to advanced, to learn, practice, and excel in the world of chess.
      </p>
      <p>
        What sets us apart:
      </p>
      <ul>
        <p>Experienced Coaches: Learn from our team of experienced and dedicated chess coaches who are committed to guiding you on your chess journey.
        Comprehensive Courses: Explore our comprehensive courses designed to cover various aspects of chess, including openings, tactics, endgames, and more.
        Community Engagement: Join a thriving community of chess enthusiasts, participate in tournaments, and engage in discussions to enhance your chess experience.
        </p>
      </ul>
    </div>
      <Footer/>
      </div>
  );
}

export default About;