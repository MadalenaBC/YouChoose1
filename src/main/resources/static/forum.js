window.onload = async function () {
    try {
        let foruns = await $.ajax({
            url: "/api/forum",
            method: "get",
            dataType: "json"
        });
        let html = "";
        for (let forum of foruns) {
            html += `<section onclick='openUtilizadorinfo(${forum.id})'>
                    <h3>${forum.name}</h>
                    </section>`
        }
        document.getElementById("forum3").innerHTML = html;
    } catch (err) {
        console.log(err);
    }}

    function openUtilizadorinfo(id) {
        sessionStorage.setItem("forum_Id", id);
        window.location = "tutoriais.html";
    }
