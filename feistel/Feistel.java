// Cifra de Feistel simples com blocos de 64 bits e 16 rodadas
// O bloco é dividido em duas metades de 32 bits (esquerda e direita)
public class Feistel {
    public static final int ROUNDS = 16;
    private final int[] roundKeys; // uma subchave para cada rodada

    public Feistel(int[] roundKeys) {
        if (roundKeys.length != ROUNDS) {
            throw new IllegalArgumentException("É necessário fornecer exatamente 16 chaves");
        }
        this.roundKeys = roundKeys;
    }

    // função de rodada: faz XOR com a subchave e rotaciona 3 bits para a esquerda
    // na rede de Feistel essa função não precisa ser inversível
    private int f(int right, int roundKey) {
        return Integer.rotateLeft(right ^ roundKey, 3);
    }

    public long encrypt(long block) {
        // separa o bloco em metade esquerda (32 bits de cima) e direita (32 de baixo)
        int left = (int) (block >>> 32);
        int right = (int) block;

        // em cada rodada: L = R antigo e R = L antigo XOR f(R antigo, chave)
        for (int i = 0; i < ROUNDS; i++) {
            int temp = right;
            right = left ^ f(right, roundKeys[i]);
            left = temp;
        }

        // junta as duas metades de volta em um bloco de 64 bits
        return (((long) left) << 32) | (right & 0xFFFFFFFFL);
    }

    // a decriptação faz as rodadas ao contrário, usando as chaves da última para a primeira
    public long decrypt(long block) {
        int left = (int) (block >>> 32);
        int right = (int) block;

        // desfaz uma rodada: R = L atual e L = R atual XOR f(L atual, chave)
        for (int i = ROUNDS - 1; i >= 0; i--) {
            int temp = left;
            left = right ^ f(left, roundKeys[i]);
            right = temp;
        }

        return (((long) left) << 32) | (right & 0xFFFFFFFFL);
    }
}
