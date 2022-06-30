import Swal from "sweetalert2";


export const deleteContact = async(id) =>{
    var response = await fetch("http://localhost:9090/users/" + id, {
      method: "DELETE",
      mode: "cors",
      credentials: "same-origin",
      headers: { "Content-Type": "application/json" },
    }).then(response=>{
        if(response.ok){
            Swal.fire({
                icon:"success",
                title:"Eliminado"
            }).then((result=>{
                if(result.isConfirmed){
                    window.location.href="./viewphones"
                }
            }))
        }
    })
    ;
}