/**
 * Envia el id al backend para encontrar el contacto
 * 
 * @param {*} varJson Recibe el id a enviar en el fetch
 * @author {*}  Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
 */

export const getContact = async (id) => {
  var response = await fetch("http://localhost:9090/users/" + id, {
    method: "GET",
    mode: "cors",
    credentials: "same-origin",
    headers: { "Content-Type": "application/json" },
  });
  if (response.ok) {
    var resJson = await response.json();
    return resJson;
  }
};
