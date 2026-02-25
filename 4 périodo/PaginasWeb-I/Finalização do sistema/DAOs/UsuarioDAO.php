<?php
    require_once "../modelos/Usuario.php";

    class UsuarioDAO{
        public function salvar($usuario,$conn){
            $sql = "INSERT INTO Usuarios(usuario,senha) 
                VALUES (?,?)";

            try{  //pode dar erros
                $stmt = $conn->prepare($sql);

                $stmt->bindParam(1, $usuario->usuario);
                $hash = password_hash($usuario->senha,PASSWORD_DEFAULT);
                $stmt->bindParam(2, $hash);
            
                $stmt->execute();    //captura erro                                
            }catch(PDOException $erro){ //qualquer ponto que acontec eu erro vai capturar ele  
                throw $erro; //lança pra camada de cima o erro , exatamente o erro ou ele faz
            }
        }

        public function autenticar($usuario,$conn){

            $sql = "SELECT * FROM Usuarios WHERE 
                usuario = ?";
            
            try{
                $stmt = $conn->prepare($sql);
                $stmt->bindParam(1, $usuario->usuario);
                //$stmt->bindParam(2, $usuario->senha);
                $stmt->execute();
                $result = $stmt->fetchAll(PDO::FETCH_OBJ);
                if(count($result) == 0){
                    throw new PDOException("Usuário ou senha incorretos");
                }
                if(password_verify($usuario->senha,$result[0]->senha)){
                    $usuario = new Usuario();
                    $usuario->id = $result[0]->id;
                    $usuario->usuario = $result[0]->usuario;
                    $usuario->senha = $result[0]->senha;
                    var_dump($usuario);
                    return $usuario;
                }else{
                    throw new PDOException("Usuário ou senha incorretos");
                }
            }catch(PDOExceptoin $erro){
                throw $erro; 
            }

        }
    }