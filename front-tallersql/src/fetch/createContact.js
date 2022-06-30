import Swal from "sweetalert2";

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