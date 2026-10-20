
import java.util.Scanner;

public class Criptoanalise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Solicita o texto que sera analisado
        System.out.print("Digite o texto criptografado: ");
        String texto = sc.nextLine().toUpperCase();

        // Cria um vetor com 26 posicoes, uma para cada letra
        // A posicao 0 representa A, a 1 representa B, etc.
        int[] frequencia = new int[26];

        // Armazena a quantidade total de letras do texto
        int total = 0;

        // Percorre todos os caracteres do texto
        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);

            // Conta somente letras de A ate Z
            if (letra >= 'A' && letra <= 'Z') {

                // Incrementa a contagem da letra encontrada
                frequencia[letra - 'A']++;

                // Incrementa o total de letras
                total++;
            }
        }

        // Percorre o vetor para mostrar a frequencia
        for (int i = 0; i < 26; i++) {

            // Exibe somente as letras que aparecem no texto
            if (frequencia[i] > 0) {

                // Calcula a porcentagem de ocorrencia da letra
                double porcentagem =
                        frequencia[i] * 100.0 / total;

                // Exibe a letra, sua quantidade e sua porcentagem
                System.out.printf(
                        "%c: %d vezes (%.2f%%)%n",
                        (char) ('A' + i),
                        frequencia[i],
                        porcentagem
                );
            }
        }

        // Fecha o Scanner
        sc.close();
    }
}
