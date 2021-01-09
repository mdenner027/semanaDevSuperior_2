import React from 'react';
import './styles.css';
import { ReactComponent as Instagram } from './instagram-logo.svg';
import { ReactComponent as Linkedin } from './linkedin-logo.svg';
import { ReactComponent as Youtube } from './youtube-logo.svg';
function Footer() {
    return (
        <footer className="main-footer">
            <p>
                App desenvolvido durante a 2ª ed. do evento Semana DevSuperior
            </p>
            <div className="footer-icons">
                <a href=""> <Youtube /> </a>
                <a href=""> <Linkedin /> </a>
                <a href=""> <Instagram /> </a>
            </div>
        </footer>
    );
}

export default Footer;