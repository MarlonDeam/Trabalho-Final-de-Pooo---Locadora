import java.io.*;
import java.time.LocalDate;
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
        carregarDados();
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n===== LOCADORA =====");
            System.out.println("1. Gerenciar Filmes");
            System.out.println("2. Gerenciar Jogos");
            System.out.println("3. Gerenciar Clientes");
            System.out.println("4. Realizar Locação");
            System.out.println("5. Registrar Devolução");
            System.out.println("6. Listar Locações");
            System.out.println("7. Criar locação de teste");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 1 -> menuFilmes();
                    case 2 -> menuJogos();
                    case 3 -> menuClientes();
                    case 4 -> realizarLocacao();
                    case 5 -> registrarDevolucao();
                    case 6 -> listarLocacoes();
                    case 7 -> criarLocacaoTeste();
                    case 0 -> {
                        salvarDados();
                        System.out.println("Encerrando...");
                    }
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

    static void menuClientes() {
        System.out.println("\n--- CLIENTES ---");
        System.out.println("1. Cadastrar cliente");
        System.out.println("2. Listar clientes");
        System.out.print("Opção: ");
        try {
            int op = scanner.nextInt(); scanner.nextLine();
            switch (op) {
                case 1 -> cadastrarCliente();
                case 2 -> listarClientes();
                default -> System.out.println("Opção inválida!");
            }
        } catch (Exception e) {
            System.out.println("Erro: digite apenas números!");
            scanner.nextLine();
        }
    }

    static void cadastrarCliente() {
        System.out.print("Nome: "); String nome = scanner.nextLine();
        System.out.print("CPF: "); String cpf = scanner.nextLine();
        System.out.print("Telefone: "); String telefone = scanner.nextLine();
        int id = clientes.size() + 1;
        clientes.add(new Cliente(id, nome, cpf, telefone));
        System.out.println("Cliente cadastrado com sucesso!");
    }

    static void listarClientes() {
        if (clientes.isEmpty()) { System.out.println("Nenhum cliente cadastrado."); return; }
        clientes.forEach(c -> System.out.println(c));
    }

    static void realizarLocacao() {
        listarClientes();
        System.out.print("ID do cliente: "); int idCliente = scanner.nextInt(); scanner.nextLine();
        Cliente cliente = clientes.stream().filter(c -> c.getId() == idCliente).findFirst().orElse(null);
        if (cliente == null) { System.out.println("Cliente não encontrado!"); return; }
        if (cliente.temPendencia()) { System.out.println("Cliente com multa pendente! Quite antes de locar."); return; }

        System.out.println("Locar: 1 - Filme  2 - Jogo");
        int tipo = scanner.nextInt(); scanner.nextLine();

        Item item = null;
        if (tipo == 1) {
            listarFilmes();
            System.out.print("ID do filme: "); int idFilme = scanner.nextInt(); scanner.nextLine();
            item = filmes.stream().filter(f -> f.getId() == idFilme).findFirst().orElse(null);
        } else {
            listarJogos();
            System.out.print("ID do jogo: "); int idJogo = scanner.nextInt(); scanner.nextLine();
            item = jogos.stream().filter(j -> j.getId() == idJogo).findFirst().orElse(null);
        }

        if (item == null) { System.out.println("Item não encontrado!"); return; }
        if (!item.isDisponivel()) { System.out.println("Item indisponível!"); return; }

        System.out.print("Prazo em dias: "); int prazo = scanner.nextInt(); scanner.nextLine();
        locacoes.add(new Locacao(cliente, item, prazo));
        System.out.println("Locação realizada com sucesso!");
    }

    static void registrarDevolucao() {
        listarLocacoes();
        System.out.print("Número da locação (posição na lista): "); int pos = scanner.nextInt(); scanner.nextLine();
        if (pos < 1 || pos > locacoes.size()) { System.out.println("Locação inválida!"); return; }
        Locacao loc = locacoes.get(pos - 1);
        if (loc.isDevolvido()) { System.out.println("Item já devolvido!"); return; }
        loc.registrarDevolucao();
        System.out.println("Devolução registrada! " + (loc.getCliente().getMulta() > 0 ? "Multa: R$ " + loc.getCliente().getMulta() : "Sem multa."));
    }

    static void listarLocacoes() {
        if (locacoes.isEmpty()) { System.out.println("Nenhuma locação registrada."); return; }
        for (int i = 0; i < locacoes.size(); i++) {
            System.out.println((i + 1) + ". " + locacoes.get(i));
        }
    }

    static void criarLocacaoTeste() {
        Cliente c = new Cliente(99, "Wagner", "000.000.000-00", "0000");
        Filme f = new Filme(99, "Programação Orientada a Objetos", "Wagner", "Ação", 120);
        Locacao loc = new Locacao(c, f, LocalDate.now().minusDays(2), LocalDate.now().minusDays(1));
        locacoes.add(loc);
        clientes.add(c);
        System.out.println("Locação de teste criada! Vá em Registrar Devolução para ver a multa.");
    }

    static void salvarDados() {
        try {
            ObjectOutputStream outFilmes = new ObjectOutputStream(new FileOutputStream("filmes.dat"));
            outFilmes.writeObject(filmes);
            outFilmes.close();

            ObjectOutputStream outJogos = new ObjectOutputStream(new FileOutputStream("jogos.dat"));
            outJogos.writeObject(jogos);
            outJogos.close();

            ObjectOutputStream outClientes = new ObjectOutputStream(new FileOutputStream("clientes.dat"));
            outClientes.writeObject(clientes);
            outClientes.close();

            ObjectOutputStream outLocacoes = new ObjectOutputStream(new FileOutputStream("locacoes.dat"));
            outLocacoes.writeObject(locacoes);
            outLocacoes.close();

            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    static void carregarDados() {
        try {
            ObjectInputStream inFilmes = new ObjectInputStream(new FileInputStream("filmes.dat"));
            filmes = (List<Filme>) inFilmes.readObject();
            inFilmes.close();

            ObjectInputStream inJogos = new ObjectInputStream(new FileInputStream("jogos.dat"));
            jogos = (List<Jogo>) inJogos.readObject();
            inJogos.close();

            ObjectInputStream inClientes = new ObjectInputStream(new FileInputStream("clientes.dat"));
            clientes = (List<Cliente>) inClientes.readObject();
            inClientes.close();

            ObjectInputStream inLocacoes = new ObjectInputStream(new FileInputStream("locacoes.dat"));
            locacoes = (List<Locacao>) inLocacoes.readObject();
            inLocacoes.close();

            System.out.println("Dados carregados!");
        } catch (FileNotFoundException e) {
            System.out.println("Nenhum dado salvo, iniciando do zero.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar: " + e.getMessage());
        }
    }
}