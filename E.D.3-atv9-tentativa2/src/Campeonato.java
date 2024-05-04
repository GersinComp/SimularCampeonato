import java.math.BigInteger;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Campeonato {
    private ArrayList<Time> times;
    private ArrayList<String> partidaDesafiado;
    private ArrayList<String> partidaDesafiante;
    private int numPartidasTotais;
    private int partidasRestantes;

    public Campeonato() {
        this.times = new ArrayList<>();
        this.partidaDesafiado = new ArrayList<>();
        this.partidaDesafiante = new ArrayList<>();
        this.numPartidasTotais = 0;
    }

    public int getPartidasRestantes() {
        return partidasRestantes;
    }

    public BigInteger calcularFatorial(int n) {
        BigInteger fatorial = BigInteger.ONE;
        for (int i = 1; i <= n; i++)
            fatorial = fatorial.multiply(BigInteger.valueOf(i));
        return fatorial;
    }

    public Integer jogosPossiveis() {
        int constantePares = 2;
        BigInteger quantidadeJogos = calcularFatorial(times.size()).divide(
                (calcularFatorial(constantePares)).multiply(calcularFatorial(times.size() - constantePares)));
        return quantidadeJogos.intValue();
    }

    public void contarJogosRealizados() {
        numPartidasTotais++;
        partidasRestantes = jogosPossiveis() - numPartidasTotais;
    }

    public Boolean verificarTimes(String nome) {
        return this.times.stream().noneMatch(time -> time.getNome().equals(nome));
    }

    public void cadastrarTime(String nome) throws Exception{
        if (this.times.size() >= 10)
            throw new Exception("Erro ao cadastrar novo time, número máximo de inscritos foi atingido!");
        else if (!verificarTimes(nome))
            throw new Exception("Erro ao cadastrar novo time, time já cadastrado!");
        else {
            this.times.add(new Time(nome));
        }
    }

    public String timesCadastrados() {
        return this.times.stream()
                .map(time -> (this.times.indexOf(time) + 1) + "- " + time.getNome() + "\n")
                .collect(Collectors.joining());
    }

    public void addJogoJaRealizado(Time timeDesafiado, Time timeDesafiante){
        partidaDesafiado.add(timeDesafiante.getNome());
        partidaDesafiante.add(timeDesafiado.getNome());
    }

    public Boolean jogoJaRealizado(int time1, int time2) {
        Boolean control = false; // Jogo ainda não realizado entre os times
        for (int i = 0; i < this.partidaDesafiado.size(); i++) {
            if ((this.partidaDesafiado.get(i).equals(this.times.get(time1).getNome()) && this.partidaDesafiante.get(i).equals(this.times.get(time2).getNome())) ||
                    (this.partidaDesafiado.get(i).equals(this.times.get(time2).getNome()) && this.partidaDesafiante.get(i).equals(this.times.get(time1).getNome()))) {
                control = true; // Jogo já realizado entre os times
            }
        }
        return control;
    }

    public String simularJogo(int indiceTime1, int indiceTime2) throws Exception{
        String resultado = "";
        if (indiceTime1 == indiceTime2)
            throw new Exception("Erro ao simular o jogo: Os times selecionados são iguais!");

        else if (this.jogoJaRealizado(indiceTime1, indiceTime2))
        throw new Exception("Erro ao simular o jogo: Os times já se enfrentaram!");

        else {
            Jogo jogo = new Jogo(this.times.get(indiceTime1), this.times.get(indiceTime2));
            resultado = jogo.simularJogo();
            this.addJogoJaRealizado(this.times.get(indiceTime1), this.times.get(indiceTime2));
            contarJogosRealizados();
        }
        return resultado;
    }

    public String imprimirTabela() {
        String tabela = "Tabela de Pontuação: \n";
        for (int i = 0; i < times.size(); i++)
            tabela += times.get(i).tabelaTime();
    return tabela + "\n Jogos restantes: " + (jogosPossiveis() - numPartidasTotais) + "\n";
    }

    public String imprimirCampeao() {
        ArrayList<String> campeoes = new ArrayList<>();
        String declararCampeao = "";
        int maiorNumPontos = 0;
        for (Time time: times)
            if (time.getPontos() > maiorNumPontos)
                maiorNumPontos = time.getPontos();

        for (Time time: times)
            if (time.getPontos() == maiorNumPontos) {
                campeoes.add(time.getNome());
            }
        if (campeoes.size() > 1) {
            declararCampeao += "Os campeões foram: ";
            declararCampeao += String.join(", ", campeoes);
            declararCampeao += ", com " + maiorNumPontos + " ponto(s)!";
        }
        else {
            declararCampeao += "O campeão foi: " + String.join(", ", campeoes);
            declararCampeao += ", com " + maiorNumPontos + " ponto(s)!";
        }
        return declararCampeao;
    }
}
