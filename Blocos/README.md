# Prática de Modos de Operação em Cifras de Bloco

## Modos de operação com OpenSSL
Prática seguindo o tutorial do professor: geração de uma chave AES-128 com PBKDF2, cifragem de um texto em ECB e cifragem da imagem do Tux em ECB (Prática 1), CBC (Prática 2) e nos modos CFB, OFB e CTR. No ECB o Tux continua visível; nos outros modos a imagem vira ruído.

## Arquivos
- `João Victor Pereira - Modos de Operacao.pdf`: prints dos comandos executados com as saídas, imagens geradas e explicação dos resultados.
- `João Victor Pereira - Sweet32.pdf`: texto sobre o ataque Sweet32.
- `print-*.png`: prints do terminal de cada etapa.
- `key.priv`, `iv.txt`: chave e IV usados.
- `cleartext.txt`, `ciphertext.txt`: texto original e cifrado.
- `Tux.png`, `tux.ppm`, `header.txt`, `body.bin`: imagem original e suas partes.
- `body.*.enc`, `tux-*-enc.ppm`: corpo cifrado e imagem cifrada em cada modo.

## Requisitos
- OpenSSL.
- ImageMagick (`convert`).
- `wget`.

## Como executar
Os comandos estão no tutorial e nos prints do PDF, na ordem em que foram executados, dentro da pasta `Blocos`.

## Uso de Inteligência Artificial
O ChatGPT foi utilizado como ferramenta de auxílio na execução da prática, na explicação dos resultados, no texto sobre o Sweet32 e na elaboração deste README.
