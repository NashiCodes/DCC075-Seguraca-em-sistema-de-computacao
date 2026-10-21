// Testa os dois hashes simples e mostra o problema do XOR puro
public class Main {

    private static void mostrar(String texto) {
        System.out.printf("%-14s XOR: %08x   XOR+rotação: %08x%n",
                "\"" + texto + "\"", HashSimples.hashXor(texto), HashSimples.hashXorRotacao(texto));
    }

    public static void main(String[] args) {
        mostrar("ola mundo");
        mostrar("ola mundO"); // muda só uma letra

        // "abcdefgh" e "efghabcd" têm os mesmos blocos em ordem trocada
        // no XOR puro dá o mesmo hash (colisão), com rotação não
        System.out.println("\nTrocando a ordem dos blocos:");
        mostrar("abcdefgh");
        mostrar("efghabcd");

        // no XOR puro, repetir o mesmo bloco duas vezes zera ele (x ^ x = 0)
        System.out.println("\nBloco repetido:");
        mostrar("abcdabcd");
        mostrar("");
    }
}
