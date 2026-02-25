const agenda = JSON.parse(localStorage.getItem("agenda"));

for (const contato of agenda) {
    console.log(contato.nome);
    console.log(contato.telefone);
    console.log(contato.idade);
    
}