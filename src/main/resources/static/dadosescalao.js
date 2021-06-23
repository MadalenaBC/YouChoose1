window.onload = async function () {
    try {
        let utilizadores = await $.ajax({
            url: `/api/utilizador/escalao/`,
            method: "get",
            dataType: "json"
        });
        let html = "";
        for (let utilizador of utilizadores) {
            html += `<section>
                    <h3>${utilizador.name}</h>
                    <h3>${utilizador.surname}</h>
                    <h3>${utilizador.data_nascimento}</h>
                    <h3>${utilizador.genero}</h>
                    </section>`
        }
        document.getElementById("utilizadores").innerHTML = html;
    } catch (err) {
        console.log(err);
    }
}
function openUtilizadorInfo(id) {
    sessionStorage.setItem("utilizadorId", id);
    window.location = "listaescalao.html";
}