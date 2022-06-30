import Swal from "sweetalert2";

/**
 * Envia el json al backend para actualizar el telefono
 * 
 * @param {*} varJson Recibe el json a enviar en el fetch
 * @param {*} id Recibe el id a enviar en el fetch
 * @author {*}  Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
 */

export const modiPhone = async (varJson,phoneId) =>{
    var response = await fetch("http://localhost:9090/phone/" + phoneId, {
    method: "PUT",
    mode: "cors",
    credentials: "same-origin",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(varJson),
  }).then((response) => {
    if (response.ok) {
      Swal.fire({
        icon: "success",
        title: "Modificado",
      }).then((result) => {
        if (result.isConfirmed) {
          window.location.href = "./allphones";
        }
      });
    }
  });
}