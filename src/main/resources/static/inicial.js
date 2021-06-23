window.onload = async function () {
    try {
        let escaloes = await $.ajax({
            url: "/api/escalao",
            method: "get",
            dataType: "json"
        });
        let html = "";
        for (let escalao of escaloes) {
            html += `<section onclick='openUtilizadorinfo(${escalao.id})'>
                    <h3>${escalao.name}</h>
                    <p>${escalao.pontos}</p>
                    </section>`
        }
        document.getElementById("escaloes").innerHTML = html;
    } catch (err) {
        console.log(err);
    }}

    function openUtilizadorinfo(id) {
        sessionStorage.setItem("escalaoId", id);
        window.location = "escalao.html";
    }