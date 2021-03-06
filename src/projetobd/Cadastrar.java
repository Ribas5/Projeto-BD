package projetobd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cadastrar {

    public void menuPrincipal(Scanner entrada) {
        System.out.println("Menu Java");
        System.out.println("-------------------");
        System.out.println("Opção\t Descrição");
        System.out.println("1\t Menu do usuario");
        System.out.println("2\t Menu dos filmes");
        System.out.println("3\t Menu dos gêneros");
        System.out.println("4\t menu dos estudios");
        System.out.println("5\t menu dos pedidos");
        System.out.println("0\t Sair");
        System.out.println("-------------------");
        System.out.println("escolha uma opção, 0 ate 5");

        int opcao = entrada.nextInt();
        entrada.nextLine();

        switch (opcao) {
            case 0:
                break;
            case 1:
                menuUsuario(entrada);
                break;
            case 2:
                menuFilme(entrada);
                break;
            case 3:
                menuGenero(entrada);
                break;
            case 4:
                menuEstudio(entrada);
                break;
            case 5:
                menuPedido(entrada);
                break;
            default:
                menuPrincipal(entrada);
                break;
        }

    }
///////////////// menu usuario /////////////////////

    public void menuUsuario(Scanner entrada) {
        System.out.println("Cadastro de Usuarios");
        System.out.println("-------------------");
        System.out.println("Opção\t Descrição");
        System.out.println("1\t Listar todos os usuarios");
        System.out.println("2\t Listar um unico usuario");
        System.out.println("3\t Inserir um novo usuario");
        System.out.println("4\t Atualizar dados de um usuario");
        System.out.println("5\t Remover um usuario");
        System.out.println("6\t Adicionar saldo a um usuario");
        System.out.println("0\t Voltar ao menu");
        System.out.println("-------------------");
        System.out.println("escolha uma opção, 0 a 5");

        int opcao = entrada.nextInt();
        entrada.nextLine();

        switch (opcao) {
            case 0:
                menuPrincipal(entrada);
                break;
            case 1:
                ListarTodosUsuarios(entrada);
                break;
            case 2:
                ListarUmUsuario(entrada);
                break;
            case 3:
                InserirUmUsuario(entrada);
                break;
            case 4:
                AtulizarUmUsuario(entrada);
                break;
            case 5:
                RemoverUmUsuario(entrada);
                break;
            case 6:
                AdicionarSaldoUsuario(entrada);
            default:
                menuPrincipal(entrada);
                break;
        }

    }

    public void ListarTodosUsuarios(Scanner entrada) {
        System.out.println("Cadastro de Usuarios");
        System.out.println("-------------------");
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> usuarios = usuarioDAO.listarTodos();
        for (Usuario usuario : usuarios) {
            System.out.println("** ID: " + usuario.getId() + " - nome: " + usuario.getNome() + " - idade: " + usuario.getIdade() + " - email: " + usuario.getEmail() + " - senha: " + usuario.getSenha() + " - saldo: " + usuario.getSaldo() + " **");
        }
        System.out.println("* " + usuarios.size() + " usuarios encontrados *");
        menuUsuario(entrada);
    }

    public void ListarUmUsuario(Scanner entrada) {
        System.out.println("Listar um Usuario");
        System.out.println("-------------------");
        System.out.println("Digite o ID do Usuario:");
        int Id = entrada.nextInt();
        entrada.nextLine();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.listar(Id);
        if (usuario != null) {
            System.out.println("** ID: " + usuario.getId() + " - nome: " + usuario.getNome() + " - idade: " + usuario.getIdade() + " - email: " + usuario.getEmail() + " - senha: " + usuario.getSenha() + " - saldo: " + usuario.getSaldo() + " **");
        } else {
            System.out.println("Usuario não encontrado");
        }
        menuUsuario(entrada);
    }

    public void InserirUmUsuario(Scanner entrada) {
        System.out.println("Inserir um Usuario");
        System.out.println("-------------------");
        System.out.println("Digite o nome do Usuario:");
        String nome = entrada.nextLine();
        System.out.println("Digite a idade do Usuario:");
        int idade = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Digite o email do Usuario:");
        String email = entrada.nextLine();
        System.out.println("Digite a senha do Usuario:");
        String senha = entrada.nextLine();
        System.out.println("Digite o saldo do Usuario:");
        float saldo = entrada.nextFloat();
        entrada.nextLine();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean sucesso = usuarioDAO.inserir(nome, idade, senha, email, saldo);
        if (sucesso) {
            System.out.println("* USUARIO CDASTRADO *");
        } else {
            System.out.println("***USUARIO NÃO CADASTRADO***");
        }
        menuUsuario(entrada);
    }

    public void AtulizarUmUsuario(Scanner entrada) {
        System.out.println("Atualizar um Usuario");
        System.out.println("-------------------");
        System.out.println("Digite o ID do Usuario:");
        int Id = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Digite o novo nome do Usuario:");
        String nome = entrada.nextLine();
        System.out.println("Digite a nova idade do Usuario:");
        int idade = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Digite o novo email do Usuario:");
        String email = entrada.nextLine();
        System.out.println("Digite o senha do Usuario:");
        String senha = entrada.nextLine();
        System.out.println("Digite o novo saldo do Usuario:");
        float saldo = entrada.nextFloat();
        entrada.nextLine();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean sucesso = usuarioDAO.atualizar(Id, nome, idade, senha, email, saldo);
        if (sucesso) {
            System.out.println("* USUARIO Atualizado *");
        } else {
            System.out.println("***USUARIO NÃO Atualizado***");
        }
        menuUsuario(entrada);
    }

    public void RemoverUmUsuario(Scanner entrada) {
        System.out.println("Remova um Usuario");
        System.out.println("-------------------");
        System.out.println("Digite o ID do Usuario:");
        int Id = entrada.nextInt();
        entrada.nextLine();
        
        // Verificar se usuario tem pedidos, perguntar se quer removê-los, se sim, remove tudo, se não, volta menu
        
        PedidoDAO pedidoDAO = new PedidoDAO();
        List<Pedido> pedidos = pedidoDAO.listarUsuario(Id);
        if (!pedidos.isEmpty()) {
            System.out.println("***O usuário possui pedidos cadastrados!***");
            System.out.println("Deseja apagar os pedidos ligados ao usuário? (S/N)");
            String opcao = entrada.nextLine();
            if (opcao.equals("S") || opcao.equals("s")) {
                for (Pedido pedido : pedidos) {
                    pedidoDAO.remover(pedido.getId());
                }
                System.out.println("* PEDIDOS REMOVIDOS *");
            } else {
                menuUsuario(entrada);
                return;
            }
        }
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean sucesso = usuarioDAO.remover(Id);
        if (sucesso) {
            System.out.println("* USUARIO REMOVIDO *");
        } else {
            System.out.println("***USUARIO NÃO REMOVIDO***");
        }
        menuUsuario(entrada);
    }
    
    public void AdicionarSaldoUsuario(Scanner entrada) {
        System.out.println("Adicionar saldo a um Usuario");
        System.out.println("-------------------");
        System.out.println("Digite o ID do Usuario:");
        int Id = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Digite o valor a ser adicionado ao Usuario:");
        float valor = entrada.nextFloat();
        entrada.nextLine();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean sucesso = usuarioDAO.alterarSaldo(Id, usuarioDAO.listar(Id).getSaldo()+valor);
        if (sucesso) {
            System.out.println("* USUARIO Atualizado *");
        } else {
            System.out.println("***USUARIO NÃO Atualizado***");
        }
        menuUsuario(entrada);
    }

    //////////// menu filme////////////////
    public void menuFilme(Scanner entrada) {
        System.out.println("Cadastro de Usuarios");
        System.out.println("-------------------");
        System.out.println("Opção\t Descrição");
        System.out.println("1\t Listar todos os filmes");
        System.out.println("2\t Listar um unico filme");
        System.out.println("3\t Inserir um novo filme");
        System.out.println("4\t Inserir os gêneros de um filme");
        System.out.println("5\t Atualizar dados de um filme");
        System.out.println("6\t Remover um filme");
        System.out.println("7\t Remover um gênero de um filme");
        System.out.println("0\t Voltar ao menu");
        System.out.println("-------------------");
        System.out.println("escolha uma opção, 0 a 5");

        int opcao = entrada.nextInt();
        entrada.nextLine();

        switch (opcao) {
            case 0:
                menuPrincipal(entrada);
                break;
            case 1:
                ListarTodosFilmes(entrada, true);
                break;
            case 2:
                ListarUmFilme(entrada);
                break;
            case 3:
                InserirUmFilme(entrada);
                break;
            case 4:
                InserirGenerosUmFilme(entrada);
                break;
            case 5:
                AtulizarUmFilme(entrada);
                break;
            case 6:
                RemoverUmFilme(entrada);
                break;
            case 7:
                RemoverGeneroUmFilme(entrada);
                break;
            default:
                menuPrincipal(entrada);
                break;
        }

    }

    public void ListarTodosFilmes(Scanner entrada, boolean menu) {
        System.out.println("Cadastro de Filme");
        System.out.println("-------------------");
        FilmeDAO filmeDAO = new FilmeDAO();
        GeneroFilmeDAO generoFilmeDAO = new GeneroFilmeDAO();
        List<Filme> filme = filmeDAO.listarTodos();
        for (Filme filmes : filme) {
            System.out.print("** ID: " + filmes.getId() + " - nome: " + filmes.getNome() + " - duração: " + filmes.getDuracao());
            List<Genero> generos = generoFilmeDAO.listarGenerosFilme(filmes.getId());
            if (!generos.isEmpty()) {
                System.out.print(" - gêneros: ");
                for (Genero genero : generos) {
                    System.out.print(genero.getDescricao() + ", ");
                }
            }
            System.out.print(" - preço: " + filmes.getPreco() + " - Faixa etaria: " + filmes.getFaixaetaria() + " - ID do estudio: " + filmes.getIdestudio() + " **\n");
        }
        System.out.println("* " + filme.size() + "filmes encontrados *");
        if (menu) menuFilme(entrada);
    }

    public void ListarUmFilme(Scanner entrada) {
        System.out.println("Listar um Filme");
        System.out.println("-------------------");
        System.out.println("Digite o ID do Filme:");
        int Id = entrada.nextInt();
        entrada.nextLine();
        FilmeDAO filmeDAO = new FilmeDAO();
        GeneroFilmeDAO generoFilmeDAO = new GeneroFilmeDAO();
        Filme filmes = filmeDAO.listar(Id);
        if (filmes != null) {
            System.out.print("** ID: " + filmes.getId() + " - nome: " + filmes.getNome() + " - duração: " + filmes.getDuracao());
            List<Genero> generos = generoFilmeDAO.listarGenerosFilme(filmes.getId());
            if (generos != null) {
                System.out.print(" - gêneros: ");
                for (Genero genero : generos) {
                    System.out.print(genero.getDescricao() + ", ");
                }
            }
            System.out.print(" - preço: " + filmes.getPreco() + " - Faixa etaria: " + filmes.getFaixaetaria() + " - ID do estudio: " + filmes.getIdestudio() + " **\n");
        } else {
            System.out.println("Filme não encontrado");
        }

        menuFilme(entrada);
    }

    public void InserirUmFilme(Scanner entrada) {
        System.out.println("Inserir um Filme");
        System.out.println("-------------------");
        System.out.println("Digite o nome do Filme: ");
        String nome = entrada.nextLine();
        System.out.println("Digite a duração do Filme:");
        int duracao = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Digite o preço do Filme:");
        float preco = entrada.nextFloat();
        entrada.nextLine();
        System.out.println("Digite a faixa etaria do Filme:");
        String fetaria = entrada.nextLine();
        System.out.println("Digite o id do estudio do Filme:");
        int idestudio = entrada.nextInt();
        entrada.nextLine();
        FilmeDAO filmeDAO = new FilmeDAO();
        boolean sucesso = filmeDAO.inserir(nome, duracao, preco, fetaria, idestudio);
        if (sucesso) {
            System.out.println("* FILME CDASTRADO *");
        } else {
            System.out.println("***FILME NÃO CADASTRADO***");
        }
        menuFilme(entrada);
    }

    public void InserirGenerosUmFilme(Scanner entrada) {
        GeneroFilmeDAO generoFilmeDAO = new GeneroFilmeDAO();
        System.out.println("Inserir os gêneros de um filme");
        System.out.println("-------------------");
        System.out.println("Digite o ID do Filme: ");
        int idFilme = entrada.nextInt();
        entrada.nextLine();
        List<Integer> idGeneros = new ArrayList<Integer>();
        System.out.println("Deseja visualizar todos os gêneros? (S/N)");
        String opcao = entrada.nextLine();
        if (opcao.equals("S") || opcao.equals("s")) {
            ListarTodosGeneros(entrada, false);
        }
        int idGenero = 0;
        System.out.println("Digite os IDs dos gêneros desejados (Digite -1 para terminar):");
        while (idGenero != -1) {
            idGenero = entrada.nextInt();
            entrada.nextLine();
            idGeneros.add(idGenero);
        }

        boolean sucesso = false;
        for (int genero : idGeneros) {
            if (genero != -1) {
                sucesso = generoFilmeDAO.inserir(idFilme, genero);
            }
        }

        if (sucesso) {
            System.out.println("* GÊNEROS CADASTRADOs *");
        } else {
            System.out.println("***GÊNEROS NÃO CADASTRADOS***");
        }

        menuFilme(entrada);
    }

    public void AtulizarUmFilme(Scanner entrada) {
        System.out.println("Atualizar um Filme");
        System.out.println("-------------------");
        System.out.println("Digite o ID do Filme:");
        int Id = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Digite o novo nome do Filme:");
        String nome = entrada.nextLine();
        System.out.println("Digite a duração do Filme:");
        int duracao = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Digite o preço do Filme:");
        float preco = entrada.nextFloat();
        entrada.nextLine();
        System.out.println("Digite a faixa etaria do Filme:");
        String fetaria = entrada.nextLine();
        System.out.println("Digite o id do estudio do Filme:");
        int idestudio = entrada.nextInt();
        entrada.nextLine();
        
        String opcao = "S";
        while (opcao.equals("S") || opcao.equals("s")) {
            System.out.println("Deseja alterar um gênero do filme? (S/N)");
            opcao = entrada.nextLine();
            if (opcao.equals("S") || opcao.equals("s")) {
                AtualizarUmGeneroFilme(entrada, Id);
            }
        }
        
        FilmeDAO filmeDAO = new FilmeDAO();
        boolean sucesso = filmeDAO.atualizar(Id, nome, duracao, preco, fetaria, idestudio);
        
        if (sucesso) {
            System.out.println("* FILME ATUALIZADO *");
        } else {
            System.out.println("***FILME NÃO ATUALIZADO***");
        }
        menuFilme(entrada);
    }

    public void AtualizarUmGeneroFilme(Scanner entrada, int idFilme) {
        GeneroFilmeDAO generoFilmeDAO = new GeneroFilmeDAO();
        System.out.println("os gêneros de um filme");
        System.out.println("-------------------");
        System.out.println("Deseja visualizar todos os gêneros? (S/N)");
        String opcao = entrada.nextLine();
        if (opcao.equals("S") || opcao.equals("s")) {
            ListarTodosGeneros(entrada, false);
        }
        System.out.println("Digite o ID do gênero para atualizar:");
        int idGenero = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Digite o ID do novo gênero:");
        int idNovoGenero = entrada.nextInt();
        entrada.nextLine();
        boolean sucesso = generoFilmeDAO.atualizar(idFilme, idGenero, idNovoGenero);
        if (sucesso) {
            System.out.println("* GÊNERO ATUALIZADO *");
        } else {
            System.out.println("***GÊNERO NÃO ATUALIZADO***");
        }
    }

    public void RemoverUmFilme(Scanner entrada) {
        System.out.println("Remova um Filme");
        System.out.println("-------------------");
        System.out.println("Digite o ID do Filme:");
        int Id = entrada.nextInt();
        entrada.nextLine();
        GeneroFilmeDAO generoFilmeDAO = new GeneroFilmeDAO();
        List<Genero> generosFilme = generoFilmeDAO.listarGenerosFilme(Id);
        for (Genero genero : generosFilme) {
            generoFilmeDAO.remover(Id, genero.getId());
        }
        FilmeDAO filmeDAO = new FilmeDAO();
        boolean sucesso = filmeDAO.remover(Id);
        if (sucesso) {
            System.out.println("* FILME REMOVIDO *");
        } else {
            System.out.println("***FILME NÃO REMOVIDO***");
        }
        menuFilme(entrada);
    }
    
    public void RemoverGeneroUmFilme(Scanner entrada) {
        GeneroFilmeDAO generoFilmeDAO = new GeneroFilmeDAO();
        System.out.println("Remova um gênero de um Filme");
        System.out.println("-------------------");
        System.out.println("Digite o ID do Filme: ");
        int idFilme = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Deseja visualizar todos os gêneros do filme? (S/N)");
        String opcao = entrada.nextLine();
        if (opcao.equals("S") || opcao.equals("s")) {
            List<Genero> generosFilme = generoFilmeDAO.listarGenerosFilme(idFilme);
            System.out.println("**Gêneros do filme**");
            for (Genero genero : generosFilme) {
                System.out.println("ID: " + genero.getId() + " - Nome: " + genero.getDescricao());
            }
        }
        System.out.println("Digite o ID do gênero para remover:");
        int idGenero = entrada.nextInt();
        entrada.nextLine();
        boolean sucesso = generoFilmeDAO.remover(idFilme, idGenero);
        if (sucesso) {
            System.out.println("* GÊNERO REMOVIDO *");
        } else {
            System.out.println("***GÊNERO NÃO REMOVIDO***");
        }
        menuFilme(entrada);
    }
    
///////// menu do genero ////////////////////

    public void menuGenero(Scanner entrada) {
        System.out.println("Cadastro de Gêneros");
        System.out.println("-------------------");
        System.out.println("Opção\t Descrição");
        System.out.println("1\t Listar todos os gêneros");
        System.out.println("2\t Listar um unico gênero");
        System.out.println("3\t Inserir um novo gênero");
        System.out.println("4\t Atualizar dados de um gênero");
        System.out.println("5\t Remover um gênero");
        System.out.println("0\t Voltar ao menu");
        System.out.println("-------------------");
        System.out.println("escolha uma opção, 0 a 5");

        int opcao = entrada.nextInt();
        entrada.nextLine();

        switch (opcao) {
            case 0:
                menuPrincipal(entrada);
                break;
            case 1:
                ListarTodosGeneros(entrada, true);
                break;
            case 2:
                ListarUmGenero(entrada);
                break;
            case 3:
                InserirUmGenero(entrada);
                break;
            case 4:
                AtulizarUmGenero(entrada);
                break;
            case 5:
                RemoverUmGenero(entrada);
                break;
            default:
                menuPrincipal(entrada);
                break;
        }

    }

    public void ListarTodosGeneros(Scanner entrada, boolean menu) {
        System.out.println("Cadastro de Gêneros");
        System.out.println("-------------------");
        GeneroDAO generoDAO = new GeneroDAO();
        List<Genero> genero = generoDAO.listarTodos();
        for (Genero generos : genero) {
            System.out.println("** ID: " + generos.getId() + " - descricao: " + generos.getDescricao() + " **");
        }
        System.out.println("* " + genero.size() + "generos encontrados *");
        if (menu) {
            menuGenero(entrada);
        }
    }

    public void ListarUmGenero(Scanner entrada) {
        System.out.println("Listar um Gênero");
        System.out.println("-------------------");
        System.out.println("Digite o ID do Gênero:");
        int Id = entrada.nextInt();
        entrada.nextLine();
        GeneroDAO generoDAO = new GeneroDAO();
        Genero generos = generoDAO.listar(Id);
        if (generos != null) {
            System.out.println("** ID: " + generos.getId() + " - descrição: " + generos.getDescricao() + " **");
        } else {
            System.out.println("Gênero não encontrado");
        }
        menuGenero(entrada);
    }

    public void InserirUmGenero(Scanner entrada) {
        System.out.println("Inserir um Genero");
        System.out.println("-------------------");
        System.out.println("Digite a descrição do Gênero: ");
        String descricao = entrada.nextLine();
        GeneroDAO generoDAO = new GeneroDAO();
        boolean sucesso = generoDAO.inserir(descricao);
        if (sucesso) {
            System.out.println("* GÊNERO CADASTRADO *");
        } else {
            System.out.println("***GÊNERO NÃO CADASTRADO***");
        }
        menuGenero(entrada);
    }

    public void AtulizarUmGenero(Scanner entrada) {
        System.out.println("Atualizar um Gênero");
        System.out.println("-------------------");
        System.out.println("Digite o ID do Genero:");
        int Id = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Digite a nova descrição do Gênero:");
        String descricao = entrada.nextLine();
        GeneroDAO generoDAO = new GeneroDAO();
        boolean sucesso = generoDAO.atualizar(Id, descricao);
        if (sucesso) {
            System.out.println("* GÊNERO CADASTRADO *");
        } else {
            System.out.println("***GÊNERO NÃO CADASTRADO***");
        }
        menuGenero(entrada);
    }

    public void RemoverUmGenero(Scanner entrada) {
        System.out.println("Remova um Genero");
        System.out.println("-------------------");
        System.out.println("Digite o ID do Genero:");
        int Id = entrada.nextInt();
        entrada.nextLine();
        
        GeneroFilmeDAO generoFilmeDAO = new GeneroFilmeDAO();
        List<Filme> filmes = generoFilmeDAO.listarFilmesGenero(Id);
        if (!filmes.isEmpty()) {
            System.out.println("***O gênero possui filmes cadastrados!***");
            System.out.println("Deseja apagar o gênero dos filmes cadastrados? (S/N)");
            String opcao = entrada.nextLine();
            if (opcao.equals("S") || opcao.equals("s")) {
                for (Filme filme : filmes) {
                    generoFilmeDAO.remover(filme.getId(), Id);
                }
            } else {
                menuUsuario(entrada);
                return;
            }
        }
        
        GeneroDAO generoDAO = new GeneroDAO();
        boolean sucesso = generoDAO.remover(Id);
        if (sucesso) {
            System.out.println("* GÊNERO REMOVIDO *");
        } else {
            System.out.println("***GÊNERO NÃO REMOVIDO***");
        }
        menuGenero(entrada);
    }

////////////menu do estudio//////
    public void menuEstudio(Scanner entrada) {
        System.out.println("Cadastro de Usuarios");
        System.out.println("-------------------");
        System.out.println("Opção\t Descrição");
        System.out.println("1\t Listar todos os estudio");
        System.out.println("2\t Listar um unico estudio");
        System.out.println("3\t Inserir um novo estudio");
        System.out.println("4\t Atualizar dados de um estudio");
        System.out.println("5\t Remover um estudio");
        System.out.println("0\t Voltar ao menu");
        System.out.println("-------------------");
        System.out.println("escolha uma opção, 0 a 5");

        int opcao = entrada.nextInt();
        entrada.nextLine();

        switch (opcao) {
            case 0:
                menuPrincipal(entrada);
                break;
            case 1:
                ListarTodosEstudios(entrada);
                break;
            case 2:
                ListarUmEstudio(entrada);
                break;
            case 3:
                InserirUmEstudio(entrada);
                break;
            case 4:
                AtulizarUmEstudio(entrada);
                break;
            case 5:
                RemoverUmEstudio(entrada);
                break;
            default:
                menuPrincipal(entrada);
                break;
        }

    }

    public void ListarTodosEstudios(Scanner entrada) {
        System.out.println("listar todos os estudios");
        System.out.println("-------------------");
        EstudioDAO estudioDAO = new EstudioDAO();
        List<Estudio> estudio = estudioDAO.listarTodos();
        for (Estudio estudios : estudio) {
            System.out.println("** ID: " + estudios.getId() + " - nome: " + estudios.getNome() + " **");
        }
        System.out.println("* " + estudio.size() + "estudios encontrados *");
        menuEstudio(entrada);
    }

    public void ListarUmEstudio(Scanner entrada) {
        System.out.println("Listar um Estudio");
        System.out.println("-------------------");
        System.out.println("Digite o ID do Estudio:");
        int Id = entrada.nextInt();
        entrada.nextLine();
        EstudioDAO estudioDAO = new EstudioDAO();
        Estudio estudios = estudioDAO.listar(Id);
        if (estudios != null) {
            System.out.println("** ID: " + estudios.getId() + " - nome: " + estudios.getNome() + " **");
        } else {
            System.out.println("Estudio não encontrado, verifique se o ID esta correto");
        }
        menuEstudio(entrada);
    }

    public void InserirUmEstudio(Scanner entrada) {
        System.out.println("Inserir um Estudio");
        System.out.println("----------------");
        System.out.println("Digite o nome do Estudio: ");
        String nome = entrada.nextLine();
        EstudioDAO estudioDAO = new EstudioDAO();
        boolean sucesso = estudioDAO.inserir(nome);
        if (sucesso) {
            System.out.println("* ESTUDIO CDASTRADO *");
        } else {
            System.out.println("***ESTUDIO NÃO CADASTRADO***");
        }
        menuEstudio(entrada);
    }

    public void AtulizarUmEstudio(Scanner entrada) {
        System.out.println("Atualizar um Estudio");
        System.out.println("-------------------");
        System.out.println("Digite o ID do Estudio:");
        int Id = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Digite o novo nome do Estudio:");
        String descricao = entrada.nextLine();
        GeneroDAO generoDAO = new GeneroDAO();
        boolean sucesso = generoDAO.atualizar(Id, descricao);
        if (sucesso) {
            System.out.println("* ESTUDIO CADASTRADO *");
        } else {
            System.out.println("***ESTUDIO NÃO CADASTRADO***");
        }
        menuEstudio(entrada);
    }

    public void RemoverUmEstudio(Scanner entrada) {
        System.out.println("Remova um Estudio");
        System.out.println("-------------------");
        System.out.println("Digite o ID do Estudio:");
        int Id = entrada.nextInt();
        entrada.nextLine();
        EstudioDAO estudioDAO = new EstudioDAO();
        boolean sucesso = estudioDAO.remover(Id);
        if (sucesso) {
            System.out.println("* ESTUDIO REMOVIDO *");
        } else {
            System.out.println("***ESTUDIO NÃO REMOVIDO***");
        }
        menuEstudio(entrada);
    }

    ///////////////menu pedido //////////////////
    public void menuPedido(Scanner entrada) {
        System.out.println("Cadastro de Pedidos");
        System.out.println("-------------------");
        System.out.println("Opção\t Descrição");
        System.out.println("1\t Listar todos os Pedidos");
        System.out.println("2\t Listar um unico Pedido");
        System.out.println("3\t Listar pedidos de um usuário");
        System.out.println("4\t Inserir um novo Pedido");
        System.out.println("5\t Inserir filmes em um pedido");
        System.out.println("6\t Atualizar dados de um Pedido");
        System.out.println("7\t Remover um Pedido");
        System.out.println("8\t Remover um filme de um Pedido");
        System.out.println("0\t Voltar ao menu");
        System.out.println("-------------------");
        System.out.println("escolha uma opção, 0 a 5");

        int opcao = entrada.nextInt();
        entrada.nextLine();

        switch (opcao) {
            case 0:
                menuPrincipal(entrada);
                break;
            case 1:
                ListarTodosPedidos(entrada);
                break;
            case 2:
                ListarUmPedido(entrada);
                break;
            case 3:
                ListarPedidosUmUsuario(entrada);
                break;
            case 4:
                InserirUmPedido(entrada);
                break;
            case 5:
                InserirFilmesUmPedido(entrada);
                break;
            case 6:
                AtulizarUmPedido(entrada);
                break;
            case 7:
                RemoverUmPedido(entrada);
                break;
            case 8:
                RemoverFilmesUmPedido(entrada);
                break;
            default:
                menuPrincipal(entrada);
                break;
        }

    }

    public void ListarTodosPedidos(Scanner entrada) {
        System.out.println("Cadastro de Pedidos");
        System.out.println("-------------------");
        PedidoDAO pedidoDAO = new PedidoDAO();
        List<Pedido> pedido = pedidoDAO.listarTodos();
        for (Pedido pedidos : pedido) {
            System.out.println("** ID: " + pedidos.getId() + " - data: " + pedidos.getData() + " - Expiração: " + pedidos.getExpiracao() + " - Identificador do usuario que fez o pedido: " + pedidos.getIDU() + " **");
        }
        System.out.println("* " + pedido.size() + "Pedidos encontrados *");
        menuPedido(entrada);
    }

    public void ListarUmPedido(Scanner entrada) {
        System.out.println("Listar um Pedido");
        System.out.println("-------------------");
        System.out.println("Digite o ID do Pedido:");
        int Id = entrada.nextInt();
        entrada.nextLine();
        PedidoDAO pedidoDAO = new PedidoDAO();
        Pedido pedidos = pedidoDAO.listar(Id);
        if (pedidos != null) {
            PedidoFilmeDAO pedidoFilmeDAO = new PedidoFilmeDAO();
            List<Filme> filmesPedido = pedidoFilmeDAO.listarFilmesPedido(Id);
            System.out.println("** ID: " + pedidos.getId() + " - data: " + pedidos.getData() + " - Expiração: " + pedidos.getExpiracao() + " - Identificador do usuario que fez o pedido: " + pedidos.getIDU() + " **");
            System.out.println("**Filmes do pedido (" + filmesPedido.size() + " filme(s))**");
            for (Filme filme : filmesPedido) {
                System.out.println("ID: " + filme.getId() + " - Nome: " + filme.getNome());
            }
        } else {
            System.out.println("Pedido não encontrado, verifique se o ID esta correto");
        }
        menuPedido(entrada);
    }
    
    public void ListarPedidosUmUsuario(Scanner entrada) {
        System.out.println("Listar pedidos de um Usuário");
        System.out.println("-------------------");
        System.out.println("Digite o ID do Usuário:");
        int Id = entrada.nextInt();
        entrada.nextLine();
        PedidoDAO pedidoDAO = new PedidoDAO();
        List<Pedido> pedidos = pedidoDAO.listarUsuario(Id);
        for (Pedido pedido : pedidos) {
            System.out.println("** ID: " + pedido.getId() + " - data: " + pedido.getData() + " - Expiração: " + pedido.getExpiracao() + " - Identificador do usuario que fez o pedido: " + pedido.getIDU() + " **");
        }
        System.out.println("* " + pedidos.size() + "Pedidos encontrados *");
        menuPedido(entrada);
    }

    public void InserirUmPedido(Scanner entrada) {
        System.out.println("Inserir um Pedido");
        System.out.println("----------------");
        System.out.println("Digite a data do aluguel: ");
        String data = entrada.nextLine();
        System.out.println("Digite a data de expiração: ");
        String expiracao = entrada.nextLine();
        System.out.println("Digite o id do usuario que fez o pedido");
        int id_user = entrada.nextInt();
        entrada.nextLine();
        PedidoDAO pedidoDAO = new PedidoDAO();
        boolean sucesso = pedidoDAO.inserir(data, expiracao, id_user);
        if (sucesso) {
            System.out.println("* Pedido CDASTRADO *");
        } else {
            System.out.println("***Pedido NÃO CADASTRADO***");
        }
        menuPedido(entrada);
    }
    
    public void InserirFilmesUmPedido (Scanner entrada) {
        PedidoFilmeDAO pedidoFilmeDAO = new PedidoFilmeDAO();
        System.out.println("Inserir os filmes de um pedido");
        System.out.println("-------------------");
        System.out.println("Digite o ID do Pedido: ");
        int idPedido = entrada.nextInt();
        entrada.nextLine();
        List<Integer> idFilmes = new ArrayList<Integer>();
        System.out.println("Deseja visualizar todos os filmes? (S/N)");
        String opcao = entrada.nextLine();
        if (opcao.equals("S") || opcao.equals("s")) {
            ListarTodosFilmes(entrada, false);
        }
        int idFilme = 0;
        System.out.println("Digite os IDs dos filmes desejados (Digite -1 para terminar):");
        while (idFilme != -1) {
            idFilme = entrada.nextInt();
            entrada.nextLine();
            idFilmes.add(idFilme);
        }

        PedidoDAO pedidoDAO = new PedidoDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        FilmeDAO filmeDAO = new FilmeDAO();
        boolean sucesso = false;
        int usuario = pedidoDAO.listar(idPedido).getIDU();
        
        for (int filme : idFilmes) {
            if (filme != -1) {
                float novoSaldo = usuarioDAO.listar(usuario).getSaldo() - filmeDAO.listar(filme).getPreco();
                if (novoSaldo < 0){
                    System.out.println("***Saldo insuficiente para aluguel de mais filmes!***");
                    menuPedido(entrada);
                }
                sucesso = pedidoFilmeDAO.inserir(filme, idPedido) && usuarioDAO.alterarSaldo(usuario, novoSaldo);
            }
        }

        if (sucesso) {
            System.out.println("* FILMES CADASTRADOS *");
        } else {
            System.out.println("***FILMES NÃO CADASTRADOS***");
        }

        menuPedido(entrada);
    }

    public void AtulizarUmPedido(Scanner entrada) {
        System.out.println("Atualizar um Pedido");
        System.out.println("-------------------");
        System.out.println("Digite o novo id do pedido");
        int id = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Digite a data do aluguel: ");
        String data = entrada.nextLine();
        System.out.println("Digite a data de expiração: ");
        String expiracao = entrada.nextLine();
        System.out.println("Digite o id do usuario que fez o pedido");
        int id_user = entrada.nextInt();
        entrada.nextLine();
        
        String opcao = "S";
        while (opcao.equals("S") || opcao.equals("s")) {
            System.out.println("Deseja alterar um filme do Pedido? (S/N)");
            opcao = entrada.nextLine();
            if (opcao.equals("S") || opcao.equals("s")) {
                AtualizarFilmesUmPedido(entrada, id);
            }
        }
        
        PedidoDAO pedidoDAO = new PedidoDAO();
        boolean sucesso = pedidoDAO.atualizar(id, data, expiracao, id_user);
        if (sucesso) {
            System.out.println("* Pedido CADASTRADO *");
        } else {
            System.out.println("***Pedido NÃO CADASTRADO***");
        }
        menuPedido(entrada);
    }
    
    public void AtualizarFilmesUmPedido(Scanner entrada, int idPedido) {
        PedidoFilmeDAO pedidoFilmeDAO = new PedidoFilmeDAO();
        PedidoDAO pedidoDAO = new PedidoDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        FilmeDAO filmeDAO = new FilmeDAO();
        System.out.println("Atualizar os filmes de um Pedido");
        System.out.println("-------------------");
        System.out.println("Deseja visualizar todos os filmes? (S/N)");
        String opcao = entrada.nextLine();
        if (opcao.equals("S") || opcao.equals("s")) {
            ListarTodosFilmes(entrada, false);
        }
        System.out.println("Digite o ID do filme para atualizar:");
        int idFilme = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Digite o ID do novo filme:");
        int idNovoFilme = entrada.nextInt();
        entrada.nextLine();
        int idUsuario = pedidoDAO.listar(idPedido).getIDU();
        float novoSaldo = usuarioDAO.listar(idUsuario).getSaldo() + filmeDAO.listar(idFilme).getPreco() - filmeDAO.listar(idNovoFilme).getPreco();
        if (novoSaldo < 0){
            System.out.println("***Saldo insuficiente para adicionar o filme!***");
            menuPedido(entrada);
        }
        boolean sucesso = pedidoFilmeDAO.atualizar(idPedido, idFilme, idNovoFilme) && usuarioDAO.alterarSaldo(idUsuario, novoSaldo);
        if (sucesso) {
            System.out.println("* FILME ATUALIZADO *");
        } else {
            System.out.println("***FILME NÃO ATUALIZADO***");
        }
        menuPedido(entrada);
    }

    public void RemoverUmPedido(Scanner entrada) {
        System.out.println("Remova um Pedido do banco");
        System.out.println("-------------------");
        System.out.println("Digite o ID do Pedido: ");
        int Id = entrada.nextInt();
        entrada.nextLine();
        PedidoFilmeDAO pedidoFilmeDAO = new PedidoFilmeDAO();
        List<Filme> filmesPedido = pedidoFilmeDAO.listarFilmesPedido(Id);
        for (Filme filme : filmesPedido) {
            pedidoFilmeDAO.remover(Id, filme.getId());
        }
        PedidoDAO pedidoDAO = new PedidoDAO();
        boolean sucesso = pedidoDAO.remover(Id);
        if (sucesso) {
            System.out.println("* Pedido REMOVIDO *");
        } else {
            System.out.println("***Pedido NÃO REMOVIDO***");
        }
        menuPedido(entrada);
    }
    
    public void  RemoverFilmesUmPedido(Scanner entrada) {
        PedidoFilmeDAO pedidoFilmeDAO = new PedidoFilmeDAO();
        PedidoDAO pedidoDAO = new PedidoDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        FilmeDAO filmeDAO = new FilmeDAO();
        System.out.println("Remova um filme de um Pedido");
        System.out.println("-------------------");
        System.out.println("Digite o ID do Pedido: ");
        int idPedido = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Deseja visualizar todos os filmes do pedido? (S/N)");
        String opcao = entrada.nextLine();
        if (opcao.equals("S") || opcao.equals("s")) {
            List<Filme> filmesPedido = pedidoFilmeDAO.listarFilmesPedido(idPedido);
            System.out.println("**Filmes do pedido (" + filmesPedido.size() + " filme(s))**");
            for (Filme filme : filmesPedido) {
                System.out.println("ID: " + filme.getId() + " - Nome: " + filme.getNome());
            }
        }
        System.out.println("Digite o ID do filme para remover:");
        int idFilme = entrada.nextInt();
        entrada.nextLine();
        int idUsuario = pedidoDAO.listar(idPedido).getIDU();
        float novoSaldo = usuarioDAO.listar(idUsuario).getSaldo() + filmeDAO.listar(idFilme).getPreco();
        boolean sucesso = pedidoFilmeDAO.remover(idPedido, idFilme) && usuarioDAO.alterarSaldo(idUsuario, novoSaldo);
        if (sucesso) {
            System.out.println("* FILME REMOVIDO *");
        } else {
            System.out.println("***FILME NÃO REMOVIDO***");
        }
        menuPedido(entrada);
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Cadastrar cadastrar = new Cadastrar();
        cadastrar.menuPrincipal(entrada);
        entrada.close();
    }
}
