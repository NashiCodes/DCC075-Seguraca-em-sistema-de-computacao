import java.math.BigInteger;

// Gerador de bits pseudoaleatórios Blum Blum Shub
// x(i+1) = x(i)^2 mod n, com n = p * q, e o bit gerado é o bit menos significativo de x
public class BlumBlumShub {

    private static final BigInteger QUATRO = BigInteger.valueOf(4);
    private static final BigInteger TRES = BigInteger.valueOf(3);

    private final BigInteger n;
    private BigInteger x; // estado atual

    public BlumBlumShub(BigInteger p, BigInteger q, BigInteger s) {
        // premissas do algoritmo: p e q primos e os dois congruentes a 3 mod 4
        verificarPrimo(p, "p");
        verificarPrimo(q, "q");
        if (p.equals(q)) {
            throw new IllegalArgumentException("p e q devem ser diferentes");
        }

        this.n = p.multiply(q);

        // a semente s tem que ser coprima com n e diferente de 0 e 1
        if (s.compareTo(BigInteger.ONE) <= 0 || s.compareTo(n) >= 0) {
            throw new IllegalArgumentException("s deve estar entre 1 e n");
        }
        if (!s.gcd(n).equals(BigInteger.ONE)) {
            throw new IllegalArgumentException("s deve ser coprimo com n");
        }

        // estado inicial: x0 = s^2 mod n
        this.x = s.multiply(s).mod(n);
    }

    private static void verificarPrimo(BigInteger numero, String nome) {
        if (!numero.isProbablePrime(50)) {
            throw new IllegalArgumentException(nome + " não é primo");
        }
        if (!numero.mod(QUATRO).equals(TRES)) {
            throw new IllegalArgumentException(nome + " deve ser congruente a 3 mod 4");
        }
    }

    // calcula o próximo x e devolve o bit menos significativo dele
    public int proximoBit() {
        x = x.multiply(x).mod(n);
        return x.testBit(0) ? 1 : 0;
    }

    public BigInteger getN() {
        return n;
    }
}
