# Prática AES: confusão, difusão e efeito avalanche

## AES-128
O arquivo `aluno.py` já vinha com o núcleo do AES-128 pronto (validado com o vetor de teste do FIPS-197) e com a Parte 1 resolvida. Foram completadas as Partes 2 e 3, que medem o efeito avalanche variando o número de rodadas e desligando o MixColumns.

- **Parte 1 (já pronta):** inverte 1 bit do texto ou da chave e mede quantos bits do ciphertext mudam.
- **Parte 2:** repete a medição da Parte 1 com 1 a 10 rodadas.
- **Parte 3:** repete a Parte 2 com `use_mixcolumns=False`, para 2, 4, 6 e 10 rodadas.

## Requisitos
- Python 3.9 ou superior (só a biblioteca padrão).

## Como executar

1. Abra o terminal na pasta `AES`.
2. Execute:

   ```bash
   python3 aluno.py
   ```

3. O programa valida o AES com o FIPS-197 e imprime os resultados das três partes.

## Relatório
Os resultados obtidos e o relatório (parágrafo técnico e parágrafo crítico) estão no arquivo `João Victor Pereira - Relatorio AES.docx`.

## Uso de Inteligência Artificial
O ChatGPT foi utilizado como ferramenta de auxílio na implementação das Partes 2 e 3, na criação dos comentários, na elaboração deste README e do relatório.
