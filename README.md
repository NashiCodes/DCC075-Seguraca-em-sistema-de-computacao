# DCC075 - Segurança em Sistemas de Computação

Atividades práticas da disciplina DCC075 (UFJF). Cada pasta tem o seu próprio README explicando o exercício e como executar.

## Atividades

| Pasta | Atividade | Linguagem |
|---|---|---|
| [`cesar`](cesar/) | Cifra de César e criptoanálise por frequência | Java |
| [`feistel`](feistel/) | Cifra de Feistel com 16 rodadas | Java |
| [`AES`](AES/) | AES-128: confusão, difusão e efeito avalanche (com relatório) | Python |
| [`Blocos`](Blocos/) | Modos de operação (ECB, CBC, CFB, OFB, CTR) com OpenSSL na imagem do Tux + texto sobre o Sweet32 | OpenSSL |
| [`blum-blum-shub`](blum-blum-shub/) | Gerador Blum Blum Shub e teste na suíte NIST | Java |
| [`diffie-hellman`](diffie-hellman/) | Troca de chaves Diffie-Hellman | Java |
| [`hash`](hash/) | SHA-256 passo a passo, algoritmos de hash atuais e hash simples com XOR | Java |
| [`RBAC`](RBAC/) | Controle de acesso baseado em papéis em um sistema acadêmico | Java |
| [`oAuth2`](oAuth2/) | Login com Google usando OAuth 2.0 | JavaScript (Express) |

## Requisitos gerais
- Java JDK 25 ou superior (o `feistel` usa `void main()`; os outros rodam em versões mais antigas).
- Python 3.9 ou superior (`AES`).
- OpenSSL e ImageMagick (`Blocos`).
- Bun ou Node.js (`oAuth2`).

## Como executar
Os exercícios em Java seguem o mesmo padrão. Dentro da pasta do exercício:

```bash
javac *.java
java Main
```

No `cesar` e no `RBAC` os comandos mudam um pouco; confira o README de cada pasta.
