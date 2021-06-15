window.onload = async function() {
    let id = sessionStorage.getItem("escalaoId");
    await showutilizador(id);
}


async function showutilizador(id) {
    try {
        let utilizadores = await $.ajax({ 
            url: `/api/youchoose1/escalao/${id}`,
            method: "get",
            dataType: "json"
        });
        
        console.log(JSON.stringify(utilizadores))
        document.getElementById("id").innerHTML = utilizador.id;
        document.getElementById("utilizador_nome").innerHTML = utilizador.name;
        document.getElementById("apelido").innerHTML = utilizador.surname;
        document.getElementById("data_nascimento").innerHTML = utilizador.data_nascimento;
        document.getElementById("genero").innerHTML = utilizador.genero;
        for (let utilizador of utilizadores) {
            html += `<section>
                    <h3>${utilizador.name}</h>
                    <p>${utilizador.surname}</p>
                    <p>${utilizador.data_nascimento}</p>
                    <p>${utilizador.genero}</p>
                    </section>`
        }
        
    } catch(err) {
        console.log(err);
    }
}
