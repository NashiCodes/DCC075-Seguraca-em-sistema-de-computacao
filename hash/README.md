# Exercício de Hash em Java

## Hash simples com XOR
Programa com dois hashes simples de 32 bits, feitos só para estudo:

1. **XOR bloco a bloco:** divide a mensagem em blocos de 4 bytes e faz XOR de todos.
2. **XOR com rotação:** antes de cada XOR rotaciona o hash 5 bits para a esquerda, e no final mistura o tamanho da mensagem.

O `Main` mostra as fraquezas: no XOR puro, trocar a ordem dos blocos dá o mesmo hash e um bloco repetido se anula. Com a rotação esses casos param de colidir, mas mudar uma letra ainda muda só 1 bit do hash.

## Arquivos
- `HashSimples.java`: os dois hashes.
- `Main.java`: testes com algumas mensagens.
- `João Victor Pereira - Hash.pdf`: SHA-256 passo a passo, texto sobre os principais algoritmos de hash e a saída do programa.

## Requisitos
- Java JDK instalado.
- Terminal ou IDE Java.

## Como executar

1. Abra o terminal na pasta `hash`.
2. Compile o programa:

   ```bash
   javac *.java
   ```

3. Execute:

   ```bash
   java Main
   ```

## Uso de Inteligência Artificial
O Claude (Anthropic) foi utilizado como ferramenta de auxílio na implementação do código, na criação dos comentários, nos textos do PDF e na elaboração deste README.
