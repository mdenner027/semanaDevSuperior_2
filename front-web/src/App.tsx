import React from 'react';
import Navbar from "./Components/Navbar";
import './App.css';
import Footer from './Components/Footer';
import Home from './Pages/Main';

function App() {
  return (
    <>
      <Navbar />
      <Home />
      <Footer />
    </>
  );
}

export default App;
