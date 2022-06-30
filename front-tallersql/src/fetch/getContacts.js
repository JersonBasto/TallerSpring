

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
