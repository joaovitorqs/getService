function irParaCriar() {
    window.location.href = "/createService.html";
}

function irParaLista() {
    window.location.href = "/listService.html";
}
function enviarSolicitacao() {
    const dados = {
        nameClient: document.getElementById("nome").value,
        contact: document.getElementById("contato").value,
        title: document.getElementById("titulo").value,
        description: document.getElementById("descricao").value
    };

    fetch("/api/cards", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(dados)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Erro ao enviar");
        }
        return response.json();
    })
    .then(data => {
        alert("Solicitação criada com sucesso!");
        document.querySelector("form").reset();
        console.log(data);
        window.location.href = "/index.html";
    })
    .catch(error => {
        console.error(error);
        alert("Erro ao enviar solicitação");
    });
}