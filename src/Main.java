import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

//    private static DonationService donationService = new DonationService();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar item");
            System.out.println("2. Ler item");
            System.out.println("3. Editar item");
            System.out.println("4. Excluir item");
            System.out.println("5. Listar todos os itens");
            System.out.println("6. Sair");

            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        registerDonation(sc);
                        break;
//                    case 2:
//                        readDonation(sc);
//                        break;
//                    case 3:
//                        updateDonation(sc);
//                        break;
//                    case 4:
//                        deleteDonation(sc);
//                        break;
//                    case 5:
//                        listAllDonations();
//                        break;
                    case 6:
                        exit = true;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void registerDonation(Scanner scanner) throws SQLException {
        System.out.println("Cadastrar Item");
        System.out.print("Tipo do Item (Roupas/Higiene/Alimentos): ");
        String itemType = scanner.nextLine();
        System.out.print("Categoria do Item (Agasalhos/Camisas/Sabonete/Escova de dentes/Pasta de dentes/Absorventes): ");// tirar esse e o de baixo pra descricao
        String itemCategory = scanner.nextLine();
        System.out.print("Tamanho (Infantil/PP/P/M/G/GG) (deixe em branco se não se aplicar): ");
        String itemSize = scanner.nextLine();
        System.out.print("Quantidade: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consuming the newline character
        System.out.print("Centro de Distribuição (1- Canoas / 2- Porto Alegre / 3- Nova Cachoeirinha): ");
        String distributionCenter = scanner.nextLine();

        System.out.println(itemType);
        System.out.println(itemCategory);
        System.out.println(itemSize);
        System.out.println(quantity);
        System.out.println(distributionCenter);

//        Donation donation = new Donation(0, itemType, itemCategory, itemSize, quantity, distributionCenter);
//        donationService.addDonation(donation);
//        System.out.println("Item cadastrado com sucesso.");
    }

//    private static void readDonation(Scanner scanner) {
//        System.out.print("Digite o ID do item: ");
//        int id = scanner.nextInt();
//        scanner.nextLine(); // Consuming the newline character
//        Donation donation = donationService.getDonation(id);
//        if (donation != null) {
//            System.out.println(donation);
//        } else {
//            System.out.println("Item não encontrado.");
//        }
//    }
//
//    private static void updateDonation(Scanner scanner) throws SQLException {
//        System.out.print("Digite o ID do item: ");
//        int id = scanner.nextInt();
//        scanner.nextLine(); // Consuming the newline character
//
//        Donation existingDonation = donationService.getDonation(id);
//        if (existingDonation != null) {
//            System.out.println("Atualizar Item");
//            System.out.print("Tipo do Item (Roupas/Higiene/Alimentos): ");
//            String itemType = scanner.nextLine();
//            System.out.print("Categoria do Item (Agasalhos/Camisas/Sabonete/Escova de dentes/Pasta de dentes/Absorventes): ");
//            String itemCategory = scanner.nextLine();
//            System.out.print("Tamanho (Infantil/PP/P/M/G/GG) (deixe em branco se não se aplicar): ");
//            String itemSize = scanner.nextLine();
//            System.out.print("Quantidade: ");
//            int quantity = scanner.nextInt();
//            scanner.nextLine(); // Consuming the newline character
//            System.out.print("Centro de Distribuição (Porto Alegre/Canoas/Caxias do Sul): ");
//            String distributionCenter = scanner.nextLine();
//
//            Donation updatedDonation = new Donation(id, itemType, itemCategory, itemSize, quantity, distributionCenter);
//            donationService.updateDonation(updatedDonation);
//            System.out.println("Item atualizado com sucesso.");
//        } else {
//            System.out.println("Item não encontrado.");
//        }
//    }
//
//    private static void deleteDonation(Scanner scanner) throws SQLException {
//        System.out.print("Digite o ID do item: ");
//        int id = scanner.nextInt();
//        scanner.nextLine(); // Consuming the newline character
//
//        if (donationService.deleteDonation(id)) {
//            System.out.println("Item excluído com sucesso.");
//        } else {
//            System.out.println("Item não encontrado.");
//        }
//    }
//
//    private static void listAllDonations() {
//        List<Donation> donations = donationService.getAllDonations();
//        for (Donation donation : donations) {
//            System.out.println(donation);
//        }
//    }
}
