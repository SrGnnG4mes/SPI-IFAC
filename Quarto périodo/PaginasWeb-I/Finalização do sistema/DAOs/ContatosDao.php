<?php
//manipulam e conversam com a tabela contatos
    require_once "../modelos/Contato.php";
    require_once "../modelos/Endereco.php";

    class ContatosDao{

        function salvar($contato,$conn){ //passando via dados via parametro
            $sql = "INSERT INTO contatos(nome, telefone) VALUES (?, ?)";
            
            try{  //pode dar erros
                $stmt = $conn->prepare($sql);

                
                $stmt->bindParam(1, $contato->nome);
                $stmt->bindParam(2, $contato->telefone);
            
                $stmt->execute();    //captura erro
                return $conn->lastInsertId();
                
            }catch(PDOException $erro){ //qualquer ponto que acontec eu erro vai capturar ele  
                throw $erro; //lança pra camada de cima o erro , exatamente o erro ou ele faz
            }
        }
//__________________________________________________________________________________________________________
        function buscar($nome,$conn){

            $sql = "SELECT 
                    c.id AS contato_id,
                    c.nome,
                    c.telefone,
                    e.id AS endereco_id,
                    e.rua,
                    e.numero,
                    e.bairro
                    FROM Contatos c left join 
                    Enderecos e on c.id = e.id_contatos where nome like ?";
            $stmt = $conn->prepare($sql);
            $stmt->bindValue(1, "%".$nome."%");
            $stmt->execute();
            $result = $stmt->fetchAll(PDO::FETCH_OBJ);
            
            $contatos =[];
            foreach($result as $contato) { 
                $contatoObj= new Contato();
                $contatoObj->id = $contato->contato_id;
                $contatoObj->nome = $contato->nome;
                $contatoObj->telefone = $contato->telefone;  //vai quebrar no telefone que vai ser celuar
                
                $endereco = new Endereco();
                $endereco->id = $contato->endereco_id;
                $endereco->rua = $contato->rua;
                $endereco->numero = $contato->numero;
                $endereco->bairro = $contato->bairro;
                $endereco->id_contatos = $contato->id_contatos;
                $contatoObj->endereco = $endereco;

                array_push($contatos,$contatoObj);
            }
            return $contatos; //dando um retorno do resultado da busca 

        }
//__________________________________________________________________________________________________________
        //busca na base e retorna o resultado
        function buscarTodos($conn){ //findAll(), somente a conexão que tem que vir de lá. sem filtros nem nada
            $sql = "SELECT * FROM contatos c left join enderecos e on c.id = e.id_contatos";
            $stmt = $conn->prepare($sql);
    
            $stmt->execute();
            $result = $stmt->fetchAll(PDO::FETCH_OBJ);

            $contatos =[];

            //retornando uma lista de contatos, sem precisar retornar a lista das colubns
            foreach($result as $contato) { 
                $contatoObj= new Contato();
                $contatoObj->id = $contato->id;
                $contatoObj->nome = $contato->nome;
                $contatoObj->telefone = $contato->telefone;  //vai quebrar no telefone que vai ser celuar
                $endereco = new Endereco();
                //$endereco->id = $contato->id;
                $endereco->rua = $contato->rua;
                $endereco->numero = $contato->numero;
                $endereco->bairro = $contato->bairro;
                $endereco->id_contatos = $contato->id_contatos;
                $contatoObj->endereco = $endereco;
                
                array_push($contatos,$contatoObj);
            }
            return $contatos;
        }
//__________________________________________________________________________________________________________
        function excluir($id,$conn){
            try{
                //criar sql p apagar e executar ele
                $sql = "DELETE FROM Contatos WHERE id =?"; //delete de contatos onde parametro é = ao valor da variavel
                $stmt = $conn->prepare($sql);
                $stmt->bindValue(1, $id); //o parametro recebe o valor da variavel 
                $stmt->execute();
            }catch(PDOException $erro){
                throw $erro;
            }
        }
//__________________________________________________________________________________________________________
        function buscarPeloId($id,$conn){
            $sql = "SELECT * FROM Contatos WHERE id = ?";
            $stmt = $conn->prepare($sql);
            $stmt->bindValue(1,$id);
            $stmt->execute();
            $result = $stmt->fetchAll(PDO::FETCH_OBJ);
            //cria camada pra aplicação não se contamine com estrutura de armazenamento
            $contato = new Contato();
            $contato->id = $id;
            $contato->nome = $result[0]->nome;  //objeto transformado em modelo
            $contato->telefone = $result[0]->telefone;
            return $contato; //retorna objeto preenchido com dados da base
        }
//__________________________________________________________________________________________________________
        function editar($contato,$conn){
            try{
                $sql = "UPDATE Contatos SET nome = ?,telefone = ? WHERE id = ?"; //update e delete é obrigado a colocar clausula WHERE
                $stmt = $conn->prepare($sql);  //staitment variavel
                $stmt->bindValue(1,$contato->nome); //binds  1 vai ser contato
                $stmt->bindValue(2,$contato->telefone);
                $stmt->bindValue(3,$contato->id);
                $stmt->execute();





                $result = $stmt->fetchALL(PDO::FETCH_OBJ);
                $contatos = [];
                foreach($result as $contato){
                    $contatoObj= new Contato();
                    $contatoObj->id = $contato->id;
                    $contatoObj->nome = $contato->nome;
                    $contatoObj->telefone = $contato->telefone;
                    array_push($contatos,$contatoObj);
                }
                return $result;

            }catch(PDOException $erro){
                throw $erro;
            }
        }
    }
?>