import React from 'react';
import './styles.css';
import {ReactComponent as Logo} from './logo.svg';
function Navbar() {
    return (
        <nav className="main-navbar">
            <Logo className="main-navbar-logo"/>
            <a href="" className="logo-text">DS Delivery</a>
        </nav>
    );
}

export default Navbar;