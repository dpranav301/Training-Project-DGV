// import React from "react";
// import { useState, useEffect } from "react";
// import { Link } from "react-router-dom";

// function InventoryPage() {
//   const [data, setData] = useState([]);

//   useEffect(() => {
//     fetchData();
//   }, []);

//   const fetchData = async () => {
//     try {
//       const response = await fetch("http://localhost:8080/inventory/getAllFood");
//       const jsonData = await response.json();
//       console.log(jsonData);
//       setData(jsonData);
//     } catch (error) {
//       console.error("Error fetching data:", error);
//     }
//   };

//   const deleteFoodItem = async (foodId) => {
//     try {
//       await fetch(`http://localhost:8080/inventory/delete/${foodId}`, {
//         method: "DELETE",
//       });
//       fetchData(); // Fetch updated inventory after deletion
//     } catch (error) {
//       console.error("Error deleting food item:", error);
//     }
//   };

//   const AdminMenu = () => {
//     return (
//       <div>
//         <p>Press Button to go back to Admin Menu</p>
//         <Link to="/admin-dashboard">
//           <button className="button">Admin Login</button>
//         </Link>
//       </div>
//     );
//   };

//   return (
//     <>
//       <div className="container">
//         <h1>Inventory is as Follows</h1>
//         <div>
//           <table border={1}>
//             <thead>
//               <tr>
//                 <th>Food Name</th>
//                 <th>Food Price</th>
//                 <th>Food Quantity</th>
//                 <th>Action</th>
//               </tr>
//             </thead>
//             <tbody>
//               {data.map((item) => (
//                 <tr key={item.foodId}>
//                   <td>{item.foodName}</td>
//                   <td>{item.foodPrice}</td>
//                   <td>{item.foodQuantity}</td>
//                   <td>
//                     <button
//                       className="button"
//                       onClick={() => deleteFoodItem(item.inventoryId)}
//                     >
//                       Delete
//                     </button>
//                   </td>
//                 </tr>
//               ))}
//             </tbody>
//           </table>
//         </div>
//         <AdminMenu />
//       </div>
//     </>
//   );
// }

// export default InventoryPage;


import React from "react";
import { useState, useEffect } from "react";
import { Link } from "react-router-dom";

function InventoryPage() {
  const [data, setData] = useState([]);

  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    try {
      const response = await fetch("http://localhost:8080/inventory/getAllFood");
      const jsonData = await response.json();
      setData(jsonData);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  const deleteFoodItem = async (inventoryId) => {
    try {
      await fetch(`http://localhost:8080/inventory/delete/${inventoryId}`, {
        method: "DELETE",
      });
      fetchData(); // Fetch updated inventory after deletion
    } catch (error) {
      console.error("Error deleting food item:", error);
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
      <table className="table">
        <thead>
          <tr>
            <th>Food Name</th>
            <th>Food Price</th>
            <th>Food Quantity</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {data.map((item) => (
            <tr key={item.inventoryId}>
              <td>{item.foodName}</td>
              <td>{item.foodPrice}</td>
              <td>{item.foodQuantity}</td>
              <td>
                <button
                  className="btn btn-danger"
                  onClick={() => deleteFoodItem(item.inventoryId)}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <AdminMenu />
    </div>
  );
}

export default InventoryPage;


