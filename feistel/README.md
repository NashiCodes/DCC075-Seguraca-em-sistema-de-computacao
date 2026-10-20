# Exercício de Cifra de Feistel em Java

## Cifra de Feistel
Programa que implementa uma rede de Feistel simples com blocos de 64 bits e 16 rodadas. O bloco é dividido em duas metades de 32 bits e, em cada rodada, uma metade passa pela função `f` (XOR com a subchave e rotação de 3 bits) e o resultado é combinado com a outra metade por XOR. A decriptação usa a mesma estrutura, aplicando as subchaves na ordem inversa.

## Arquivos
- `Feistel.java`: implementação da cifra (função de rodada, encriptação e decriptação).
- `Main.java`: teste que encripta um bloco, decripta de volta e confere se o resultado é igual ao original.

## Requisitos
- Java JDK 25 ou superior (o `Main.java` usa o formato simplificado `void main()`).
- Terminal ou IDE Java.

## Como executar

1. Abra o terminal na pasta `feistel`.
2. Compile o programa:

   ```bash
   javac *.java
   ```

3. Execute:

   ```bash
   java Main
   ```

4. O programa mostra o texto original, o texto encriptado e o decriptado, e informa se o texto foi recuperado com sucesso.

## Uso de Inteligência Artificial
O ChatGPT foi utilizado como ferramenta de auxílio na criação dos comentários explicativos presentes nos códigos Java e na elaboração deste README.
