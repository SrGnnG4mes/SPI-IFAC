<?php

    $parouimpar = $_GET['parouimpar'];
 
    if ($parouimpar % 2 === 0) {
        echo "$parouimpar é par";
      } else {
        echo "$parouimpar é ímpar";
      }

?>