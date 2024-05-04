# SimularCampeonato
### Atividade 9 E.D.3
Esse projeto foi desenvolvido para cumprir as seguintes tarefas:

## REQUISITOS FUNCIONAIS

• O programa deve apresentar ao usuário 3 opções de menu:
1 - Cadastrar Times
2 – Simular Jogos
3 – Sair

• Na opção 1 (Cadastrar Times), deve ser disponibilizado ao usuário fazer a entrada dos nomes dos times.

• Na opção 2 (Simular Jogos) o programa deve:
1. Permitir ao usuário deve escolher 2 times para um jogo;
2. Em seguida efetuar a simulação do jogo;
3. Apresentar na tela o resultado do jogo;
4. Imprimir a tabela de pontuação do campeonato atualizada.

• Na opção 3, o programa deve ser encerrado. 

## REGRAS DE NEGÓCIO E OUTROS DETALHES

1. O sistema deve limitar o cadastro de times até, no máximo, 10 times;

2. Para calcular a pontuação considere: Vitória = 3, Empate = 1 e Derrota = 0;

3. Para a simulação do jogo deve ser feito sorteados (aleatoriamente – pesquisar como gerar números aleatórios no Java) os gols marcados pelo time 1 e os gols marcados pelo time 2.

4. Um time A não pode enfrentar outro time B por mais de 1 vez;

a. Se o usuário repetir a dupla de times para um novo jogo o programa deve retornar a seguinte mensagem “Este jogo já foi realizado! Escolha outra dupla de times.”;

5. A tabela de pontuação do campeonato deve ser semelhante a tabela abaixo:
Nome do time | total de jogos | Vitoria | Empate | Derrota | Total de pontos | Gols Marcados | Gols sofridos | Saldo de gols |

6. Quando todos os times já tiverem se enfrentado e não houver mais a possibilidade de escolher um jogo, o programa deve apresentar o nome do(s) time(s) campeão(ões);

 O código possui relações entre 3 classes: Time, Jogo, Campeonato
 Ambas estão descritas no diagrama anexado nesse repositório!

 O código é responsável pelo cadastro das equipes bem como suas validações, a simulação dos jogos e também os controles necessários dos dados.
