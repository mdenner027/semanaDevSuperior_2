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
                <a href="https://www.youtube.com/channel/UC3twHmWQwtqEO7u-gB_2f7g" target="_new"><Youtube /></a>
                <a href="https://www.linkedin.com/school/devsuperior/" target="_new"> <Linkedin /> </a>
                <a href="https://www.instagram.com/devsuperior.ig/" target="_new"> <Instagram /> </a>
            </div>
        </footer>
    );
}

export default Footer;