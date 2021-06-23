window.onload = async function () {
    try {
        let evento = await $.ajax({
            url: "/api/evento",
            method: "get",
            dataType: "json"
        });
        let html = "";
        for (let evento of eventos) {
            html += `<section onclick='openTipoEventoinfo(${evento.id})'>
                    <h3>${evento.data}</h>
                    <p>${evento.nome}</p>
                    </section>`
        }
        document.getElementById("evento").innerHTML = html;
    } catch (err) {
        console.log(err);
    }}

    function openTipoEventoinfo(id) {
        sessionStorage.setItem("eventoId", id);
        window.location = "TipoEvento.html";
    }