<?php
    require_once "../modelos/Contato.php";
    require_once "../modelos/Endereco.php";
    //único papel desse arquivo é mostrar o resultado na tela

    session_start();
    $result = $_SESSION['resultado']; //usando memoria do servidor, 
    // então usou já vem e retira para não sobrecarregar

        echo "<table border='1'>";
        foreach($result as $contato) {
            echo "<tr>";
            echo " <td> ID: {$contato->id} </td> 
            <td> Nome: {$contato->nome} </td> 
            <td> Telefone: {$contato->telefone} </td>
            <td> Rua: {$contato->endereco->rua} </td>
            <td> Número: {$contato->endereco->numero} </td>
            <td> Bairro: {$contato->endereco->bairro} </td>
            <td><a href='../controladores/principal.php?acao=excluir&id={$contato->id}'>Excluir</a></td>
            <td><a href='../controladores/principal.php?acao=editar&id={$contato->id}'>Editar</a></td>"; //sabe exatamento o contato que quer editar
            echo "<tr>";
        } 
        echo "</table>";
?>