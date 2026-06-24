Documentação do Sistema de Locadora
1. Visão Geral do Sistema

O sistema consiste em uma aplicação de terminal em Java para o gerenciamento de uma locadora de itens multimídia (Filmes e Jogos). O software permite o cadastro de clientes, controle de inventário, fluxo de locação e devolução, além do cálculo automatizado de multas por atraso e persistência dos dados de forma local.
2. Arquitetura e Estrutura de Classes

O projeto foi desenvolvido aplicando os pilares da Programação Orientada a Objetos:
Interfaces e Classes Abstratas

    Locavel (Interface): Define o contrato de comportamento para qualquer item que possa ser alugado no sistema, exigindo os métodos getDetalhes(), isDisponivel() e setDisponivel().

    Item (Classe Abstrata): Implementa Locavel e serve como base para os produtos da locadora. Possui os atributos protegidos id, titulo e disponivel.

Classes de Domínio (Entidades)

    Filme (Herança de Item): Especializa um item com os atributos específicos diretor, genero e duracao.

    Jogo (Herança de Item): Especializa um item com os atributos específicos plataforma, genero e classeIndicativa.

    Cliente: Representa o usuário do sistema. Armazena dados pessoais (id, nome, cpf, telefone) e controla o saldo de multa pendente.

    Locacao: Gerencia a regra de negócio do empréstimo. Associa um Cliente a um Item e controla o fluxo de datas (dataRetirada, dataPrevista e dataEntrega) utilizando a API java.time.

3. Principais Regras de Negócio e Funcionalidades
Fluxo de Locação

    O sistema verifica se o cliente possui multas em aberto usando o método cliente.temPendencia(). Clientes com pendências são bloqueados de realizar novas locações.

    O sistema verifica a disponibilidade do item (item.isDisponivel()).

    Ao confirmar a locação, o status do item é alterado para indisponível (item.setDisponivel(false)).

Fluxo de Devolução e Cálculo de Multa

    A taxa de atraso é calculada de forma linear: R$ 2,00 por dia passado da data prevista de entrega.

    O cálculo é feito comparando as datas via ChronoUnit.DAYS.between(dataPrevista, dataEntrega).

    Ao registrar a devolução, se houver atraso, o valor gerado é somado diretamente à conta do cliente através do método cliente.adicionarMulta(valor). O item retorna ao status disponível.

4. Persistência de Dados

O sistema utiliza a Serialização do Java para salvar o estado da aplicação em arquivos binários locais. Isso garante que os dados não sejam perdidos ao fechar o programa.

    Todas as classes principais implementam a interface java.io.Serializable.

    Salvamento: Feito via ObjectOutputStream, gerando os arquivos clientes.dat, filmes.dat, jogos.dat e locacoes.dat na raiz do projeto.

    Carregamento: Feito via ObjectInputStream no início da execução da classe Main. Se os arquivos não existirem, o sistema inicia com listas vazias.
