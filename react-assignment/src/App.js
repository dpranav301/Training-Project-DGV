import React from "react";

import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

//import LoginPage from './Component/LoginPage';
import Home from "./Component/Home";
import LoginPage from "./Component/LoginPage";
import Register from "./Component/Register";
import CustomerPage from "./Pages/Customer/CustomerPage";
import AdminPage from "./Pages/Admin/AdminPage";
import AddProductPage from "./Pages/Admin/AddProductPage";
import ShowInventory from "./Pages/Admin/ShowInventory";
import DeleteProductInventory from "./Pages/Admin/DeleteProductInventory";
import PlaceOrder from "./Pages/Customer/PlaceOrder";
import SeeBill from "./Pages/Customer/SeeBill";
import AllCustomer from "./Pages/Admin/AllCustomer";

const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/register" element={<Register />} />
        <Route path="/customer-dashboard" element={<CustomerPage />} />
        <Route path="/admin-dashboard" element={<AdminPage />} />
        <Route path="/addToInventory" element={<AddProductPage />} />
        <Route path="/showInventory" element={<ShowInventory />} />
        <Route
          path="/deleteProductInventory"
          element={<DeleteProductInventory />}
        />
        <Route path="/addFood" element={<PlaceOrder />} />
        <Route path="/seeBill" element={<SeeBill />}></Route>
        <Route path="/AllBill" element={<AllCustomer />}></Route>
      </Routes>
    </Router>
  );
};

export default App;
