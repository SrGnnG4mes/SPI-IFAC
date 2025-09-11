<?php

$numero1 = $_GET['maiornum1'];
$numero2 = $_GET['maiornum2'];
$numero3 = $_GET['maiornum3'];
$numero4 = $_GET['maiornum4'];

echo "Maior Número: " .max($numero1,$numero2,$numero3,$numero4);
?>