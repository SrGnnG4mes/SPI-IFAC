<?php
    class Conexao {
        private $conn;
        
        public function conectar() {
            
            // Fazer a conexão com o banco de dados MySQL usando PDO (PHP Data Objects)
            try {
                $this->conn = new PDO("mysql:host=localhost:3307; dbname=agenda","root", "");

                // Configuração do modo de erro do PDO para exceção 
                $this->conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

                // Retornar a conexão
                return $this->conn;
            } catch (PDOException $e) {
                echo "Erro na conexão: " . $e->getMessage();
            }
        }

        public function fechar(){
            $this->conn = null;
        }
    }
?>