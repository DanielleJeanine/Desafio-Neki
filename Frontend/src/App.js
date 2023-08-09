import React, { useContext } from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom'; // Importe BrowserRouter as Router
import './App.css';
import { AuthContext } from './context/AuthContext';

import Login from './components/Login';
import Cadastro from './components/Cadastro';
import Home from './components/Home';

function App() {
  return (
    <div className="App">
      <Router> {}
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/cadastrar" element={<Cadastro />} />
          <Route path='/home' element={<PrivateRoute />}/>
        </Routes>
      </Router>
    </div>
  );
}

const PrivateRoute = () => {
  const { isAuthenticated } = useContext(AuthContext);
  if (!isAuthenticated) {
    return <Navigate to="/" />;
  }
  return <Home />;
};

export default App;
