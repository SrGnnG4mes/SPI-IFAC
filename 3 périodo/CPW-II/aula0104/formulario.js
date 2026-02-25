function mostrardados() {
    let nome = document.getElementById('nome').value

    let estado = document.getElementById('estado').value;
    let cor = document.getElementById('cor').value;

    document.getElementById('resposta').innerText = estado;
    document.getElementById('resposta').style.color = cor;

    
}


function mostrardadosRadio() {

    let email = document.getElementById('email').value;
    document.getElementById('respostaRadio').innerText = email;

    let radios = document.getElementsByName("email");
    for (let i = 0; i < radios.length; i++) {
        if (radios[i].checked) {
            console.log(radios[i].value)
        }
    }
}


function mostrardadosCheckbox(){
    let checkboxes = document.getElementsByName('sentido')
    for (let i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked) {
            console.log(checkboxes[i].value);
        }
    }

}