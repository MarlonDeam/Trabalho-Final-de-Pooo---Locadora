import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe principal do sistema de gerenciamento da locadora.
 *
 * <p>Esta classe é responsável por controlar a execução do programa,
 * exibindo os menus, realizando cadastros, locações, devoluções,
 * listagens e persistência dos dados da aplicação.</p>
 *
 * @author Marlon Deam
 * @version 1.0
 */
public class Main {
    /** Lista de filmes cadastrados. */
    private static List<Filme> filmes = new ArrayList<>();
    
    /** Lista de jogos cadastrados. */
    private static List<Jogo> jogos = new ArrayList<>();
    
    /** Lista de clientes cadastrados. */
    private static List<Cliente> clientes = new ArrayList<>();
    
    /** Lista de locações realizadas. */
    private static List<Locacao> locacoes = new ArrayList<>();
    
    /** Scanner utilizado para leitura das entradas do usuário. */
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Método principal da aplicação.
     *
     * <p>Inicializa os dados previamente salvos, exibe o menu principal
     * e permite ao usuário navegar pelas funcionalidades do sistema até
     * escolher a opção de encerramento.</p>
     *
     * @param args argumentos de linha de comando.
     */
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

    /**
     * Exibe o menu de gerenciamento de filmes.
     *
     * <p>Permite ao usuário cadastrar, listar ou remover filmes
     * cadastrados no sistema.</p>
     */
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

    /**
     * Realiza o cadastro de um novo filme.
     *
     * <p>Solicita ao usuário as informações necessárias e adiciona
     * o filme à lista de filmes cadastrados.</p>
     */
    static void cadastrarFilme() {
        System.out.print("Título: "); String titulo = scanner.nextLine();
        System.out.print("Diretor: "); String diretor = scanner.nextLine();
        System.out.print("Gênero: "); String genero = scanner.nextLine();
        System.out.print("Duração (min): "); int duracao = scanner.nextInt(); scanner.nextLine();
        int id = filmes.size() + 1;
        filmes.add(new Filme(id, titulo, diretor, genero, duracao));
        System.out.println("Filme cadastrado com sucesso!");
    }

    /**
     * Lista todos os filmes cadastrados.
     *
     * <p>Caso não existam filmes cadastrados, uma mensagem
     * informativa será exibida ao usuário.</p>
     */
    static void listarFilmes() {
        if (filmes.isEmpty()) { System.out.println("Nenhum filme cadastrado."); return; }
        filmes.forEach(f -> System.out.println(f.getDetalhes()));
    }

    /**
     * Remove um filme cadastrado.
     *
     * <p>Exibe a lista de filmes e solicita ao usuário o
     * identificador do filme que deverá ser removido.</p>
     */
    static void removerFilme() {
        listarFilmes();
        System.out.print("ID do filme a remover: "); int id = scanner.nextInt(); scanner.nextLine();
        filmes.removeIf(f -> f.getId() == id);
        System.out.println("Filme removido!");
    }

    /**
     * Exibe o menu de gerenciamento de jogos.
     *
     * <p>Permite cadastrar, listar e remover jogos
     * cadastrados no sistema.</p>
     */
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

    /**
     * Realiza o cadastro de um novo jogo.
     *
     * <p>Solicita ao usuário as informações necessárias
     * e adiciona o jogo à lista de jogos cadastrados.</p>
     */
    static void cadastrarJogo() {
        System.out.print("Título: "); String titulo = scanner.nextLine();
        System.out.print("Plataforma: "); String plataforma = scanner.nextLine();
        System.out.print("Gênero: "); String genero = scanner.nextLine();
        System.out.print("Classificação indicativa: "); int classe = scanner.nextInt(); scanner.nextLine();
        int id = jogos.size() + 1;
        jogos.add(new Jogo(id, titulo, plataforma, genero, classe));
        System.out.println("Jogo cadastrado com sucesso!");
    }

    /**
     * Lista todos os jogos cadastrados no sistema.
     *
     * <p>Caso não existam jogos cadastrados, uma mensagem
     * informativa será exibida ao usuário.</p>
     */
    static void listarJogos() {
        if (jogos.isEmpty()) { System.out.println("Nenhum jogo cadastrado."); return; }
        jogos.forEach(j -> System.out.println(j.getDetalhes()));
    }

    /**
     * Remove um jogo cadastrado.
     *
     * <p>Exibe a lista de jogos cadastrados e solicita
     * ao usuário o identificador do jogo que será removido.</p>
     */
    static void removerJogo() {
        listarJogos();
        System.out.print("ID do jogo a remover: "); int id = scanner.nextInt(); scanner.nextLine();
        jogos.removeIf(j -> j.getId() == id);
        System.out.println("Jogo removido!");
    }

    /**
     * Exibe o menu de gerenciamento de clientes.
     *
     * <p>Permite cadastrar novos clientes ou listar
     * todos os clientes cadastrados.</p>
     */
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

    /**
     * Realiza o cadastro de um novo cliente.
     *
     * <p>Solicita ao usuário os dados necessários e
     * adiciona o cliente à lista de clientes cadastrados.</p>
     */
    static void cadastrarCliente() {
        System.out.print("Nome: "); String nome = scanner.nextLine();
        System.out.print("CPF: "); String cpf = scanner.nextLine();
        System.out.print("Telefone: "); String telefone = scanner.nextLine();
        int id = clientes.size() + 1;
        clientes.add(new Cliente(id, nome, cpf, telefone));
        System.out.println("Cliente cadastrado com sucesso!");
    }

    /**
     * Lista todos os clientes cadastrados.
     *
     * <p>Caso não existam clientes cadastrados,
     * uma mensagem será exibida ao usuário.</p>
     */
    static void listarClientes() {
        if (clientes.isEmpty()) { System.out.println("Nenhum cliente cadastrado."); return; }
        clientes.forEach(c -> System.out.println(c));
    }

    /**
     * Realiza uma nova locação.
     *
     * <p>Permite selecionar um cliente e um item disponível,
     * definindo o prazo de devolução. Caso o cliente possua
     * multas pendentes ou o item esteja indisponível,
     * a locação não será realizada.</p>
     */
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

    /**
     * Registra la devolução de uma locação.
     *
     * <p>Após a devolução, o sistema verifica se existe
     * atraso e calcula automaticamente a multa, quando
     * aplicável.</p>
     */
    static void registrarDevolucao() {
        listarLocacoes();
        System.out.print("Número da locação (posição na lista): "); int pos = scanner.nextInt(); scanner.nextLine();
        if (pos < 1 || pos > locacoes.size()) { System.out.println("Locação inválida!"); return; }
        Locacao loc = locacoes.get(pos - 1);
        if (loc.isDevolvido()) { System.out.println("Item já devolvido!"); return; }
        loc.registrarDevolucao();
        System.out.println("Devolução registrada! " + (loc.getCliente().getMulta() > 0 ? "Multa: R$ " + loc.getCliente().getMulta() : "Sem multa."));
    }

    /**
     * Lista todas as locações registradas.
     *
     * <p>Exibe cada locação juntamente com sua posição
     * na lista para facilitar a seleção durante a devolução.</p>
     */
    static void listarLocacoes() {
        if (locacoes.isEmpty()) { System.out.println("Nenhuma locação registrada."); return; }
        for (int i = 0; i < locacoes.size(); i++) {
            System.out.println((i + 1) + ". " + locacoes.get(i));
        }
    }

    /**
     * Cria uma locação fictícia para testes.
     *
     * <p>Este método gera automaticamente um cliente,
     * um filme e uma locação com atraso para facilitar
     * a validação do cálculo de multas.</p>
     */
    static void criarLocacaoTeste() {
        Cliente c = new Cliente(99, "Wagner", "000.000.000-00", "0000");
        Filme f = new Filme(99, "Programação Orientada a Objetos", "Wagner", "Ação", 120);
        
        // CORREÇÃO: Adicionando o filme e o cliente criados às listas do sistema para evitar NullPointerException na persistência
        filmes.add(f);
        clientes.add(c);
        
        Locacao loc = new Locacao(c, f, LocalDate.now().minusDays(2), LocalDate.now().minusDays(1));
        locacoes.add(loc);
        System.out.println("Locação de teste criada! Vá em Registrar Devolução para ver a multa.");
    }

    /**
     * Salva todos os dados da aplicação em arquivos.
     *
     * <p>São armazenados os filmes, jogos, clientes
     * e locações utilizando serialização de objetos.</p>
     */
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

    /**
     * Carrega os dados previamente salvos.
     *
     * <p>Os arquivos contendo filmes, jogos, clientes e
     * locações são desserializados. Caso não existam
     * arquivos salvos, o sistema inicia com listas vazias.</p>
     */
    @SuppressWarnings("unchecked")
    static void carregarDados() {
        File fFilmes = new File("filmes.dat");
        File fJogos = new File("jogos.dat");
        File fClientes = new File("clientes.dat");
        File fLocacoes = new File("locacoes.dat");

        try {
            if (fFilmes.exists()) {
                try (ObjectInputStream inFilmes = new ObjectInputStream(new FileInputStream(fFilmes))) {
                    filmes = (List<Filme>) inFilmes.readObject();
                }
            }
            if (fJogos.exists()) {
                try (ObjectInputStream inJogos = new ObjectInputStream(new FileInputStream(fJogos))) {
                    jogos = (List<Jogo>) inJogos.readObject();
                }
            }
            if (fClientes.exists()) {
                try (ObjectInputStream inClientes = new ObjectInputStream(new FileInputStream(fClientes))) {
                    clientes = (List<Cliente>) inClientes.readObject();
                }
            }
            if (fLocacoes.exists()) {
                try (ObjectInputStream inLocacoes = new ObjectInputStream(new FileInputStream(fLocacoes))) {
                    locacoes = (List<Locacao>) inLocacoes.readObject();
                }
            }
            System.out.println("Dados carregados!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar: " + e.getMessage());
        }
    }
}