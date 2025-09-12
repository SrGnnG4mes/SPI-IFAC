<?php

$numeros = [];

for ($i=0; $i < 50; $i++) {
    $numeroAleatorio = rand(0,100);
    array_push($numeros,$numeroAleatorio);
}

$soma = array_sum($numeros);
$media = $soma / count($numeros);

echo "Números gerados: " .implode(", ", $numeros) . "\n <br><br>";
echo "Média dos elementos: " .$media . "\n";

?>