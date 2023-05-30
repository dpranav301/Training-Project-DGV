import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.css";
function InventoryPage() {
  const [data, setData] = useState([]);
  const [orderItems, setOrderItems] = useState([]);
  const [quantity, setQuantity] = useState(0);
  const [loggedInUser, setLoggedInUser] = useState(null);

  useEffect(() => {
    fetchData();
    const customerData = sessionStorage.getItem("customer");
    if (customerData) {
      setLoggedInUser(JSON.parse(customerData));
    }
  }, []);

  const fetchData = async () => {
    try {
      const response = await fetch(
        "http://localhost:8080/inventory/getAllFood"
      );
      const jsonData = await response.json();
      console.log(jsonData);
      setData(jsonData);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  const handleQuantityChange = (event, itemId) => {
    setQuantity(event.target.value);
  };

  const handleAddToOrder = (item) => {
    const orderItem = {
      itemId: item.itemId,
      quantity: "",
    };
    const updatedItems = [...orderItems, orderItem];
    setOrderItems(updatedItems);
  };

  const handlePlaceOrder = async (item) => {
    const confirmOrder = window.confirm(
      `Are you sure you want to place an order for ${item.foodName} with quantity ${quantity}?`
    );

    if (confirmOrder) {
      try {
        const orderData = {
          inventorysId: item.inventoryId,
          foodQty: quantity,
        };

        var obj = JSON.parse(sessionStorage.getItem("user"));
        console.log(obj.userId);
        const response = await fetch(
          `http://localhost:8080/order/place/` + obj.userId,
          {
            method: "POST",
            headers: {
              "Content-Type": "application/json",
            },
            body: JSON.stringify(orderData),
          }
        );

        if (response.ok) {
          console.log("Order placed successfully!");
          alert(
            `Order for ${item.foodName} with quantity ${quantity} placed successfully!`
          );
          setOrderItems([]);
          // ...
        } else {
          console.error("Failed to place order.");
        }
      } catch (error) {
        console.error("Error placing order:", error);
      }
    }
  };

  const Home = () => {
    return (
      <div>
        <p>Press Button to go back to Customer Page</p>
        <Link to="/customer-dashboard">
          <button className="btn btn-primary">Back</button>
        </Link>
      </div>
    );
  };

  return (
    <div className="container">
      <h1>Menu is as Follows</h1>
      <table className="table">
        <thead>
          <tr>
            <th>Food Name</th>
            <th>Food Price</th>
            <th>Quantity</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {data.map((item) => (
            <tr key={item.itemId}>
              <td>{item.foodName}</td>
              <td>{item.foodPrice}</td>
              <td>
                <input
                  type="number"
                  min="1"
                  value={quantity}
                  onChange={(event) => handleQuantityChange(event, item.itemId)}
                  className="form-control"
                />
              </td>
              <td>
                <button
                  className="btn btn-primary"
                  onClick={() => handlePlaceOrder(item)}
                >
                  Place Order
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <Home />
    </div>
  );
}

export default InventoryPage;
