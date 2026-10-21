import java.nio.charset.StandardCharsets;

// Dois hashes bem simples de 32 bits, só para estudo (não são seguros)
public class HashSimples {

    // junta 4 bytes da mensagem a partir da posição i em um bloco de 32 bits
    // se faltar byte no final, completa com 0
    private static int bloco(byte[] dados, int i) {
        int b = 0;
        for (int j = 0; j < 4; j++) {
            b <<= 8;
            if (i + j < dados.length) {
                b |= dados[i + j] & 0xFF;
            }
        }
        return b;
    }

    // Hash 1: só faz XOR de todos os blocos
    public static int hashXor(String texto) {
        byte[] dados = texto.getBytes(StandardCharsets.UTF_8);
        int h = 0;
        for (int i = 0; i < dados.length; i += 4) {
            h ^= bloco(dados, i);
        }
        return h;
    }

    // Hash 2: antes de cada XOR rotaciona o hash 5 bits pra esquerda
    // assim a posição do bloco passa a importar
    public static int hashXorRotacao(String texto) {
        byte[] dados = texto.getBytes(StandardCharsets.UTF_8);
        int h = 0x12345678; // valor inicial qualquer
        for (int i = 0; i < dados.length; i += 4) {
            h = Integer.rotateLeft(h, 5) ^ bloco(dados, i);
        }
        // mistura o tamanho no final, senão "a" e "a\0" dariam o mesmo hash
        h = Integer.rotateLeft(h, 5) ^ dados.length;
        return h;
    }
}
