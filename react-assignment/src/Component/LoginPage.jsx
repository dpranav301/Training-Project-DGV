import React, { useState } from "react";
import axios from "axios";
import { useNavigate, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.css";
const LoginPage = () => {
  const navigate = useNavigate();

  const [user, setUser] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");

  const handleUserChange = (e) => {
    setUser(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleLogin = () => {
    const data = {
      userName: user,
      userPassword: password,
    };

    // Make an Axios POST request to your Spring application
    axios
      .post("http://localhost:8080/user/login", data)
      .then((response) => {
        if (response.data.userName != null) {
          sessionStorage.setItem("user", JSON.stringify(response.data));
          if (response.data.userRole === "Admin") {
            navigate("/admin-dashboard");
          } else {
            navigate("/customer-dashboard");
          }
        } else {
          setError("Invalid credentials. Please try again.");
        }
      })
      .catch((error) => {
        setError("An error occurred. Please try again later.");
      });
  };

  return (
    <div className="container">
      <h1 className="mt-5">Login Page</h1>
      <div className="mb-3">
        <label htmlFor="email" className="form-label">
          Email:
        </label>
        <input
          type="email"
          id="user"
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
          id="password"
          className="form-control"
          value={password}
          onChange={handlePasswordChange}
        />
      </div>

      <button className="btn btn-primary" onClick={handleLogin}>
        Login
      </button>
      {error && <p className="text-danger mt-3">{error}</p>}
      <p>Press the button to go back to Home</p>
      <Link to="/">
        <button className="btn btn-secondary">Home</button>
      </Link>
    </div>
  );
};

export default LoginPage;
