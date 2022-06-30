import React, { useEffect, useState } from "react";
import "../css/allphones.css";
import phoneImg from "./images/icon-1968244_960_720.webp";
import Cookies from "universal-cookie";
import { delPhone } from "../fetch/deletePhone";
import { modiPhone } from "../fetch/modifyPhone";
import Swal from "sweetalert2";

/**
 * 
 * @returns La funcion AllPhones encargada de enviar el HTML para 
 * visualizar todos lo telefonos
 * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
 */

function Allphones() {
  const [listPhones, setListPhones] = useState([]);
  /**
   * Se hace la peticion para obtener la informacion de todos lo telefonos
   * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
   */
  const phones = async () => {
    var response = await fetch("http://localhost:9090/phones", {
      method: "GET",
      mode: "cors",
      credentials: "same-origin",
      headers: { "Content-Type": "application/json" },
    });
    if (response.ok) {
      var resJson = await response.json();
      setListPhones(resJson);
    }
    console.log(resJson);
  };
  useEffect(() => {
    phones();
  }, []);

  /**
   * Se crea una cookie con la informacion de id del telefono
   * para redireccionar a la vista del telefono
   * 
   * @param {*} idUser Se recibe el id del contacto
   * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
   */
  const look=(idUser)=>{
    const cookies = new Cookies();
    cookies.set('id-phone', idUser, { maxAge: 10 * 60 }, { path: '/' })
    window.location.href='./viewphones';
  }

  /**
   * Peticion para borrar un telefono
   * 
   * @param {*} id Recibe el id del telefono
   * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
   */
  const delP = (id) =>{
    Swal.fire({
      title: "¿Quiere borrar el Telefono?",
      icon: "success",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Si, enviar!",
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire("Enviado!", "Los datos han sido enviado.", "success");
        delPhone(id);
      }
    });
  }

  /**
   * Se modifica los datos del telefono
   * Y redirecciona a la pagina para hacerlo 
   * 
   * @param {*} idUser Se recibe el id del telefono
   * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
   */

  const modiP = (idUser) =>{
    const cookies = new Cookies();
    cookies.set('id-phone', idUser, { maxAge: 10 * 60 }, { path: '/' })
    window.location.href='./updatephone';
  }
  /**
   * Se retorna todo el HTML a procesar en el navegador
   * @author Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
   */
  return (
    <div id="containerP">
      {listPhones.map((val, id) => {
        return (
          <div id="box">
            <div id="img">
              <img src={phoneImg}></img>
            </div>
            <div id="container">
              <div id="info">
                <h2>
                  Usuario<br></br>
                  <span>{val.owner}</span>
                </h2>
                <div id="data">
                    <h3>Operador<br></br><span>{val.operator}</span></h3>
                    <h3>Numero<br></br><span>{val.number}</span></h3>
                </div>
                <div id="buttons">
                    <button onClick={()=>look(val.phoneId)}>Ver<br></br>Usuario</button>
                    <button onClick={()=>modiP(val.phoneId)}>Modificar<br></br>Usuario</button>
                    <button onClick={()=>delP(val.phoneId)}>Borrar<br></br>Usuario</button>
                </div>
              </div>
            </div>
          </div>
        );
      })}
    </div>
  );
}

export default Allphones;
