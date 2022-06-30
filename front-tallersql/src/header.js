import React from "react";
import { Button, Navbar, Container } from "react-bootstrap";
import Cookies from "universal-cookie";
import { withRouter } from 'react-router-dom';
import "./header.css";
function Header() {
  const toAllPhones = () => {
    window.location.href=("/allphones");
  };
  const toCreatePhone = () => {
    window.location.href=("/createphone");
  };
  return (
    <Navbar className="Header" bg="light" expand="lg">
      <p id="tittle">Taller Sofka</p>
      <Container id="container-Header">
        <Button id="botonHeader" onClick={toAllPhones}>Todos los Telefonos</Button>
        <Button id="botonHeader" onClick={toCreatePhone}>Crear Telefono</Button>
      </Container>
    </Navbar>
  );
}
export default Header;
