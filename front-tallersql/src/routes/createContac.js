import React, { useState } from "react";
import Swal from "sweetalert2";
import validator from "validator";
import "../css/createContact.css";
import Cookies from "universal-cookie";
import { sendData } from "../fetch/createContact";

/**
 * 
 * @returns Se retorna la funcion Creacion de contacto
 * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
 */
function Createcontact() {
  const [Name, setName] = useState("");
  const [Email, setEmail] = useState("");
  const [NumberF, setNumber] = useState("");
  const [Date, setDate] = useState("");
  const cookies = new Cookies();
  const id = cookies.get("id-phone");
  /**
   * Verifica la informacion enviada en el formulario
   * 
   * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
   */
  const sendInfo = () => {
    if (Name === "" || Name === null) {
      Swal.fire({
        icon: "error",
        title: "Oops...",
        text: "El nombre del usuario no puede ir vacio",
      });
    } else if (Email === "" || Email === null || !validator.isEmail(Email)) {
      Swal.fire({
        icon: "error",
        title: "Oops...",
        text: "Por favor digite un email valido",
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
    } else if (Date === "" || Date === null) {
      Swal.fire({
        icon: "error",
        title: "Oops...",
        text: "Por favor digite una fecha valida YYYY-MM-DD",
      });
    } else {
      Swal.fire({
        title: "¿Esta seguro?",
        text: "¿ Quiere enviar los datos?",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "Si, enviar!",
      }).then((result) => {
        if (result.isConfirmed) {
          Swal.fire("Enviado!", "Los datos han sido enviado.", "success");
          const data = {
            name: Name,
            email: Email,
            number: NumberF,
            date: Date,
            phone: { phoneId: id },
          };
          sendData(data);
        }
      });
    }
  };
  /**
   * Retorna el codigo HTML
   * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
   */
  return (
    <div id="containerG">
      <div id="form-create">
        <div id="input">
          <input
            onChange={(e) => setName(e.target.value)}
            required="required"
          ></input>
          <span>Nombre Contacto</span>
        </div>
        <div id="input">
          <input
            onChange={(e) => setEmail(e.target.value)}
            required="required"
          ></input>
          <span>Email Contacto</span>
        </div>
        <div id="input">
          <input
            onChange={(e) => setNumber(e.target.value)}
            type="number"
            required="required"
          ></input>
          <span>Numero Contacto</span>
        </div>
        <div id="input">
          <input
            onChange={(e) => setDate(e.target.value)}
            required="required"
            type="date"
            min="1900-01-01"
            max="2023-01-01"
          ></input>
          <span>Fecha Cumpleaños Contacto</span>
        </div>
        <button id="Send" onClick={sendInfo}>
          Enviar
        </button>
      </div>
    </div>
  );
}
export default Createcontact;
