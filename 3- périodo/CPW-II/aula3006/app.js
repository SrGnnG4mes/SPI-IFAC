function adicionar() {

    let nome = document.getElementById("nome").value;
    let telefone = document.getElementById("nome").value;
    let idade = document.getElementById("nome").value;

    const contato = {

        nome: nome,
        telefone: telefone,
        idade: idade

    }

    if (localStorage.length == 0) {
        const agenda = [];
        agenda.push(contato);
        localStorage.setItem("agenda",JSON.stringify(agenda));
    }else{
        const agenda = JSON.parse(localStorage.getItem("agenda"));
        agenda.push(contato);
        localStorage.setItem("agenda",JSON.stringify(agenda))

    }
}

