import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Filme> filmes = new ArrayList<>();
    private static List<Jogo> jogos = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Locacao> locacoes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n===== LOCADORA =====");
            System.out.println("1. Gerenciar Filmes");
            System.out.println("2. Gerenciar Jogos");
            System.out.println("3. Gerenciar Clientes");
            System.out.println("4. Realizar Locação");
            System.out.println("5. Registrar Devolução");
            System.out.println("6. Listar Locações");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Erro: digite apenas números!");
                scanner.nextLine();
            }
        }
    }
}