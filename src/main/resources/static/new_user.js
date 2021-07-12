window.onload = async function() {
    try {
        let CodigoPostais = await $.ajax({
            url: "/api/codigopostal",
            method: "get",
            dataType: "json"
        });
        let html="";
        for (let CodigoPostal of CodigoPostais) {
            html+= "<option value=" + CodigoPostal.id + ">" + CodigoPostal.concelho + " - " + CodigoPostal.freguesia +  "</option>";
            }
        document.getElementById("Listacp").innerHTML = html;
    } catch (err) {
        console.log(err);    
    }
    try {
        let escaloes = await $.ajax({
            url: "/api/youchoose4",
            method: "get",
            dataType: "json"
        });
        let html="";
        for (let escalao of escaloes) {
            html+= "<option value=" + Escalao.id + ">" + Escalao.name +  "</option>";
            }
        document.getElementById("escaloes").innerHTML = html;
    } catch (err) {
        console.log(err);    
    }
    
}
async function adduser() {
    try {
        let user = {
            name: document.getElementById("name").value,
            surname:document.getElementById("apelido").value,
            idade:document.getElementById("idade").value,
            genero:document.getElementById("genero").value,
            escalaoId:document.getElementById("escaloes").value,
            cp_Id:document.getElementById("Listacp").value,
            data_nascimento:document.getElementById("data_nascimento").value,
            TotalPontos:document.getElementById("TotalPontos").value
           
        }
        console.log(JSON.stringify(user));
        let result = await $.ajax({
            url: "/api/utilizadores",
            method: "post",
            dataType: "json",
            data:JSON.stringify(user),
            contentType: "application/json"
        });
        console.log(JSON.stringify(result));
        window.alert("Utilizador registado com sucesso!");
    } catch(err) {
        console.log(err);
        alert("Por favor, insira os dados corretamente!")
    }
}