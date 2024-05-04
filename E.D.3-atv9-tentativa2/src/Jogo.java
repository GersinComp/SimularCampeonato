import java.util.ArrayList;
import java.util.Random;

public class Jogo {
    private Time timeDesafiado;
    private Time timeDesafiante;
    private String timeVencedor;
    private int golsTimeDesafiado;
    private int golsTimeDesafiante;

    public Jogo(Time timeDesafiado, Time timeDesafiante) {
        this.timeDesafiado = timeDesafiado;
        this.timeDesafiante = timeDesafiante;
        this.golsTimeDesafiado = 0;
        this.golsTimeDesafiante = 0;
    }

    private void gerarGols() {
        Random rand = new Random();
        this.golsTimeDesafiado = rand.nextInt(9);
        this.golsTimeDesafiante = rand.nextInt(9);
    }

    public String simularJogo() {
        gerarGols();
        if (this.golsTimeDesafiado > this.golsTimeDesafiante) {
            this.timeVencedor = "O time " + timeDesafiado.getNome() + " venceu a partida!";
            this.timeDesafiado.addPontos(3);
            this.timeDesafiado.addNumVitorias();
            this.timeDesafiante.addNumDerrotas();
        }
        else if (this.golsTimeDesafiado < this.golsTimeDesafiante) {
            this.timeVencedor = "O time " + timeDesafiante.getNome() + " venceu a partida!";
            this.timeDesafiante.addPontos(3);
            this.timeDesafiado.addNumDerrotas();
            this.timeDesafiante.addNumVitorias();
        }
        else {
            this.timeVencedor = "A partida terminou em empate!";
            this.timeDesafiado.addPontos(1);
            this.timeDesafiado.addNumEmpates();
            this.timeDesafiante.addPontos(1);
            this.timeDesafiante.addNumEmpates();
        }
        addResultados();
        return "Placar: " + this.timeDesafiado.getNome() + " " + this.golsTimeDesafiado + " x " +
                this.golsTimeDesafiante + " " + this.timeDesafiante.getNome() + "\n" + timeVencedor;
    }

    public void addResultados() {
        this.timeDesafiado.addTotalGolsMarcados(this.golsTimeDesafiado);
        this.timeDesafiado.addTotalGolsSofridos(golsTimeDesafiante);
        this.timeDesafiado.addTotalDeJogos();

        this.timeDesafiante.addTotalGolsMarcados(this.golsTimeDesafiante);
        this.timeDesafiante.addTotalGolsSofridos(golsTimeDesafiado);
        this.timeDesafiante.addTotalDeJogos();
    }
}
