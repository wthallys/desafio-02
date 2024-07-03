import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opt;

        System.out.println("Escolhas uma das opções abaixo");

        do {
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Registrar doações");
            System.out.println("2 - Registrar abrigos");
            System.out.println("3 - Ordem de pedidos");
            System.out.println("4 - Checkout de items");
            System.out.println("5 - Transferir doações");
            System.out.println("0 - Sair");
            opt = sc.nextInt();
            switch (opt) {
                case 1:
                    System.out.println("Método 1");
                    break;
                case 2:
                    System.out.println("Método 2");
                    break;
                case 3:
                    System.out.println("mtd 3");
                    break;
                case 4:
                    System.out.println("mtd 4");
                    break;
                case 5:
                    System.out.println("mtd 5");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opt != 0);
    }
}