import java.math.BigInteger;

// Exemplo de troca de chaves Diffie-Hellman entre Alice e Bob
public class Main {

    public static void main(String[] args) {
        // p: primo seguro de 128 bits (p = 2q + 1, com q primo)
        BigInteger p = new BigInteger("226425233357828483861120758858285110743");
        // g: menor raiz primitiva módulo p
        BigInteger g = BigInteger.valueOf(5);

        // valores secretos (cada um só conhece o seu)
        BigInteger a = new BigInteger("98765432109876543210987654321"); // Alice
        BigInteger b = new BigInteger("12345678901234567890123456789"); // Bob

        DiffieHellman dh = new DiffieHellman(p, g);

        // cada um calcula sua chave pública e envia para o outro
        BigInteger A = dh.chavePublica(a); // Alice envia A para Bob
        BigInteger B = dh.chavePublica(b); // Bob envia B para Alice

        // cada um calcula o segredo com o que recebeu
        BigInteger sAlice = dh.segredo(B, a); // B^a mod p
        BigInteger sBob = dh.segredo(A, b);   // A^b mod p

        System.out.println("=== Valores públicos ===");
        System.out.println("p = " + p + " (" + p.bitLength() + " bits)");
        System.out.println("g = " + g);

        System.out.println("\n=== Valores secretos ===");
        System.out.println("a (Alice) = " + a);
        System.out.println("b (Bob)   = " + b);

        System.out.println("\n=== Chaves públicas trocadas ===");
        System.out.println("A = g^a mod p = " + A);
        System.out.println("B = g^b mod p = " + B);

        System.out.println("\n=== Segredo compartilhado ===");
        System.out.println("s (Alice) = B^a mod p = " + sAlice);
        System.out.println("s (Bob)   = A^b mod p = " + sBob);

        // os dois tem que chegar no mesmo valor
        System.out.println(sAlice.equals(sBob)
                ? "\nSucesso, Alice e Bob têm o mesmo segredo!"
                : "\nErro, os segredos são diferentes!");
    }
}
