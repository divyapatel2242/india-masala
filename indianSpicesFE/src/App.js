import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Login from './Login.js';
import Products from './Products.js';

const App = () => {
  return (
    <Router>
      <Routes>
        <Route exact path="/login" element={<Login/>} />
        <Route exact path="/products" element ={<Products/>} />
      </Routes>
    </Router>
  );
};

export default App;