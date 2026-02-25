<?php
    require_once "../modelos/Endereco.php";
    require_once "../conexao/Conexao.php";
    require_once "../DAOs/EnderecoDAO.php";


    class EnderecoControlador{

        function salvar($endereco){

            try{

                $conexao = new Conexao();
                $conn = $conexao->conectar();

                $enderecoDAO = new EnderecoDAO();
                $enderecoDAO->salvar($endereco,$conn);
            }catch(PDOException $erro){
                throw $erro;
            }

        }

    }

?>