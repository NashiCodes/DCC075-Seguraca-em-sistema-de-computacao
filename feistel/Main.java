// Teste da cifra de Feistel: encripta um bloco e depois decripta para ver se volta igual
void main() {
    // 16 subchaves de 32 bits, uma para cada rodada
    int[] keys = {
            0x1A2B3C4D,
            0x2B3C4D5E,
            0x3C4D5E6F,
            0x4D5E6F70,
            0x5E6F7081,
            0x6F708192,
            0x708192A3,
            0x8192A3B4,
            0x92A3B4C5,
            0xA3B4C5D6,
            0xB4C5D6E7,
            0xC5D6E7F8,
            0xD6E7F809,
            0xE7F8091A,
            0xF8091A2B,
            0x091A2B3C
    };

    var cipher = new Feistel(keys);

    // bloco de 64 bits que vai ser encriptado
    long plaintext = 0x123456789ABCDEFL;

    System.out.printf("Texto original: %016X%n", plaintext);

    var encrypted = cipher.encrypt(plaintext);

    System.out.printf("Texto encriptado: %016X%n", encrypted);

    var decrypted = cipher.decrypt(encrypted);

    System.out.printf("Decriptado: %016X%n", decrypted);

    // se o decriptado for igual ao original, a cifra funcionou
    System.out.printf(
            decrypted == plaintext
                    ? "Sucesso, Texto recuperado!"
                    : "Erro na decriptação!");
}
