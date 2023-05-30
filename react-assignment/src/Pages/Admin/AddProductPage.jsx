import React, { useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";

const AddPage = () => {
  const [foodName, setFoodName] = useState("");
  const [foodQuantity, setFoodQuantity] = useState("");
  const [foodPrice, setFoodPrice] = useState("");

  const handleFoodName = (e) => {
    setFoodName(e.target.value);
  };

  const handleFoodQuantity = (e) => {
    setFoodQuantity(e.target.value);
  };

  const handleFoodPrice = (e) => {
    setFoodPrice(e.target.value);
  };

  const handleFoodAdd = () => {
    const data = {
      foodName: foodName,
      foodQuantity: foodQuantity,
      foodPrice: foodPrice,
    };

    axios
      .post("http://localhost:8080/inventory/add", data)
      .then((response) => {
        alert(foodName + " has been added to the inventory successfully");
      })
      .catch((error) => {
        console.error(error);
      });
  };

  return (
    <div className="container">
      <h1>Add Product To The Inventory</h1>
      <div className="form-group">
        <label htmlFor="foodName">Food Name</label>
        <input
          type="text"
          id="foodName"
          className="form-control"
          value={foodName}
          onChange={handleFoodName}
        />
      </div>

      <div className="form-group">
        <label htmlFor="foodQuantity">Quantity</label>
        <input
          type="text"
          id="foodQuantity"
          className="form-control"
          value={foodQuantity}
          onChange={handleFoodQuantity}
        />
      </div>

      <div className="form-group">
        <label htmlFor="foodPrice">Price</label>
        <input
          type="text"
          id="foodPrice"
          className="form-control"
          value={foodPrice}
          onChange={handleFoodPrice}
        />
      </div>

      <button className="btn btn-primary" onClick={handleFoodAdd}>
        Add
      </button>

      <div>
        <p>Press Button to go back to Admin Menu</p>
        <Link to="/admin-dashboard">
          <button className="btn btn-secondary">Admin Login</button>
        </Link>
      </div>
    </div>
  );
};

export default AddPage;
