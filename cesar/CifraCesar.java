
import java.util.Scanner;

public class CifraCesar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite uma mensagem: ");
        String texto = sc.nextLine().toUpperCase();

        System.out.print("Digite a chave (1 a 25): ");
        int chave = sc.nextInt();

        String resultado = "";

        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);

            if (letra >= 'A' && letra <= 'Z') {
                letra = (char) ('A' +
                        (letra - 'A' + chave) % 26);
            }

            resultado += letra;
        }

        System.out.println("Mensagem criptografada: " + resultado);

        sc.close();
    }
}
