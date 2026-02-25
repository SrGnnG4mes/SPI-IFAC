<?php
    require_once "../conexao/Conexao.php";
    require_once "../DAOs/ContatosDao.php";
    require_once "../modelos/Contato.php";
    require_once "EnderecoControlador.php";
//tudo que manipula o controlador vai entrar como método aqui
//todos os contatos ficam aqui
    class ContatoControlador{

        public function salvar($contato){  //pega o objeto inteiro aqui, sem mais necessidade de fazer de 1 por 1
            try { //vai tentar abrir conexão, abrir dados
                $conexao = new Conexao();
                $conn = $conexao->conectar();  
            
                //é necessário chamar o DAO aqui, instanciando o objeto e chamando
                $contatosDao = new ContatosDao(); //classe responsavel por manipular quaquer mecanismo de armazenamento
                $id_contato = $contatosDao->salvar($contato,$conn); //esse metodo não vai ser mais alterado
               
                $enderecoControlador = new EnderecoControlador();
                $contato->endereco->id_contatos = $id_contato;
                $enderecoControlador->salvar($contato->endereco);


                $conexao->fechar();

                } catch (PDOException $e) {
                    throw $e; //lançar a exceção que passa pro de cima - principal
            }

        }
//_____________________________________________________________________________________________
        public function buscar($nome){
            try{
                $conexao = new Conexao();
                $conn = $conexao->conectar();

                //Instanciando um obj da classe Buscar e dando um return da busca
                $contatosDao = new ContatosDao();
                $result = $contatosDao->buscar($nome,$conn); //so pelo nome não precisa necessáriamente o obj contato, se tivesse mais filtro seria bom o objeto 
                
                //compartilhando dados entre páginas php
                //disponibilizando dados abrindo a sessao
                //session_start();
                //$_SESSION['resultado'] = $result;//array associativo para colocar variavel "global"

//vamos retornar o resultado p principal - se der certo 
                return $result;

                $conexao->fechar();
            }catch(PDOException $erro){   //se der erro
                throw $erro;
            }
        }
//___________________________________________________________________________________________
        public function buscarTodos(){
            try{
                $conexao = new Conexao();
                $conn = $conexao->conectar();

                $contatosDao = new ContatosDao();
                $result = $contatosDao->buscarTodos($conn); 
                $conexao->fechar();
                return $result;
            }catch(PDOException $erro){
                throw $erro;
            }
        }
//___________________________________________________________________________________________
        public function excluir($id){
            $contatosDao = new ContatosDao();
            try{
                $conexao = new Conexao();
                $conn = $conexao->conectar();

                $contatosDao->excluir($id,$conn); //passa o id e conexão
            }catch(PDPException $erro){  
                throw $erro; //lança o erro
            }
        }
//___________________________________________________________________________________________
        public function buscarPeloId($id){ //invoca dao pra fazere busca
            $contatosDao = new ContatosDao();  //cria dao
            try{
                $conexao = new Conexao(); //cria conexao
                $conn = $conexao->conectar();
                $contato = $contatosDao->buscarPeloId($id,$conn); //,manda dao busca no bd
                return $contato; //retorna dado pro principal
            }catch(PDOException $erro){
                throw $erro;
            }
        }
//___________________________________________________________________________________________
        public function editar($contato){
            $contatosDao = new ContatosDao();
            try{
                $conexao = new Conexao();
                $conn = $conexao->conectar();

                $contatosDao->editar($contato,$conn);
            }catch(PDOException $erro){
                throw $erro;
            }
        }
    }
?>