# Exercício de OAuth 2.0 com Google

## Login com Google
Servidor em Express que faz login com a conta do Google usando OAuth 2.0 (fluxo Authorization Code):

1. Em `/` o servidor gera o link de login do Google, pedindo os escopos `email`, `profile` e `openid`.
2. O usuário faz login no Google e autoriza o app.
3. O Google redireciona para `/callback` com um `code`, que o servidor troca pelos tokens.
4. O servidor valida o `id_token` (confere a assinatura e se foi emitido para este app) e pega o nome e o e-mail.
5. Redireciona para `/welcome`, que mostra uma mensagem de boas-vindas.

## Arquivos
- `src/index.js`: servidor com as rotas `/`, `/callback` e `/welcome`.
- `process.env`: modelo das variáveis de ambiente (com valores de exemplo, sem as credenciais reais).
- `public/index.html`: página simples com o link de login.

## Requisitos
- Bun (ou Node.js 18+).
- Uma conta no Google Cloud.

## Configurando as credenciais

1. No [Google Cloud Console](https://console.cloud.google.com/apis/credentials), crie um **ID do cliente OAuth** do tipo **Aplicativo da Web**.
2. Em **URIs de redirecionamento autorizados**, adicione `http://localhost:3000/callback`.
3. Copie o arquivo `process.env` para `.env` e coloque o Client ID e o Client Secret reais:

   ```bash
   cp process.env .env
   ```

   O `.env` está no `.gitignore`, então as credenciais reais não vão para o repositório.

## Como executar

1. Abra o terminal na pasta `oAuth2/google-oauth-express`.
2. Instale as dependências:

   ```bash
   bun install
   ```

3. Execute:

   ```bash
   bun src/index.js
   ```

4. Acesse http://localhost:3000 e clique em "Login com Google".
