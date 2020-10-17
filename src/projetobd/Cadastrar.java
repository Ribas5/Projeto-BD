package projetobd;

import java.util.List;
import java.util.Scanner;

public class Cadastrar {

    public void menuPrincipal(Scanner entrada) {
        System.out.println("Cadastro Java");
        System.out.println("-------------------");
        System.out.println("Opção\t Descrição");
        System.out.println("1\t Cadastrar usuario");
        System.out.println("2\t sair");
        System.out.println("-------------------");
        System.out.println("escolha uma opção, 0 ou 1");

        int opcao = entrada.nextInt();
        entrada.nextLine();

        switch (opcao) {
            case 0:
                break;
            case 1:
                menuCadastroUsuario(entrada);
                break;
            default:
                menuPrincipal(entrada);
                break;
        }

    }

    public void menuCadastroUsuario(Scanner entrada) {
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
        System.out.println("escolha uma opção, 0 ou 1");

        int opcao = entrada.nextInt();
        entrada.nextLine();

        switch (opcao) {
            case 0:
                menuPrincipal(entrada);
                break;
            case 1:
                MCUListarTodosUsuarios(entrada);
                break;
            case 2:
                MCUListarUmUsuarios(entrada);
                break;
            case 3:
                MCUInserirUmUsuario(entrada);
                break;
            case 4:
                MCUAtulizarUmUsuario(entrada);
                break;
            case 5:
                MCURemoverUmUsuario(entrada);
                break;
            default:
                menuPrincipal(entrada);
                break;
        }

    }

    public void MCUListarTodosUsuarios(Scanner entrada) {
        System.out.println("Cadastro de Usuarios");
        System.out.println("-------------------");
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> usuarios = usuarioDAO.listarTodos();
        for (Usuario usuario : usuarios) {
            System.out.println("** ID: " + usuario.getId() + " - nome: " + usuario.getNome() + " - idade: " + usuario.getIdade() + " - email: " + usuario.getEmail() + " - senha: " + " - saldo: " + usuario.getSaldo() + " **");
        }
        System.out.println("* " + usuarios.size() + "usuarios encontrados *");
        menuCadastroUsuario(entrada);
    }

    public void MCUListarUmUsuarios(Scanner entrada) {
        System.out.println("Listar um Usuario");
        System.out.println("-------------------");
        System.out.println("Digite o ID do Usuario:");
        int Id = entrada.nextInt();
        entrada.nextLine();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.listar(Id);
        if (usuario != null) {
            System.out.println("** ID: " + usuario.getId() + " - nome: " + usuario.getNome() + " - idade: " + usuario.getIdade() + " - email: " + usuario.getEmail() + " - senha: " + " - saldo: " + usuario.getSaldo() + " **");
        } else {
            System.out.println("Usuario não encontrado");
        }
        menuCadastroUsuario(entrada);
    }

    public void MCUInserirUmUsuario(Scanner entrada) {
        System.out.println("Inserir um Usuario");
        System.out.println("-------------------");
        System.out.println("Digite o ID do Usuario:");
        int Id = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Digite o nome do Usuario:");
        String nome = entrada.nextLine();
        System.out.println("Digite o idade do Usuario:");
        int idade = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Digite o email do Usuario:");
        String email = entrada.nextLine();
        System.out.println("Digite o senha do Usuario:");
        String senha = entrada.nextLine();
        System.out.println("Digite o saldo do Usuario:");
        float saldo = entrada.nextFloat();
        entrada.nextLine();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.listar(Id);
        if (usuario != null) {
            System.out.println("** ID: " + usuario.getId() + " - nome: " + usuario.getNome() + " - idade: " + usuario.getIdade() + " - email: " + usuario.getEmail() + " - senha: " + " - saldo: " + usuario.getSaldo() + " **");
        } else {
            System.out.println("Usuario não encontrado");
        }
        menuCadastroUsuario(entrada);
    }
}

public void MCUAtulizarUmUsuario(Scanner scanner) {
    }

    public void MCURemoverUmUsuario(Scanner scanner) {
    }

    public static void main(String[] args) {

    }

}
