window.onload = async function() {
    let forum = sessionStorage.getItem("for_Id");
    await showtutorial(forum);
}

async function showtutorial(id) {
    try {
        let tutoriais = await $.ajax({ 
            url: `/api/forum/tutoriais/${id}`,
            method: "get",
            dataType: "json"
        });
        let html = "";
        for (let tutorial of tutoriais) {
            html += `<section onclick= openTutorialInfo(${tutorial.id})>
                    <h3>${tutorial.date}</h>
                    <p>${tutorial.name}</p>
                    </section>`
        }
        

        document.getElementById("tutoriais").innerHTML = html;
         
        
    } catch(err) {
        console.log(err);
    }
    function openTutorialInfo(id) {
        sessionStorage.setItem("tutorialId", id);
        window.location = "tutoriais.html";
    }
}