<?php
    require_once "../modelos/Usuario.php";
    session_start();
    if(!isset($_SESSION['usuario'])){
        header("Location:../visoes/formLogin.html");
    }else{
        var_dump($_SESSION['usuario']);
    }
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AGENDA</title>
</head>
    <body>
        <h1 id="agenda">Agenda</h1>    
        <a href="visoes/formCadastrarContato.html">Cadastrar Contato</a><br>
        <a href="controladores/principal.php?acao=listar">Listar Contatos</a><br> <!--agora vai chamar o principal-->
        <a href="visoes/formBuscarContatos.html">Buscar Contatos</a><br>
        <a href="../controladores/principal.php?acao=logout">Sair</a>
    </body>
</html>