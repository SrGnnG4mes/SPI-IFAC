<?php
    require_once "ContatoControlador.php"; 
    require_once "EnderecoControlador.php"; 
    require_once "UsuarioControlador.php"; 

//recebe dados da tela, e sabe pra onde vai, sabe toda a dinamica do sistema
//conhece as telas e vai redirecionar 

    //1ª coisa que pega é a ação
    $acao = $_GET['acao'];

    if($acao == "buscar"){  
        $nome = $_POST['nome'];
        //CRIAR OBJETO
        $contatoControlador = new ContatoControlador();
        try{
            $result = $contatoControlador->buscar($nome);
            session_start(); //compartilhando dados entre páginas php - disponibilizando dados abrindo a sessao
            $_SESSION['resultado'] = $result;//array associativo para colocar variavel "global"

            //redirecionar usuario para visão  - mostrarContatosVisao.php
            header("Location:../visoes/mostrarContatosVisoes.php");  //vai fazer a direção
        }catch(PDOException $erro){
            echo "Falha ao salvar os dados";
            echo $erro->getMessage(); 
        }
//_________________________________________________________________________________________________________
        //SABE QUAL TECNOLOGIA TA USANDO - se for mudar tec só precisa mudar aqui
    //cadastrando os dados no bd
    }else if($acao == "salvar"){  //conhece tecnologia que o cliente é feito, web protocolo http
        $nome = $_POST['nome'];
        $telefone = $_POST['telefone']; //copia o cod, ctrl c ctrl v, por isso não é legal usar
        $rua = $_POST['rua'];
        $numero = $_POST['numero'];
        $bairro = $_POST['bairro'];

        //criando objeto para passar completo
        $contato = new Contato();
        $contato->nome = $nome;
        $contato->telefone = $telefone; //aqui vai passar o objeto abaixo
        
        //encapsular todos os dados que vem do objeto endereço
        $endereco = new Endereco();
        $endereco->rua = $rua;
        $endereco->numero = $numero;
        $endereco->bairro = $bairro;
        $contato->endereco = $endereco;

        $contatoControlador = new ContatoControlador(); //cria objeto contato e instancia ele
        try{  
           $contatoControlador->salvar($contato); // passa o objeto inteiro pelo metodo  
            //se executar isso aqui significa que nenhum erro aconteceu e vai redirecionar p index
            header("Location: ../index.html"); //redireciona o usuario pra tela index
        }catch(PDOException $erro){  //se ocorrer algum erro vai entrar aqui
            echo "Falha ao salvar os dados";
            echo $erro->getMessage(); //pra saber que erro que é exatamente
        }//__________________________________________________________________________________________________________
    }else if($acao == "listar"){
        //include_once "listarContatos.php";
        $contatoControlador = new ContatoControlador();
        $contatos = $contatoControlador->buscarTodos(); //buscar todos os contatos
        session_start(); //coloca na sessão
        $_SESSION['resultado'] = $contatos; 
        header("Location: ../visoes/mostrarContatosVisoes.php"); //redireciona pra tela principal
//__________________________________________________________________________________________________________
    }else if($acao == "excluir"){ //tentativa de exclusão
        $id = $_GET['id'];
        $contatoControlador = new ContatoControlador();
        try{
            $contatoControlador->excluir($id); //se cair aqui é pq deu tudo certo
            $contatos = $contatoControlador->buscarTodos();
            session_start(); //coloca na sessão
            $_SESSION['resultado'] = $contatos; //lista atualizada
            //voltar para a tela de mostrar contatos
            //REFATORAR O LISTAR PARA NÃO FAZER ESSA GAMBIARRA
            header("Location: ../visoes/mostrarContatosVisoes.php"); // tem que fazer isso pois não implementamos o listar ainda 
        }catch(PDOException $erro){
            echo "Erro ao excluir contato";
        }
//__________________________________________________________________________________________________________
    }else if($acao == "editar"){
        $id = $_GET['id'];
        $contatoControlador = new ContatoControlador();
        $contato = $contatoControlador->buscarPeloId($id); //construindo metodo pra buscar contato pelo id
        var_dump($contato);
        session_start(); 
        $_SESSION['contato'] = $contato;   //o contato ainda está na sessão atualmente
        header("Location: ../visoes/formEditarContato.php");
        //formulário de edição
        
        
     /*   
        try{
            $contatoControlador->editar($id); 
            $contatos = $contatoControlador->buscarTodos();
            session_start();
            $_SESSION['resultado'] = $contatos;
            header("Location: ../visoes/mostrarContatosVisoes.php");
        }catch(PDOException $erro){
            echo "Erro ao editar contato";
            echo $erro->getMessage();
        }*/
//__________________________________________________________________________________________________________
    //form de edição
    }else if($acao == "alterar"){  //no momento que user clica em id ele salva em um objeto
        session_start(); 
        $contato_antigo = $_SESSION['contato'];  //pega o id o contato antigo, assim não precisa esconder nada pois o user não tem como alterar o id

        $id = $contato_antigo->id;  //pega do contato de tá na sessão
        $nome = $_POST['nome'];
        $telefone = $_POST['telefone'];
        //criando objeto com os dados acima
        $contato = new Contato();
        $contato->id = $id;
        $contato->nome = $nome;
        $contato->telefone = $telefone;
        //chama o controlador   - aqui vai instanciar objeto contato e salvar os dados dentro do objeto Contato
        $contatoControlador = new ContatoControlador();  
        //chamar o método de editar que vai mexer no bd, tentativ a de edição
        try{
           $contatoControlador->editar($contato);   //chama o controlador responsavel por controlar aquele objeto de contato
           unset($_SESSION['contato']);
           header("Location:../index.html");
        }catch(PDOException $erro){
            echo "ERRO:". $erro->getMessage();
        }
    }else if($acao == "salvarUsuario"){
        //pegar os dados do formulário
        $nome = $_POST['usuario'];
        $senha = $_POST['senha'];
        //invocar o controlador
        $usuario = new Usuario();
        $usuario->usuario = $nome;
        $usuario->senha = $senha;
        $usuarioControlador = new UsuarioControlador();

        try{
            $usuarioControlador->salvar($usuario);
            header("Location:../index.html");
        }catch(PDOException $erro){
            echo $erro->getMessage();
        }
    }else if($acao == "login"){
        $nome = $_POST['usuario'];
        $senha = $_POST['senha'];

        $usuario = new Usuario();
        $usuario->usuario = $nome;
        $usuario->senha = $senha;

        $usuarioControlador = new UsuarioControlador();
        try{
            $usuario = $usuarioControlador->autenticar($usuario);
            //armazenar na sessão um dado indicando
            //que a autenticação foi um sucesso
            //id do usuário que logou
            session_start();
            $_SESSION['usuario'] = $usuario;
            header("Location:../visoes/agenda.php");
        }catch(PDOException $erro){
            echo $erro->getMessage();
        }
    } else if($acao == "logout"){
        session_start();
        unset($_SESSION['usuario']);
        session_destroy();
        header("Location:../index.html");
        exit();
    }


?>