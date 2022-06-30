
/**
 * Envia el id al backend del telefono para encontrar los contactos
 * 
 * @param {*} varJson Recibe el id a enviar en el fetch
 * @author {*}  Jerson Daniel Basto Gil <jdbastog@correo.udistrital.edu.co>
 */


export const phone = async (id) => {
  var response = await fetch("http://localhost:9090/phoneid/" + id, {
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
