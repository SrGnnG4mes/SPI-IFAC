<?php

    $altura = $_GET['altura'];
    $peso = $_GET['peso'];

    $IMC = $peso/($altura * $altura);
    echo $IMC;

?>