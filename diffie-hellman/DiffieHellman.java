import java.math.BigInteger;

// Funções do Diffie-Hellman
// Cada lado escolhe um número secreto, calcula g^secreto mod p e envia o resultado
// Depois cada um eleva o valor recebido ao seu secreto e os dois chegam no mesmo s
public class DiffieHellman {

    private static final BigInteger DOIS = BigInteger.TWO;

    private final BigInteger p;
    private final BigInteger g;

    public DiffieHellman(BigInteger p, BigInteger g) {
        if (!p.isProbablePrime(50)) {
            throw new IllegalArgumentException("p não é primo");
        }
        if (!ehRaizPrimitiva(g, p)) {
            throw new IllegalArgumentException("g não é raiz primitiva módulo p");
        }
        this.p = p;
        this.g = g;
    }

    // chave pública: g^secreto mod p (é o A ou o B)
    public BigInteger chavePublica(BigInteger secreto) {
        return g.modPow(secreto, p);
    }

    // segredo compartilhado: (chave pública do outro)^secreto mod p
    public BigInteger segredo(BigInteger publicaDoOutro, BigInteger secreto) {
        return publicaDoOutro.modPow(secreto, p);
    }

    // Verifica se g é raiz primitiva módulo p
    // Como p é um primo seguro (p = 2q + 1, com q primo), a ordem de g só pode ser 1, 2, q ou 2q.
    // Então g é raiz primitiva se g^2 != 1 e g^q != 1 (mod p)
    public static boolean ehRaizPrimitiva(BigInteger g, BigInteger p) {
        BigInteger q = p.subtract(BigInteger.ONE).divide(DOIS);
        if (!q.isProbablePrime(50)) {
            throw new IllegalArgumentException("p precisa ser um primo seguro (p = 2q + 1)");
        }
        return !g.modPow(DOIS, p).equals(BigInteger.ONE)
                && !g.modPow(q, p).equals(BigInteger.ONE);
    }

    public BigInteger getP() {
        return p;
    }

    public BigInteger getG() {
        return g;
    }
}
