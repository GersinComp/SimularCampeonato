public class Time {
    private String nome;
    private Integer pontos;
    private Integer totalDeJogos;
    private Integer numVitorias;
    private Integer numDerrotas;
    private Integer numEmpates;
    private Integer totalGolsMarcados;
    private Integer totalGolsSofridos;

    public Time(String nome) {
        this.nome = nome;
        this.pontos = 0;
        this.totalDeJogos = 0;
        this.numVitorias = 0;
        this.numDerrotas = 0;
        this.numEmpates = 0;
        this.totalGolsMarcados = 0;
        this.totalGolsSofridos = 0;
    }

    public String getNome() {
        return nome;
    }

    public void addPontos(Integer pontos) {
        this.pontos += pontos;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void addTotalDeJogos() {
        this.totalDeJogos ++;
    }

    public void addNumVitorias() {
        this.numVitorias ++;
    }

    public void addNumDerrotas() {
        this.numDerrotas ++;
    }

    public void addNumEmpates() {
        this.numEmpates ++;
    }

    public void addTotalGolsMarcados(Integer totalGolsMarcados) {
        this.totalGolsMarcados += totalGolsMarcados;
    }

    public void addTotalGolsSofridos(Integer totalGolsSofridos) {
        this.totalGolsSofridos += totalGolsSofridos;
    }

    public Integer getSaldoGols() {
        return totalGolsMarcados - totalGolsSofridos;
    }

    public String tabelaTime() {
        String imprimir = "-----------------------------------------------------------------------------------------------------------------------------------------------";
        imprimir += "-----------------------------------------------------------------------------------------------------------------------------------------------\n";
        imprimir += "Time: " + nome + "\t | \t ";
        imprimir += "Total de jogos: " + totalDeJogos + "\t | \t ";
        imprimir += "Total de pontos: " + pontos + "\t | \t ";

        imprimir += "Total de vitorias: " + numVitorias + "\t | \t ";
        imprimir += "Total de empates: " + numEmpates + "\t | \t ";
        imprimir += "Total de derrotas: " + numDerrotas + "\t | \t ";

        imprimir += "Total de gols marcados: " + totalGolsMarcados + "\t | \t ";
        imprimir += "Total de gols sofridos: " + totalGolsSofridos + "\t | \t ";
        imprimir += "Saldo gols: " + getSaldoGols() + "\n";
        return imprimir;
    }
}
