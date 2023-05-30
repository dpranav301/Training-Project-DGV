import React from "react";
import { useNavigate, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.css";

const HomePage = () => {
  const navigate = useNavigate();

  const handleAddFood = () => {
    navigate("/addFood");
  };

  const handleSeeBill = () => {
    navigate("/seeBill");
  };

  const handleLogout = () => {
    const userName = JSON.parse(sessionStorage.getItem("user")).userName;
    sessionStorage.clear();
    alert(userName + " has logged out successfully");
    navigate("/login");
  };

  const LoginPage = () => {
    return (
      <div>
        <p>Press Button to go back to the LogIn page</p>
        <Link to="/login">
          <button className="btn btn-primary">Back</button>
        </Link>
      </div>
    );
  };
  return (
    <div className="container text-left">
      <h1 className="mt-5">
        Welcome {JSON.parse(sessionStorage.getItem("user")).userName}
      </h1>
      <div className="mt-4">
        <div className="d-flex align-items-center">
          <p className="mr-3">1.Place order</p>
          <button className="btn btn-primary" onClick={handleAddFood}>
            Add Product
          </button>
        </div>
        <div className="d-flex align-items-center mt-3">
          <p className="mr-3">2.See Bill</p>
          <button className="btn btn-primary" onClick={handleSeeBill}>
            See Bill
          </button>
        </div>
        <div className="d-flex align-items-center mt-3">
          <p className="mr-3">3.Logout</p>
          <button className="btn btn-primary" onClick={handleLogout}>
            Logout
          </button>
        </div>
      </div>
      <p className="mt-4 text-left">Press Button to go back to Login</p>
      <Link to="/login">
        <button className="btn btn-primary">Back</button>
      </Link>
    </div>
  );
};
export default HomePage;
