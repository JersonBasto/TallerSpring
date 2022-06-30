import Swal from "sweetalert2";

export const delPhone = async (phoneId) => {
  var response = await fetch("http://localhost:9090/phone/" + phoneId, {
    method: "DELETE",
    mode: "cors",
    credentials: "same-origin",
    headers: { "Content-Type": "application/json" },
  }).then((response) => {
    if (response.ok) {
      delAllcontacts(phoneId);
      Swal.fire({
        icon: "success",
        title: "Eliminado",
      }).then((result) => {
        if (result.isConfirmed) {
          window.location.href = "./allphones";
        }
      });
    }
  });
};

export const delAllcontacts = async (id) => {
  var response2 = await fetch("http://localhost:9090/contacts/" + id, {
    method: "DELETE",
    mode: "cors",
    credentials: "same-origin",
    headers: { "Content-Type": "application/json" },
  });
};
