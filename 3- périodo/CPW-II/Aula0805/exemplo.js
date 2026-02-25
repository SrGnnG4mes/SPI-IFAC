function imprimir(){
    
    const nome = document.getElementById('nome').value;
    const tamanho = nome.length;
    document.getElementById('tamanho').innerHTML = tamanho;
    console.log(tamanho);
}

function foco(){
    console.log('Foco no input')
}

function blur(){
    console.log('Foco não está no input')
}

function change(){
    console.log('teste')
}