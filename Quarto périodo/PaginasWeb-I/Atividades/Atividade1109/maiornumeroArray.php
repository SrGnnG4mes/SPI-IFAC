<?php

$numeros = [];

for ($i=0; $i < 50; $i++) {
    $numeroAleatorio = rand(0,100);
    array_push($numeros,$numeroAleatorio);
}
$maior = 0;
foreach($numeros as $elemento){
    if($elemento > $maior){
        $maior = $elemento;
    }
}
echo "O maior elemento é $maior";

?>