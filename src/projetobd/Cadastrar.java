package projetobd;

import java.util.Scanner;

public class Cadastrar {
    public void menuPrincipal(Scanner entrada){
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
    public static void main(String[] args) {

        
    }
    
}
