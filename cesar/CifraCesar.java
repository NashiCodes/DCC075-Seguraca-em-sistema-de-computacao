
import java.util.Scanner;

public class CifraCesar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Solicita a mensagem que sera criptografada
        System.out.print("Digite uma mensagem: ");
        String texto = sc.nextLine().toUpperCase();

        // Solicita a chave de deslocamento (de 1 a 25)
        System.out.print("Digite a chave (1 a 25): ");
        int chave = sc.nextInt();

        // Variavel que armazenara a mensagem criptografada
        String resultado = "";

        // Percorre cada caractere da mensagem
        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);

            // Verifica se o caractere e uma letra de A ate Z
            if (letra >= 'A' && letra <= 'Z') {

                // Desloca a letra conforme a chave informada
                // O % 26 permite voltar ao inicio do alfabeto
                letra = (char) ('A' +
                        (letra - 'A' + chave) % 26);
            }

            // Adiciona a letra ou caractere ao resultado
            // Espacos e outros caracteres sao mantidos
            resultado += letra;
        }

        // Exibe a mensagem criptografada
        System.out.println("Mensagem criptografada: " + resultado);

        // Fecha o Scanner
        sc.close();
    }
}
