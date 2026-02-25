function parOuImpar() {
    let parImparResposta = document.getElementById("par-impar-resposta");
    let inputparOuImpar = document.getElementById("impar-par-input").value;
    inputparOuImpar = parseInt(inputparOuImpar); 
    inputparOuImpar % 2 === 0 ? parImparResposta.innerText = "Par" : parImparResposta.innerText = "Ímpar";
}