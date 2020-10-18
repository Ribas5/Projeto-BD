package projetobd;

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
        System.out.println("0\t Sair");
        System.out.println("-------------------");
        System.out.println("escolha uma opção, 0 ate 2");

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
            default:
                menuPrincipal(entrada);
                break;
        }

    }

    public void menuUsuario(Scanner entrada) {
        System.out.println("Cadastro de Usuarios");
        System.out.println("-------------------");
        System.out.println("Opção\t Descrição");
        System.out.println("1\t Listar todos os usuarios");
        System.out.println("2\t Listar um unico usuario");
        System.out.println("3\t Inserir um novo usuario");
        System.out.println("4\t Atualizar dados de um usuario");
        System.out.println("5\t Remover um usuario");
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
                ListarUmUsuarios(entrada);
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
        System.out.println("* " + usuarios.size() + "usuarios encontrados *");
        menuUsuario(entrada);
    }

    public void ListarUmUsuarios(Scanner entrada) {
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
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean sucesso = usuarioDAO.remover(Id);
        if (sucesso) {
            System.out.println("* USUARIO REMOVIDO *");
        } else {
            System.out.println("***USUARIO NÃO REMOVIDO***");
        }
        menuUsuario(entrada);
    }

    public void menuFilme(Scanner entrada) {
        System.out.println("Cadastro de Usuarios");
        System.out.println("-------------------");
        System.out.println("Opção\t Descrição");
        System.out.println("1\t Listar todos os filmes");
        System.out.println("2\t Listar um unico filme");
        System.out.println("3\t Inserir um novo filme");
        System.out.println("4\t Atualizar dados de um filme");
        System.out.println("5\t Remover um filme");
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
                ListarTodosFilmes(entrada);
                break;
            case 2:
                ListarUmFilme(entrada);
                break;
            case 3:
                InserirUmFilme(entrada);
                break;
            case 4:
                AtulizarUmFilme(entrada);
                break;
            case 5:
                RemoverUmFilme(entrada);
                break;
            default:
                menuPrincipal(entrada);
                break;
        }

    }

    public void ListarTodosFilmes(Scanner entrada) {
        System.out.println("Cadastro de Filme");
        System.out.println("-------------------");
        FilmeDAO filmeDAO = new FilmeDAO();
        List<Filme> filme = filmeDAO.listarTodos();
        for (Filme filmes : filme) {
            System.out.println("** ID: " + filmes.getId() + " - nome: " + filmes.getNome() + " - duração: " + filmes.getDuracao() + " - preço: " + filmes.getPreco() + " - Faixa etaria: " + filmes.getFaixaetaria() + " - ID do estudio: " + filmes.getIdestudio() + " **");
        }
        System.out.println("* " + filme.size() + "filmes encontrados *");
        menuFilme(entrada);
    }

    public void ListarUmFilme(Scanner entrada) {
        System.out.println("Listar um Filme");
        System.out.println("-------------------");
        System.out.println("Digite o ID do Filme:");
        int Id = entrada.nextInt();
        entrada.nextLine();
        FilmeDAO filmeDAO = new FilmeDAO();
        Filme filmes = filmeDAO.listar(Id);
        if (filmes != null) {
            System.out.println("** ID: " + filmes.getId() + " - nome: " + filmes.getNome() + " - duração: " + filmes.getDuracao() + " - preço: " + filmes.getPreco() + " - Faixa etaria: " + filmes.getFaixaetaria() + " - ID do estudio: " + filmes.getIdestudio() + " **");
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
        FilmeDAO filmeDAO = new FilmeDAO();
        boolean sucesso = filmeDAO.atualizar(Id,nome, duracao, preco, fetaria, idestudio);
        if (sucesso) {
            System.out.println("* FILME CDASTRADO *");
        } else {
            System.out.println("***FILME NÃO CADASTRADO***");
        }
        menuFilme(entrada);
    }

    public void RemoverUmFilme(Scanner entrada) {
        System.out.println("Remova um Filme");
        System.out.println("-------------------");
        System.out.println("Digite o ID do Filme:");
        int Id = entrada.nextInt();
        entrada.nextLine();
        FilmeDAO filmeDAO = new FilmeDAO();
        boolean sucesso = filmeDAO.remover(Id);
        if (sucesso) {
            System.out.println("* FILME REMOVIDO *");
        } else {
            System.out.println("***FILME NÃO REMOVIDO***");
        }
        menuFilme (entrada);
    }
    
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
                ListarTodosGeneros(entrada);
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

    public void ListarTodosGeneros(Scanner entrada) {
        System.out.println("Cadastro de Gêneros");
        System.out.println("-------------------");
        GeneroDAO generoDAO = new GeneroDAO();
        List<Genero> genero = generoDAO.listarTodos();
        for (Genero generos : genero) {
            System.out.println("** ID: " + generos.getId() + " - descricao: " + generos.getDescricao() + " **");
        }
        System.out.println("* " + genero.size() + "generos encontrados *");
        menuGenero(entrada);
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
        boolean sucesso = generoDAO.atualizar(Id,descricao);
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
        GeneroDAO generoDAO = new GeneroDAO();
        boolean sucesso = generoDAO.remover(Id);
        if (sucesso) {
            System.out.println("* GÊNERO REMOVIDO *");
        } else {
            System.out.println("***GÊNERO NÃO REMOVIDO***");
        }
        menuGenero (entrada);
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Cadastrar cadastrar = new Cadastrar();
        cadastrar.menuPrincipal(entrada);
        entrada.close();

    }
}
