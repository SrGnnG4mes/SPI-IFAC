//Vetor não armazena valores, só referencia o local da mémoria
let numero1 = 5;
let nomes = ['Joao','Pedro','Ana'];

imprimir(nomes);
console.log(nomes);

function imprimir(algumacoisa){
    console.log(algumacoisa);
    algumacoisa[0] = 8;
}