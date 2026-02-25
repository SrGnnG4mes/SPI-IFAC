function adicionar() {

    let nome = document.getElementById("nome").value;
    let telefone = document.getElementById("telefone").value;
    let idade = document.getElementById("idade").value;

    const contato = {

        nome: nome,
        telefone: telefone,
        idade: idade

    }

    if (localStorage.length == 0) {
        const agenda = [];
        agenda.push(contato);
        localStorage.setItem("agenda", JSON.stringify(agenda));
    } else {
        const agenda = JSON.parse(localStorage.getItem("agenda"));
        agenda.push(contato);
        localStorage.setItem("agenda", JSON.stringify(agenda))

    }
    
    document.getElementById("nome").value = "";
    document.getElementById("telefone").value = "";
    document.getElementById("idade").value = "";
}

