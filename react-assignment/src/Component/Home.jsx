import React from "react";
import { useNavigate } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.css";

const HomePage = () => {
  const navigate = useNavigate();

  const handleLoginClick = () => {
    navigate("/login");
  };

  const handleRegisterClick = () => {
    navigate("/register");
  };

  const divStyle = {
    backgroundImage: 'url("https://wallpapercave.com/wp/wp4289147.jpg")',
    backgroundRepeat: "no-repeat",
    backgroundPosition: "center",
    backgroundSize: "cover",
    backgroundColor: "rgba(0, 0, 0, 0.5)", // Set the background color with transparency
    height: "100vh", // Set the height of the container to cover the whole page
    display: "flex",
    flexDirection: "column",
    justifyContent: "center",
    alignItems: "center",
    color: "yellow", // Set the font color to white
  };

  return (
    <div className="container-fluid" style={divStyle}>
      <h1 className="mt-5">Welcome to Restaurant Management System</h1>
      <div className="mt-4">
        <button className="btn btn-primary me-3" onClick={handleLoginClick}>
          Login
        </button>
        <button className="btn btn-success" onClick={handleRegisterClick}>
          Register
        </button>
      </div>
    </div>
  );
};

export default HomePage;
