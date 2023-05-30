import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";

const TotalBillPage = () => {
  const [totalBill, setTotalBill] = useState("");
  const object = sessionStorage.getItem("user");
  const userId = JSON.parse(object).userId;
  const [message, setMessage] = useState("");

  useEffect(() => {
    const fetchTotalBill = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8080/bill/totalBill/${userId}`
        );
        console.log(response);
        setMessage(response.data);
        var bill = response.data;
        setTotalBill(bill); // Convert to fixed decimal places
      } catch (error) {
        console.log(error);
      }
    };

    fetchTotalBill();
  }, [userId]);

  return (
    <div className="container">
      <h1>Total Bill</h1>
      <h2>{message}</h2>
      <p>Press Button to go back to Customer Page</p>
      <Link to="/customer-dashboard">
        <button className="btn btn-primary">Back</button>
      </Link>
    </div>
  );
};

export default TotalBillPage;
