import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Campeonato campeonato = new Campeonato();
        boolean control = true;


        while (control) {
            int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a opção desejada conforme o menu: \n" +
                    "1- Cadastrar time \n" +
                    "2- Simular jogos \n" +
                    "3- Sair \n"));
            switch (opcao) {
                case 1:
                    String nomeTime = JOptionPane.showInputDialog(null, "Digite o nome do time: ");
                    try {
                        campeonato.cadastrarTime(nomeTime);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
                case 2:
                    int indiceTime1 = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Escolha o 1º time para o jogo (digite os números correspondentes):\n" +
                                    campeonato.timesCadastrados()));
                    indiceTime1 -= 1;
                    int indiceTime2 = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Escolha o 2º time para o jogo (digite os números correspondentes):\n" +
                                    campeonato.timesCadastrados()));
                    indiceTime2 -= 1;
                    try {
                        String resultado = campeonato.simularJogo(indiceTime1, indiceTime2);
                        JOptionPane.showMessageDialog(null, resultado);
                        JOptionPane.showMessageDialog(null, campeonato.imprimirTabela());
                        if (campeonato.getPartidasRestantes() == 0) {
                            JOptionPane.showMessageDialog(null, "Fim do campeonato!");
                            JOptionPane.showMessageDialog(null, campeonato.imprimirCampeao());
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
                case 3:
                    control = false;
                    JOptionPane.showMessageDialog(null, campeonato.imprimirCampeao());
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! " + opcao + " não é uma das opções.");
                    break;
            }
        }
    }
}