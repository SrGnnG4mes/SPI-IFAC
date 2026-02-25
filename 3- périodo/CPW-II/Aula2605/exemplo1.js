function validar(){
    const cep = document.getElementById('cep').value;
    const regex_cep = /[0-9]{3}\.[0-9]{3}-[0-9]{2}/;
    const resultado = regex_cep.test(cep);

    if(resultado && cep.length)
}