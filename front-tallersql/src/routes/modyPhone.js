import React, { useEffect, useState } from "react";
import "../css/createContact.css";
import Cookies from "universal-cookie";
import { phone } from "../fetch/getContacts";
import Swal from "sweetalert2";
import { modiPhone } from "../fetch/modifyPhone";
/**
 * Retorna la funcion encargada de modificar datos del telefono
 * @returns retorna la funcion ModifyPhone
 * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
 */
function ModifyPhone() {
  const [operator, setOperator] = useState("");
  const [number, setNumber] = useState("");
  const [owner, setOwner] = useState("");
  const cookies = new Cookies();
  const id = cookies.get("id-phone");
  /**
   * Consigue los datos del telefono a traves del id
   * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
   */
  const getInfo = async () => {
    var res = await phone(id);
    setOperator(res.operator);
    setNumber(res.number);
    setOwner(res.owner);
  };
  /**
   * llama la funcion una sola vez
   * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
   */
  useEffect(() => {
    getInfo();
  }, []);
  /**
   * Valida la informacion dada por el usuario
   * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
   */
  const validateInfo = () => {
    if (operator === "" || operator === null) {
      Swal.fire({
        title: "Error",
        icon: "error",
        text: "Debe ingresar un operador valido",
      });
    } else if (
      number === "" ||
      number === null ||
      number.length < 10 ||
      number.length > 10
    ) {
      Swal.fire({
        title: "Error",
        icon: "error",
        text: "Debe ingresar un numero valido",
      });
    } else if (owner === "" || owner === null) {
      Swal.fire({
        title: "Error",
        icon: "error",
        text: "Debe ingresar un Nombre de dueño valido",
      });
    } else {
      const data = {
        operator: operator,
        owner: owner,
        number: number,
      };
      modiPhone(data, id);
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
            value={operator}
            onChange={(e) => setOperator(e.target.value)}
            required="required"
          ></input>
          <span>Operador Telefono</span>
        </div>
        <div id="input">
          <input
            value={owner}
            onChange={(e) => setOwner(e.target.value)}
            required="required"
          ></input>
          <span>Nombre Dueño</span>
        </div>
        <div id="input">
          <input
            value={number}
            onChange={(e) => setNumber(e.target.value)}
            type="number"
            required="required"
          ></input>
          <span>Numero Contacto</span>
        </div>
        <button id="Send" onClick={validateInfo}>
          Enviar
        </button>
      </div>
    </div>
  );
}
export default ModifyPhone;
