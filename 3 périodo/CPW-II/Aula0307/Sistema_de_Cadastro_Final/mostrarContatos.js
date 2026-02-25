if (localStorage.length == 0) {
    console.log("Agenta vázia!!");

} else {
    const agenda = JSON.parse(localStorage.getItem("agenda"));

    const tabela = document.getElementById('contatos');

    for (const contato of agenda) {
        const novaLinha = document.createElement("tr");
        const coluna1 = document.createElement("td");
        const coluna2 = document.createElement("td");
        const coluna3 = document.createElement("td");

        coluna1.textContent = contato.nome;
        coluna2.textContent = contato.idade;
        coluna3.textContent = contato.telefone;

        novaLinha.appendChild(coluna1);
        novaLinha.appendChild(coluna2);
        novaLinha.appendChild(coluna3);

        tabela.appendChild(novaLinha);
        /*console.log(contato.nome);
        console.log(contato.telefone);
        console.log(contato.idade);*/
    }
}