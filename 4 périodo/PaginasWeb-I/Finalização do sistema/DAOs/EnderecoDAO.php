<?php
    class EnderecoDAO{

        function salvar($endereco,$conn){

            $sql = "INSERT into 
                Enderecos(rua,numero,bairro,id_contatos) VALUES (?,?,?,?)";

            try{
                $stmt = $conn->prepare($sql);
                $stmt->bindParam(1, $endereco->rua);
                $stmt->bindParam(2, $endereco->numero);
                $stmt->bindParam(3, $endereco->bairro);
                $stmt->bindParam(4, $endereco->id_contatos);
                $stmt->execute();
            }catch(PDOException $erro){
                throw $erro;
            }

        }

    }

?>