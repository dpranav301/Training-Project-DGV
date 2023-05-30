import React, { useState } from "react";
import axios from "axios";
import { useNavigate, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.css";
const RegisterPage = () => {
  const navigate = useNavigate();

  const [user, setUser] = useState("");
  const [password, setPassword] = useState("");

  const handleUserChange = (e) => {
    setUser(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleRegister = () => {
    const data = {
      userName: user,
      userPassword: password,
    };
    console.log(data);
    // Make an Axios POST request to your Spring application
    axios
      .post("http://localhost:8080/user/register", data)
      .then((response) => {
        // Handle the response from the server
        alert(response.data.userName + " has registered successfully");
      })
      .catch((error) => {
        // Handle error
        console.error(error);
      });
  };

  return (
    <div className="container">
      <h1 className="mt-5">Register Page</h1>
      <div className="mb-3">
        <label htmlFor="email" className="form-label">
          User:
        </label>
        <input
          type="text"
          id="userName"
          className="form-control"
          value={user}
          onChange={handleUserChange}
        />
      </div>

      <div className="mb-3">
        <label htmlFor="password" className="form-label">
          Password:
        </label>
        <input
          type="password"
          id="userPassword"
          className="form-control"
          value={password}
          onChange={handlePasswordChange}
        />
      </div>

      <button className="btn btn-primary" onClick={handleRegister}>
        Register
      </button>
      <p>Press the button to go back to Home</p>
      <Link to="/">
        <button className="btn btn-secondary">Home</button>
      </Link>
    </div>
  );
};

export default RegisterPage;
