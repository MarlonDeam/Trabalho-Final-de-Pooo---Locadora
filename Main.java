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
                switch (opcao) {
                    case 1 -> menuFilmes();
                    case 2 -> menuJogos();
                    case 0 -> System.out.println("Encerrando...");
                    default -> System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: digite apenas números!");
                scanner.nextLine();
            }
        }
    }

    static void menuFilmes() {
        System.out.println("\n--- FILMES ---");
        System.out.println("1. Cadastrar filme");
        System.out.println("2. Listar filmes");
        System.out.println("3. Remover filme");
        System.out.print("Opção: ");
        try {
            int op = scanner.nextInt(); scanner.nextLine();
            switch (op) {
                case 1 -> cadastrarFilme();
                case 2 -> listarFilmes();
                case 3 -> removerFilme();
                default -> System.out.println("Opção inválida!");
            }
        } catch (Exception e) {
            System.out.println("Erro: digite apenas números!");
            scanner.nextLine();
        }
    }

    static void cadastrarFilme() {
        System.out.print("Título: "); String titulo = scanner.nextLine();
        System.out.print("Diretor: "); String diretor = scanner.nextLine();
        System.out.print("Gênero: "); String genero = scanner.nextLine();
        System.out.print("Duração (min): "); int duracao = scanner.nextInt(); scanner.nextLine();
        int id = filmes.size() + 1;
        filmes.add(new Filme(id, titulo, diretor, genero, duracao));
        System.out.println("Filme cadastrado com sucesso!");
    }

    static void listarFilmes() {
        if (filmes.isEmpty()) { System.out.println("Nenhum filme cadastrado."); return; }
        filmes.forEach(f -> System.out.println(f.getDetalhes()));
    }

    static void removerFilme() {
        listarFilmes();
        System.out.print("ID do filme a remover: "); int id = scanner.nextInt(); scanner.nextLine();
        filmes.removeIf(f -> f.getId() == id);
        System.out.println("Filme removido!");
    }

    static void menuJogos() {
        System.out.println("\n--- JOGOS ---");
        System.out.println("1. Cadastrar jogo");
        System.out.println("2. Listar jogos");
        System.out.println("3. Remover jogo");
        System.out.print("Opção: ");
        try {
            int op = scanner.nextInt(); scanner.nextLine();
            switch (op) {
                case 1 -> cadastrarJogo();
                case 2 -> listarJogos();
                case 3 -> removerJogo();
                default -> System.out.println("Opção inválida!");
            }
        } catch (Exception e) {
            System.out.println("Erro: digite apenas números!");
            scanner.nextLine();
        }
    }

    static void cadastrarJogo() {
        System.out.print("Título: "); String titulo = scanner.nextLine();
        System.out.print("Plataforma: "); String plataforma = scanner.nextLine();
        System.out.print("Gênero: "); String genero = scanner.nextLine();
        System.out.print("Classificação indicativa: "); int classe = scanner.nextInt(); scanner.nextLine();
        int id = jogos.size() + 1;
        jogos.add(new Jogo(id, titulo, plataforma, genero, classe));
        System.out.println("Jogo cadastrado com sucesso!");
    }

    static void listarJogos() {
        if (jogos.isEmpty()) { System.out.println("Nenhum jogo cadastrado."); return; }
        jogos.forEach(j -> System.out.println(j.getDetalhes()));
    }

    static void removerJogo() {
        listarJogos();
        System.out.print("ID do jogo a remover: "); int id = scanner.nextInt(); scanner.nextLine();
        jogos.removeIf(j -> j.getId() == id);
        System.out.println("Jogo removido!");
    }
}