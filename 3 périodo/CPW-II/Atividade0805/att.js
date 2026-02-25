function gerarNumeros() {
    const numeros = [];
    const contagem = {};

    // Gerar 100 números aleatórios entre 1 e 100
    for (let i = 0; i < 100; i++) {
        const num = Math.floor(Math.random() * 100) + 1;
        numeros.push(num);
        contagem[num] = (contagem[num] || 0) + 1;
    }

    // Montar resultado
    let resultadoTexto = "";
    for (const num in contagem) {
        const vezes = contagem[num];
        resultadoTexto += `${num} - ${vezes} vez${vezes > 1 ? 'es' : ''}\n`;
    }

    // Mostrar na tela
    document.getElementById("resultado").textContent = resultadoTexto;
}

function executar() {
    const listaOriginal = [];
    const jaVisto = new Set();
    const listaFinal = [];

    // Gerar 100 números aleatórios entre 1 e 100
    for (let i = 0; i < 100; i++) {
        const aleatorio = Math.floor(Math.random() * 100) + 1;
        listaOriginal.push(aleatorio);
        if (!jaVisto.has(aleatorio)) {
            jaVisto.add(aleatorio);
            listaFinal.push(aleatorio);
        }
    }

    // Exibir o resultado
    document.getElementById("resposta").textContent =
        `Números gerados:\n${listaOriginal.join(' ')}\n\nSem repetições:\n${listaFinal.join(' ')}`;
}

const votos = {};

function votar() {
    const nomeInput = document.getElementById("nome");
    const nome = nomeInput.value.trim();

    if (nome === "") {
        alert("Digite um nome válido.");
        return;
    }

    votos[nome] = (votos[nome] || 0) + 1;
    nomeInput.value = "";
    atualizarResultado();
}

function atualizarResultado() {
    let texto = "Resultado parcial:\n";
    for (const nome in votos) {
        texto += `${nome} - ${votos[nome]} voto${votos[nome] > 1 ? 's' : ''}\n`;
    }
    document.getElementById("votos").textContent = texto;
}