# Exercício de Diffie-Hellman em Java

## Diffie-Hellman
Programa que simula a troca de chaves Diffie-Hellman entre Alice e Bob. Os dois combinam publicamente um primo `p` e uma raiz primitiva `g`. Cada um escolhe um valor secreto (`a` e `b`), envia `g^secreto mod p` para o outro (`A` e `B`) e, com o que recebeu, calcula o segredo compartilhado `s`. Os dois chegam no mesmo `s` sem nunca enviar `a` ou `b`.

## Valores escolhidos

| Variável | Valor | Observação |
|---|---|---|
| p | 226425233357828483861120758858285110743 | primo seguro de 128 bits (p = 2q + 1, com q primo) |
| g | 5 | menor raiz primitiva módulo p |
| a | 98765432109876543210987654321 | secreto da Alice |
| b | 12345678901234567890123456789 | secreto do Bob |

## Valores calculados

| Variável | Fórmula | Valor |
|---|---|---|
| A | g^a mod p | 67569921112707774261803377017960801154 |
| B | g^b mod p | 173260473908542504785148450166820774328 |
| s (Alice) | B^a mod p | 97008488320888351235713224812107328247 |
| s (Bob) | A^b mod p | 97008488320888351235713224812107328247 |

## Por que g é raiz primitiva
Como `p` é um primo seguro (`p = 2q + 1`, com `q` primo), a ordem de qualquer `g` só pode ser 1, 2, q ou 2q. Então `g` é raiz primitiva quando `g² mod p ≠ 1` e `g^q mod p ≠ 1`. O programa faz essa verificação antes de começar. Também dá para conferir no WolframAlpha com `primitiveroot 226425233357828483861120758858285110743`.

## Arquivos
- `DiffieHellman.java`: cálculo das chaves públicas, do segredo e verificação da raiz primitiva.
- `Main.java`: exemplo da troca entre Alice e Bob com os valores acima.

## Requisitos
- Java JDK 11 ou superior.
- Terminal ou IDE Java.

## Como executar

1. Abra o terminal na pasta `diffie-hellman`.
2. Compile o programa:

   ```bash
   javac *.java
   ```

3. Execute:

   ```bash
   java Main
   ```

4. O programa mostra os valores públicos, os secretos, as chaves trocadas (A e B) e o segredo calculado por cada lado.

## Uso de Inteligência Artificial
O ChatGPT foi utilizado como ferramenta de auxílio na implementação do código, na criação dos comentários explicativos e na elaboração deste README.
