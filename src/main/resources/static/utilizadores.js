window.onload = async function() {
    let escalao = sessionStorage.getItem("esc_Id");
    await showutilizador(escalao);
}

async function showutilizador(id) {
    try {
        let utilizador = await $.ajax({ 
            url: `/api/utilizador/escalao/${id}`,
            method: "get",
            dataType: "json"
        });
        let html = "";
        for (let utilizador of utilizadores) {
            html += `<section onclick= openUtilizadorInfo(${utilizador.id})>
                    <h3>${utilizador.name}</h>
                    <p>${utilizador.surname}</p>
                    </section>`
        }
        

        /// document.getElementById("utilizador_nome").innerHTML = utilizador.name;
        // document.getElementById("apelido").innerHTML = utilizador.surname;
        // document.getElementById("data_nascimento").innerHTML = utilizador.data_nascimento;
        // document.getElementById("genero").innerHTML = utilizador.genero;
        
        
        
    } catch(err) {
        console.log(err);
    }
    function openUtilizadorInfo(id) {
        sessionStorage.setItem("utilizadorId", id);
        window.location = "utilizadores.html";
    }
}
