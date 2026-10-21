import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;

// Gera uma sequência de bits com o Blum Blum Shub e salva em bits.txt
// O conteúdo do arquivo pode ser colado no testador da suíte NIST:
// https://mzsoltmolnar.github.io/random-bitstream-tester/
public class Main {

    public static void main(String[] args) throws IOException {
        // p e q: primos maiores que 10000 e congruentes a 3 mod 4
        BigInteger p = BigInteger.valueOf(104723);
        BigInteger q = BigInteger.valueOf(104711);
        // s: semente, coprima com n = p * q
        BigInteger s = BigInteger.valueOf(31415926);

        // quantidade de bits (pode passar outro valor como argumento)
        int quantidade = args.length > 0 ? Integer.parseInt(args[0]) : 1_000_000;

        BlumBlumShub bbs = new BlumBlumShub(p, q, s);

        System.out.println("p = " + p + " (p mod 4 = " + p.mod(BigInteger.valueOf(4)) + ")");
        System.out.println("q = " + q + " (q mod 4 = " + q.mod(BigInteger.valueOf(4)) + ")");
        System.out.println("n = p * q = " + bbs.getN());
        System.out.println("s = " + s + " (mdc(s, n) = " + s.gcd(bbs.getN()) + ")");

        StringBuilder bits = new StringBuilder(quantidade);
        int uns = 0;
        for (int i = 0; i < quantidade; i++) {
            int bit = bbs.proximoBit();
            bits.append(bit);
            uns += bit;
        }

        Files.writeString(Path.of("bits.txt"), bits);

        System.out.println("\nBits gerados: " + quantidade);
        System.out.println("Primeiros 64 bits: " + bits.substring(0, Math.min(64, quantidade)));
        // conferência rápida: numa sequência aleatória, cerca de metade dos bits é 1
        System.out.printf("Proporção de 1s: %.4f%n", (double) uns / quantidade);
        System.out.println("Sequência salva em bits.txt");
    }
}
