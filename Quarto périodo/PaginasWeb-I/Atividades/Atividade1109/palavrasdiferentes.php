<?php

if (isset($_GET['frase']) && isset($_GET['palavras'])) {
    $frase = $_GET['frase'];
    $palavra = $_GET['palavras'];
    // Verifica se a palavra existe na frase (case-sensitive)
    if (strpos($frase, $palavra) !== false) {
        echo "A palavra <strong>'" . htmlspecialchars($palavra) . "'</strong> existe na frase.";
    } else {
        echo "A palavra <strong>'" . htmlspecialchars($palavra) . "'</strong> não existe na frase.";
    }
} else {
    echo "Por favor, preencha a frase e a palavra.";
}


?>