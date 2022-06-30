import Swal from "sweetalert2";
/**
 * Envia el json al backend para crear el contacto
 * 
 * @param {*} varJson Recibe el json a enviar en el fetch
 * @author {*}  Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
 */
export const sendData = async (varJson) => {
    await fetch("http://localhost:9090/user", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(varJson),
    }).then((response) => {
      if (response.ok) {
        Swal.fire({
          icon: "success",
          text: "Contacto creado",
        }).then((result) => {
          if (result.isConfirmed) {
            window.location.href = "./viewphones";
          }
        });
      }
    });
  };