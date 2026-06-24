# Documentação do Sistema de Locadora

## 1. Visão Geral do Sistema
O sistema consiste em uma aplicação de terminal em Java para o gerenciamento de uma locadora de itens multimídia (Filmes e Jogos). O software permite o cadastro de clientes, controle de inventário, fluxo de locação e devolução, além do cálculo automatizado de multas por atraso e persistência dos dados de forma local.

---

## 2. Arquitetura e Estrutura de Classes
O projeto foi desenvolvido aplicando os pilares da **Programação Orientada a Objetos (POO)**:

### Interfaces e Classes Abstratas
* **`Locavel` (Interface):** Define o contrato de comportamento para qualquer item que possa ser alugado no sistema, exigindo os métodos `getDetalhes()`, `isDisponivel()` e `setDisponivel()`.
* **`Item` (Classe Abstrata):** Implementa `Locavel` e serve como base para os produtos da locadora. Possui os atributos protegidos `id`, `titulo` e `disponivel`.

### Classes de Domínio (Entidades)
* **`Filme` (Herança de `Item`):** Especializa um item com os atributos específicos `diretor`, `genero` e `duracao`.
* **`Jogo` (Herança de `Item`):** Especializa um item com os atributos específicos `plataforma`, `genero` e `classeIndicativa`.
* **`Cliente`:** Representa o usuário do sistema. Armazena dados pessoais (`id`, `nome`, `cpf`, `telefone`) e controla o saldo de `multa` pendente.
* **`Locacao`:** Gerencia a regra de negócio do empréstimo. Associa um `Cliente` a um `Item` e controla o fluxo de datas (`dataRetirada`, `dataPrevista` e `dataEntrega`) utilizando a API `java.time`.

---

## 3. Principais Regras de Negócio e Funcionalidades

### Fluxo de Locação
1. O sistema verifica se o cliente possui multas em aberto usando o método `cliente.temPendencia()`. **Clientes com pendências são bloqueados** de realizar novas locações.
2. O sistema verifica a disponibilidade do item (`item.isDisponivel()`).
3. Ao confirmar a locação, o status do item é alterado para indisponível (`item.setDisponivel(false)`).

### Fluxo de Devolução e Cálculo de Multa
* A taxa de atraso é calculada de forma linear: **R$ 2,00 por dia passado** da data prevista de entrega.
* O cálculo é feito comparando as datas via `ChronoUnit.DAYS.between(dataPrevista, dataEntrega)`.
* Ao registrar a devolução, se houver atraso, o valor gerado é somado diretamente à conta do cliente através do método `cliente.adicionarMulta(valor)`. O item retorna ao status disponível.

---

## 4. Persistência de Dados
O sistema utiliza a **Serialização do Java** para salvar o estado da aplicação em arquivos binários locais. Isso garante que os dados não sejam perdidos ao fechar o programa.

* Todas as classes principais implementam a interface `java.io.Serializable`.
* **Salvamento:** Feito via `ObjectOutputStream`, gerando os arquivos `clientes.dat`, `filmes.dat`, `jogos.dat` e `locacoes.dat` na raiz do projeto.
* **Carregamento:** Feito via `ObjectInputStream` no início da execução da classe `Main`. Se os arquivos não existirem, o sistema inicia com listas vazias.

---

## 5. Como Executar o Projeto

### Pré-requisitos
* Ter o **Java JDK** instalado na máquina (versão 17 ou superior recomendada).
* Um terminal de linha de comando (Bash, Terminal do Linux/macOS ou Prompt de Comando/PowerShell no Windows).

### Passo a Passo

1. **Clonar o repositório:**
   ```bash
   git clone [https://github.com/MarlonDeam/Trabalho-Final-de-Pooo---Locadora.git](https://github.com/MarlonDeam/Trabalho-Final-de-Pooo---Locadora.git)
   cd Trabalho-Final-de-Pooo---Locadora

Compilar os arquivos fonte:
    No terminal, dentro da pasta raiz do projeto onde estão os arquivos .java, execute o compilador do Java:
    Bash

    javac *.java

    Executar a aplicação:
    Após a compilação gerar os arquivos .class, inicie o programa chamando a classe principal:
    Bash

    java Main

6. Guia de Uso (Manual do Usuário)

Ao executar a classe Main, o sistema abrirá um menu interativo no terminal. Digite o número correspondente à ação desejada e pressione Enter:
🔹 Menu Principal

    1. Gerenciar Filmes e 2. Gerenciar Jogos: Permite cadastrar novos itens informando seus dados (Título, Gênero, Diretor/Plataforma), listar os itens do acervo com seus status de disponibilidade ou remover itens por ID.

    3. Gerenciar Clientes: Permite cadastrar novos clientes informando Nome, CPF e Telefone, e listar os clientes já cadastrados (exibindo também o saldo de multas).

    4. Realizar Locação: Associa um cliente a um item por meio de seus IDs. O sistema validará se o item está livre e se o cliente não possui pendências financeiras.

    5. Registrar Devolução: Permite encerrar uma locação ativa informando o número correspondente na lista de locações abertas. Se houver atraso, a multa será cobrada automaticamente.

    6. Listar Locações: Exibe o histórico de locações com os status "Em aberto" ou com as respectivas datas de entrega e multas aplicadas.

    0. Sair: Salva automaticamente todas as alterações feitas nas listas em seus respectivos arquivos de persistência .dat e encerra o programa com segurança.

💡 Guia de Teste Rápido (Demonstração de Multa para Correção)

Para validar o cálculo de multas de forma imediata sem precisar esperar dias reais:

    Inicie o programa e selecione a Opção 7 (Criar locação de teste). O sistema gerará automaticamente um cliente ("Wagner") e um filme com uma devolução já simulada em atraso.

    Acesse a Opção 5 (Registrar Devolução).

    Escolha a locação de teste criada. O sistema calculará instantaneamente o atraso e exibirá a aplicação da multa de R$ 2,00 por dia.

7. Desenvolvedores

    Marlon Dêam Dos Santos Nobre - Desenvolvedor Principal - MarlonDeam
