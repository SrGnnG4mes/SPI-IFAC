
function mudarTextoElemento(id, novoTexto) {
    const elemento = document.getElementById(id);
    if (elemento) {
        elemento.innerText = novoTexto;
    } else {
        console.error(`Elemento com ID ${id} não encontrado.`);
    }
}


function alterarEstiloElemento(id, propriedade, valor) {
    const elemento = document.getElementById(id);
    if (elemento) {
        elemento.style[propriedade] = valor;
    } else {
        console.error(`Elemento com ID ${id} não encontrado.`);
    }
}


document.addEventListener('DOMContentLoaded', () => {

    mudarTextoElemento('about', 'Sobre Mim - Atualizado!');


    setTimeout(() => {
        alterarEstiloElemento('contact', 'color', 'red');
    }, 5000);

    setTimeout(() => {
        alterarEstiloElemento('contact', 'color', 'cyan');
    }, 10000);

    setTimeout(() => {
        alterarEstiloElemento('contact', 'color', 'black');
    }, 15000);
});