window.onload = async function () {
    try {
        let eventos = await $.ajax({
            url: "/api/evento",
            method: "get",
            dataType: "json"
        });
        let html = "";
        for (let evento of eventos) {
            html += `<section onclick='openTipoEventoinfo(${evento.id})'>
                    <h3>${evento.date}</h>
                    <p>${evento.name}</p>
                    </section>`
        }
        document.getElementById("eventos").innerHTML = html;
    } catch (err) {
        console.log(err);
    }}

    function openTipoEventoinfo(id) {
        sessionStorage.setItem("eventoId", id);
        window.location = "TipoEvento.html";
    }