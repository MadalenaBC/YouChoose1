window.onload = async function() {
    let tipoevento = sessionStorage.getItem("eventoId");
    await showTipoEvento(tipoevento);
}

async function showTipoEvento(id) {
    try {
        let tipoevento = await $.ajax({ 
            url: `/api/evento/tipoevento/${id}`,
            method: "get",
            dataType: "json"
        });
        document.getElementById("nome").innerHTML = tipoevento.name;
        document.getElementById("data").innerHTML = tipoevento.date;
       
        
    } catch(err) {
        console.log(err);
    }
}