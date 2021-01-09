import React from 'react';
import { ReactComponent as Ilustration } from './ilustration.svg';
import './styles.css';

function Home() {
    return (
        <div className="home-container">
            <div className="home-content">
                <div className="home-actions">
                    <h1 className="home-title">Faça seu pedido <br />que entregamos <br />pra você!!!</h1>
                    <h3 className="home-subtitle">Escolha o seu pedido e em poucos minutos<br /> levaremoss na sua porta</h3>
                    <a href="" className="home-btn-order">
                        FAZER PEDIDO
                    </a>
                </div>
                <Ilustration className="home-image" />
            </div>
        </div>
    );
}

export default Home;