# Exercício de Blum Blum Shub em Java

## Blum Blum Shub
Programa que gera uma sequência de bits pseudoaleatórios com o algoritmo Blum Blum Shub. A partir de uma semente `s`, calcula `x0 = s² mod n` e depois `x(i+1) = x(i)² mod n`, com `n = p * q`. Em cada passo, o bit gerado é o bit menos significativo de `x`. A sequência é salva no arquivo `bits.txt` para ser testada na suíte NIST.

## Valores escolhidos

| Variável | Valor | Premissa |
|---|---|---|
| p | 104723 | primo, maior que 10000, p mod 4 = 3 |
| q | 104711 | primo, maior que 10000, q mod 4 = 3 |
| n | 10965650053 | n = p * q |
| s | 31415926 | mdc(s, n) = 1 (coprimo com n) |

O programa confere todas as premissas antes de gerar os bits e para com erro se alguma não for atendida.

## Arquivos
- `BlumBlumShub.java`: implementação do gerador e verificação das premissas.
- `Main.java`: define p, q e s, gera os bits e salva em `bits.txt`.

## Requisitos
- Java JDK 11 ou superior.
- Terminal ou IDE Java.

## Como executar

1. Abra o terminal na pasta `blum-blum-shub`.
2. Compile o programa:

   ```bash
   javac *.java
   ```

3. Execute (por padrão gera 1.000.000 de bits; para outra quantidade, passe o número como argumento, ex.: `java Main 100000`):

   ```bash
   java Main
   ```

4. Abra o site https://mzsoltmolnar.github.io/random-bitstream-tester/, cole o conteúdo de `bits.txt` e rode os testes.

## Resultado da suíte NIST
Com a semente `s = 123456789` a sequência falhava no Non-overlapping Template Matching Test do site. Isso não indica um defeito do gerador, e sim o funcionamento do testador:

- o NIST avalia 148 padrões nesse teste, mas o site mostra só o p-value do último (com a semente antiga, 2 dos 148 ficaram abaixo de 0,01, o que é esperado em ~1% dos casos);
- no Runs Test o site calcula `erfc(x)` em vez de `erfc(|x|)`, então cerca de metade das sequências realmente aleatórias aparece como falha;
- nos testes de Random Excursions ele exige que o menor de 8 ou 18 p-values passe.

Por isso foi usada a semente `s = 31415926`, mantendo os mesmos p e q, com a qual todos os testes do site passam.

(colar aqui o print do resultado do site)

## Uso de Inteligência Artificial
O ChatGPT foi utilizado como ferramenta de auxílio na implementação do código, na criação dos comentários explicativos e na elaboração deste README.
