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
            document.querySelector("form").reset();
            window.location.href = "/listService.html";
        })
        .catch(error => {
            console.error(error);
            alert("Erro ao enviar solicitação");
        });
}

function listarCards() {
    fetch("/api/cards")
        .then(response => {
            if (!response.ok) {
                throw new Error("Erro ao buscar cards");
            }
            return response.json();
        })
        .then(cards => {
            renderizarCards(cards);
        })
        .catch(error => {
            console.error(error);
        });
}

function formatarData(dataISO) {
    const data = new Date(dataISO);
    return data.toLocaleDateString("pt-BR");
}

function renderizarCards(cards) {
    const container = document.getElementById("lista-cards");
    container.innerHTML = "";

    cards.forEach(card => {
        const html = `
            <div class="card">
                <div class="card-header">
                    <h3>${card.title}</h3>
                    <button class="btn">Entrar em contato</button>
                </div>

                <p>${card.description}</p>

                <div class="card-footer">
                    <span>${card.nameClient} - ${card.contact}</span>
                    <span>${formatarData(card.createdTime)}</span>
                </div>
            </div>
        `;

        container.innerHTML += html;
    });
}

window.onload = function () {
    listarCards();
};