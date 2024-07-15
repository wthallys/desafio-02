import model.Donation;
import services.DonationService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static DonationService donationService = new DonationService();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Cadastrar item");
            System.out.println("2. Consultar item");
            System.out.println("3. Editar item");
            System.out.println("4. Excluir item");
            System.out.println("5. Listar todos os itens");
            System.out.println("6. Sair");

            int choice = sc.nextInt();
            sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Deseja cadastrar os itens por arquivo CSV? (s/n): ");
                        String method = sc.nextLine();
                        if (method.equalsIgnoreCase("s")) {
                            registerDonationsFromCSV(sc);
                        } else {
                            registerDonation(sc);
                        }
                        break;
                    case 2:
                        readDonation(sc);
                        break;
                    case 3:
                        updateDonation(sc);
                        break;
                    case 4:
                        deleteDonation(sc);
                        break;
                    case 5:
                        listAllDonations();
                        break;
                    case 6:
                        exit = true;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
        }
    }

    private static void registerDonation(Scanner scanner) {
        System.out.println("Cadastrar Item");
        System.out.print("Tipo do Item (Roupa/Higiene/Alimento): ");
        String itemType = scanner.nextLine();
        System.out.print("Descrição do Item: ");
        String itemDescription = scanner.nextLine();
        System.out.print("Data de validade (deixe em branco se não se aplicar): ");
        String itemExpirationDate = scanner.nextLine();
        System.out.print("Quantidade: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Centro de Distribuição (1- Canoas / 2- Porto Alegre / 3- Nova Cachoeirinha): ");
        int distributionCenter = scanner.nextInt();
        scanner.nextLine();

        Donation donation = new Donation(itemType, itemDescription, itemExpirationDate, quantity, distributionCenter);
        donationService.addDonation(donation);
        System.out.println("Item cadastrado com sucesso.");
    }

    private static void registerDonationsFromCSV(Scanner scanner) {
        System.out.println("Digite o caminho do arquivo CSV: ");
        String filePath = scanner.nextLine();

        String userHome = System.getProperty("user.home");

        try (BufferedReader br = new BufferedReader(new FileReader(userHome + filePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] values = line.split(",");
                String itemType = values[0].trim();
                String itemDescription = values[1].trim();
                String itemExpirationDate = values[2].trim();
                int quantity = Integer.parseInt(values[3].trim());
                int distributionCenter = Integer.parseInt(values[4].trim());


                Donation donation = new Donation(itemType, itemDescription, itemExpirationDate, quantity, distributionCenter);
                donationService.addDonation(donation);
                System.out.println("Item cadastrado com sucesso.");

            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }
    }

    private static void readDonation(Scanner scanner) {
        System.out.print("Digite o ID do item: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Donation donation = donationService.getDonation(id);
        if (donation != null) {
            System.out.println(donation);
        } else {
            System.out.println("Item não encontrado.");
        }
    }

    private static void updateDonation(Scanner scanner) {
        System.out.print("Digite o ID do item: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Donation existingDonation = donationService.getDonation(id);
        if (existingDonation != null) {
            System.out.println("Atualizar Item");
            System.out.print("Tipo do Item (Roupa/Higiene/Alimento): ");
            String itemType = scanner.nextLine();
            System.out.print("Descrição do Item: ");
            String itemDescription = scanner.nextLine();
            System.out.print("Data de validade (deixe em branco se não se aplicar): ");
            String itemExpirationDate = scanner.nextLine();
            System.out.print("Quantidade: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Centro de Distribuição (1- Canoas / 2- Porto Alegre / 3- Nova Cachoeirinha): ");
            int distributionCenter = scanner.nextInt();
            scanner.nextLine();

            Donation updatedDonation = new Donation(id, itemType, itemDescription, itemExpirationDate, quantity, distributionCenter);
            donationService.updateDonation(updatedDonation);
            System.out.println("Item atualizado com sucesso.");
        } else {
            System.out.println("Item não encontrado.");
        }
    }

    private static void deleteDonation(Scanner scanner) {
        System.out.print("Digite o ID do item: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (donationService.deleteDonation(id)) {
            System.out.println("Item excluído com sucesso.");
        } else {
            System.out.println("Item não encontrado.");
        }
    }

    private static void listAllDonations() {
        List<Donation> donations = donationService.getAllDonations();
        for (Donation donation : donations) {
            System.out.println(donation);
        }
    }
}
