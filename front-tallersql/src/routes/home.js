import React from "react";
import { Card, Button, Container } from "react-bootstrap";

function Home() {
  return (
    <Card className="text-center">
      <Card.Header>Bienvenido</Card.Header>
      <Card.Body>
        <Card.Title>Taller SQL 2</Card.Title>
        <Card.Text>
          En esta pagina puede observar los diferente telefono y usuarios en la aplicacion, asi como tambien puede crear cada uno de ellos.
        </Card.Text>
      </Card.Body>
    </Card>
  );
}

export default Home;
