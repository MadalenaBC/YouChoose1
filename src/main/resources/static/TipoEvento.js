window.onload = async function() {
    let evento = sessionStorage.getItem("ev_Id");
    await showTipoEvento(evento);
}

async function showTipoEvento(id) {
    try {
        let TipoEvento = await $.ajax({ 
            url: `/api/tipoevento/evento/${id}`,
            method: "get",
            dataType: "json"
        });
        let html = "";
        for (let TipoEvento of TipoEventos) {
            html += `<section onclick= openTipoEventoInfo(${TipoEvento.id})>
                    <h3>${TipoEvento.name}</h>
                    <p>${TipoEvento.data}</p>
                    </section>`
        }
        
        
        
    } catch(err) {
        console.log(err);
    }
    function openTipoEventoInfo(id) {
        sessionStorage.setItem("TipoEventoId", id);
        window.location = "TipoEvento.html";
    }
}