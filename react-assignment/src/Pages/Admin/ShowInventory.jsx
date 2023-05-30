import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";

function InventoryPage() {
  const [data, setData] = useState([]);

  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    try {
      const response = await fetch(
        "http://localhost:8080/inventory/getAllFood"
      );
      const jsonData = await response.json();
      setData(jsonData);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  const AdminMenu = () => {
    return (
      <div>
        <p>Press Button to go back to Admin Menu</p>
        <Link to="/admin-dashboard">
          <button className="btn btn-primary">Admin Login</button>
        </Link>
      </div>
    );
  };

  return (
    <div className="container">
      <h1>Inventory is as Follows</h1>
      <table className="table table-bordered">
        <thead>
          <tr>
            <th>Food Name</th>
            <th>Food Price</th>
            <th>Food Quantity</th>
          </tr>
        </thead>
        <tbody>
          {data.map((item) => (
            <tr key={item.inventoryId}>
              <td>{item.foodName}</td>
              <td>{item.foodPrice}</td>
              <td>{item.foodQuantity}</td>
            </tr>
          ))}
        </tbody>
      </table>
      <p>Press Button to go back to Admin Menu</p>
      <Link to="/admin-dashboard">
        <button className="btn btn-primary">Admin Login</button>
      </Link>
    </div>
  );
}

export default InventoryPage;
