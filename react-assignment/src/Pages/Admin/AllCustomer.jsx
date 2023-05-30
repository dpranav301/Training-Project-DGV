
import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

const AdminPage = () => {
  const [customers, setCustomers] = useState([]);
  const [selectedCustomerBill, setSelectedCustomerBill] = useState({});

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

  useEffect(() => {
    const fetchCustomers = async () => {
      try {
        const response = await axios.get("http://localhost:8080/user/allUser");
        setCustomers(response.data);
      } catch (error) {
        console.error("Error fetching customers:", error);
      }
    };

    fetchCustomers();
  }, []);

  const viewBill = async (customerId) => {
    try {
      const uId = customerId;
      const response = await axios.get(
        `http://localhost:8080/bill/totalBill/` + uId
      );
      setSelectedCustomerBill({
        userId: customerId,
        bill: response.data,
      });
    } catch (error) {
      console.error("Error fetching customer bill:", error);
    }
  };

  return (
    <div className="container">
      <h1>Admin Page</h1>
      <table className="table">
        <thead>
          <tr>
            <th>Customer ID</th>
            <th>Name</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {customers.map((customer) => {
            if (customer.userRole === "customer") {
              return (
                <tr key={customer.id}>
                  <td>{customer.userId}</td>
                  <td>{customer.userName}</td>
                  <td>
                    <button
                      className="btn btn-primary"
                      onClick={() => viewBill(customer.userId)}
                    >
                      View Bill
                    </button>
                  </td>
                </tr>
              );
            }
            return null;
          })}
        </tbody>
      </table>

      {selectedCustomerBill && (
        <div>
          <h2>Customer Bill</h2>
          <p>Customer ID: {selectedCustomerBill.userId}</p>
          <p>Bill Amount: {selectedCustomerBill.bill}</p>
          {/* Display additional bill details as needed */}
        </div>
      )}
      
      <AdminMenu />
    </div>
  );
};

export default AdminPage;
