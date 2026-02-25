<?php
//como ta acessando objeto contato ele precisa saber que é contato do nosso modelo
    require_once "../modelos/Contato.php";
    session_start();
    $contato = $_SESSION['contato'];
    //criar html e inserir dentro do php

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=<, initial-scale=1.0">
    <title>Document</title>
</head>
    <body>
        <form action="../controladores/principal.php?acao=alterar" method="POST">  
            ID:<input type="text" name="id" value=<?php echo $contato->id ?>>
            Nome:<input type="text" name="nome" value=<?php echo $contato->nome ?>> <!-- aparecer dentro do php-->
            Telefone:<input type="text" name="telefone" value=<?php echo $contato->telefone ?>>  <!--vai imprimir o nome dentro do value--> 
            <button>Alterar</button>
        </form>
    </body>
</html>