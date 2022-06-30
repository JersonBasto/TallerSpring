import React, { useEffect, useState } from "react";
import "../css/viewphone.css";
import Cookies from "universal-cookie";
import { deleteContact } from "../fetch/deleteContact";
import { MdOutlineAddBox } from "react-icons/md";
import { phone } from "../fetch/getContacts";
import Swal from "sweetalert2";

function Viewuser() {
  const cookies = new Cookies();
  const id = cookies.get("id-phone");
  const [phoneO, setPhone] = useState([]);
  const [contacts, setContacts] = useState([]);

  const getInfo = async () => {
    var res = await phone(id);
    setPhone(res);
    setContacts(res.contacts);
  };

  useEffect(() => {
    getInfo();
  }, []);

  const createContact = () => {
    window.location.href = "./createContact";
  };

  const delContact = async (id) => {
    Swal.fire({
      title: "¿Quiere borrar el Contacto?",
      icon: "success",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Si, enviar!",
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire("Enviado!", "Los datos han sido enviado.", "success");
        deleteContact(id);
      }
    });
  };

  const modContact = (idUser) => {
    const cookies = new Cookies();
    cookies.set("id-contact", idUser, { maxAge: 10 * 60 }, { path: "/" });
    window.location.href = "./updatecontact";
  };

  return (
    <div id="containerPri">
      <h3 id="name">
        Usuario <span>{phoneO.owner}</span>
      </h3>
      <div id="data2">
        <h3 id="name">
          Operador
          <span>
            <br></br>
            {phoneO.operator}
          </span>{" "}
        </h3>
        <h3 id="name">
          Numero
          <span>
            <br></br>
            {phoneO.number}
          </span>{" "}
        </h3>
        <h3 id="hadd">
          <MdOutlineAddBox
            id="add"
            size="5rem"
            onClick={createContact}
          ></MdOutlineAddBox>
          <span>Agregar</span>
        </h3>
      </div>

      <div id="containerBox2">
        {contacts.map((val, key) => {
          return (
            <div id="box2">
              <div id="container">
                <div id="info2">
                  <h2>
                    Contacto<br></br>
                    <span>{val.name}</span>
                  </h2>
                  <div id="data2">
                    <h3>
                      Email<br></br>
                      <span>{val.email}</span>
                    </h3>
                    <h3>
                      Numero<br></br>
                      <span>{val.number}</span>
                    </h3>
                  </div>
                </div>
              </div>
              <div id="botones">
                <button onClick={() => modContact(val.id)}>Editar</button>
                <button onClick={() => delContact(val.id)}>Delete</button>
              </div>
            </div>
          );
        })}
      </div>
    </div>
  );
}
export default Viewuser;
