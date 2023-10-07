import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String[] palavras = {
                "FLASH", "BATMAN", "CORINGA", "SUPERMAN", "ANABELLE", "CHUCK", "VINGADORES", "UNCHARTED", "FREIRA"
        };

        Forca_A jogo = new Forca_A();
        JOptionPane.showMessageDialog(null, "Bem-vindo ao jogo da forca \nO tema é Filmes");

        boolean y = true;
        while (y) {
            int indice = jogo.palavra();
            StringBuilder tentativa = new StringBuilder();
            for (int i = 0; i < palavras[indice].length(); i++) {
                tentativa.append("_");
            }

            int tentativasRestantes = 6;

            while (tentativasRestantes > 0) {
                String letra = JOptionPane.showInputDialog("Digite uma letra desejada:").toUpperCase();

                if (letra.length() != 1 || !Character.isLetter(letra.charAt(0))) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira uma letra válida.");
                    continue;
                }

                char letra2 = letra.charAt(0);
                boolean letraEncontrada = false;

                for (int i = 0; i < palavras[indice].length(); i++) {
                    if (palavras[indice].charAt(i) == letra2) {
                        tentativa.setCharAt(i, letra2);
                        letraEncontrada = true;
                    }
                }

                if (!letraEncontrada) {
                    tentativasRestantes--;
                }

                JOptionPane.showMessageDialog(null, tentativa);
                if (tentativa.indexOf("_") == -1) {
                    JOptionPane.showMessageDialog(null, "Parabéns, você ganhou! Levou " + (6 - tentativasRestantes) + " tentativas.");
                    break;
                }
            }

            if (tentativasRestantes == 0) {
                JOptionPane.showMessageDialog(null, "Infelizmente, você perdeu. A palavra era: " + palavras[indice]);
            }

            int escolha = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?", "Reiniciar", JOptionPane.YES_NO_OPTION);
            if (escolha != JOptionPane.YES_OPTION) {
                y = false;
            }
        }
    }

}
