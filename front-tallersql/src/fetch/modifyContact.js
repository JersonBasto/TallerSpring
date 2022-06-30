import Swal from "sweetalert2";

export const modiContact = async (varJson,id) =>{
    var response = await fetch("http://localhost:9090/users/" + id, {
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
          window.location.href = "./viewphones";
        }
      });
    }
  });
}