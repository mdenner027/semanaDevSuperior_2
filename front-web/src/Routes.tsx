import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import Footer from './Components/Footer';
import Navbar from './Components/Navbar';
import Home from './Pages/Main';
import Orders from './Pages/Orders';

function Routes() {
    return (
        <BrowserRouter >
            <Navbar />
            <Switch>
                <Route path="/orders">
                    <Orders />
                </Route>
                <Route path="/" >
                    <Home />
                </Route>
            </Switch>
            <Footer />
        </BrowserRouter>
    );
}

export default Routes;