import React, { useState } from "react";
import Swal from "sweetalert2";
import validator from "validator";
import "../css/createContact.css";
import Cookies from "universal-cookie";
/**
 * 
 * @returns Retorna la funcion Createphone
 */
function Createphone() {
  const [Operator, setOperator] = useState("");
  const [NumberF, setNumber] = useState(0);
  const [owner, setOwner] = useState("");
  const cookies = new Cookies();
  /**
   * Envia los datos para crear el telefono a partir de un fetch
   * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
   */
  const sendData = async () => {
    const data = {
        operator: Operator,
        number: NumberF,
        owner: owner,
      }
    await fetch("http://localhost:9090/phone", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(data),
    }).then((response) => {
      if(response.ok){
        window.location.href="./allphones"
      }
    });
  };
  /**
   * Verificar la informacion a enviar
   * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
   */
  const sendInfo = () => {
    if (Operator === "" || Operator === null) {
      Swal.fire({
        icon: "error",
        title: "Oops...",
        text: "El Operador del Telefono no puede ir vacio",
      });
    } else if (owner === "" || owner === null) {
      Swal.fire({
        icon: "error",
        title: "Oops...",
        text: "El Nombre del dueño del Telefono no puede ir vacio",
      });
    } else if (
      NumberF === "" ||
      NumberF === null ||
      NumberF.length < 10 ||
      NumberF.length > 10
    ) {
      Swal.fire({
        icon: "error",
        title: "Oops...",
        text: "Digite un numero valido, recuerde que el numero debe contener 10 digitos",
      });
    } else {
      sendData();
    }
  };
  /**
   * Retorna el HTML
   * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
   */
  return (
    <div id="containerG">
      <div id="form-create">
        <div id="input">
          <input
            type="text"
            onChange={(e) => setOperator(e.target.value)}
            required="required"
          ></input>
          <span>Operador de Telefono</span>
        </div>
        <div id="input">
          <input
            type="text"
            onChange={(e) => setOwner(e.target.value)}
            required="required"
          ></input>
          <span>Nombre Dueño</span>
        </div>
        <div id="input">
          <input
            onChange={(e) => setNumber(e.target.value)}
            type="number"
            required="required"
          ></input>
          <span>Numero Contacto</span>
        </div>
        <button id="Send" onClick={sendInfo}>
          Enviar
        </button>
      </div>
    </div>
  );
}
export default Createphone;
