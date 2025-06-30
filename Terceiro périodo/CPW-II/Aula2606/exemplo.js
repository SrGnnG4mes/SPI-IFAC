/*let x = 5;
mostrar(x)
function mostrar(valor) {
    console.log(valor);
    valor = 9;
}
console.log(valor);*/

const aluno = { nome: 'Carlos', idade: 5 }
mostrar(aluno);

function mostrar(pessoa) {
    console.log(pessoa);
    pessoa.idade = 9;
}

console.log(aluno.idade);

