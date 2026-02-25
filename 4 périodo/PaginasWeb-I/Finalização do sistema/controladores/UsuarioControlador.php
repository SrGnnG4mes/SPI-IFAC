<?php
    require_once "../modelos/Usuario.php";
    require_once "../DAOs/UsuarioDAO.php";

    class UsuarioControlador{

        public function salvar($usuario){
            try { //vai tentar abrir conexão, abrir dados
                $conexao = new Conexao();
                $conn = $conexao->conectar(); 

                $usuarioDao = new UsuarioDAO();
                $usuarioDao->salvar($usuario,$conn);
            }catch(PDOException $erro){
                throw $erro;
            }
        }

        public function autenticar($usuario){
            try { //vai tentar abrir conexão, abrir dados
                $conexao = new Conexao();
                $conn = $conexao->conectar(); 

                $usuarioDao = new UsuarioDAO();
                return $usuarioDao->autenticar($usuario,$conn);
            }catch(PDOException $erro){
                throw $erro;
            }
        }
    }
