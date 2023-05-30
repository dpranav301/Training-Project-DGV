import React from "react";
import { useNavigate, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.css";
const HomePage = () => {
  const navigate = useNavigate();

  const handleAddProductToInventory = () => {
    navigate("/addToInventory");
  };

  const handleShowInventory = () => {
    navigate("/showInventory");
  };

  const handleDeleteFromInventory = () => {
    navigate("/deleteProductInventory");
  };

  const handleAllBill = () => {
    navigate("/AllBill");
  };
  const handleLogout = () => {
    const userName = JSON.parse(sessionStorage.getItem("user")).userName;
    sessionStorage.clear();
    alert(userName + " is logout sucessfully");
    navigate("/login");
  };

  const LoginPage = () => {
    return (
      <div>
        <p>Press the button to go back to the LogIn page</p>
        <Link to="/login">
          <button className="btn btn-secondary">Back</button>
        </Link>
      </div>
    );
  };

  return (
    <div className="container text-left">
      <h1 className="mt-5">Admin Page</h1>
      <div className="mt-4">
        <div className="d-flex align-items-center">
          <p className="mr-3">1. Add Food To The Inventory</p>
          <button
            className="btn btn-primary"
            onClick={handleAddProductToInventory}
          >
            Add Product
          </button>
        </div>
        <div className="d-flex align-items-center mt-3">
          <p className="mr-3">2. Show Inventory</p>
          <button className="btn btn-primary" onClick={handleShowInventory}>
            Show Inventory
          </button>
        </div>
        <div className="d-flex align-items-center mt-3">
          <p className="mr-3">3. Delete Product From The Inventory</p>
          <button
            className="btn btn-primary"
            onClick={handleDeleteFromInventory}
          >
            Delete Product
          </button>
        </div>
        <div className="d-flex align-items-center mt-3">
          <p className="mr-3">4. See Bill Of All Customers</p>
          <button className="btn btn-primary" onClick={handleAllBill}>
            See Bill
          </button>
        </div>
        <div className="d-flex align-items-center mt-3">
          <p className="mr-3">5.Logout</p>
          <button className="btn btn-primary" onClick={handleLogout}>
            Logout
          </button>
        </div>
      </div>
      <p className="mt-4">Press the button to go back to the Admin Menu</p>
      <Link to="/login">
        <button className="btn btn-secondary">Admin Login</button>
      </Link>
    </div>
  );
};

export default HomePage;
