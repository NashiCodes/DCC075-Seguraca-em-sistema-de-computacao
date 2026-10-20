# Exercício de RBAC em Java

## RBAC (Controle de Acesso Baseado em Papéis)
Programa que simula um sistema acadêmico (parecido com o SIGA) onde cada usuário recebe papéis, e cada papel dá um conjunto de permissões. Antes de qualquer operação o sistema verifica se algum papel do usuário tem a permissão necessária; se nenhum tiver, o acesso é negado.

## Papéis

| Papel | Permissões |
|---|---|
| ALUNO | ver as próprias notas, fazer matrícula |
| PROFESSOR | ver as notas de qualquer aluno, lançar nota |
| COORDENADOR | tudo do PROFESSOR (herança) + aprovar matrícula, criar disciplina |
| ADMINISTRADOR | gerenciar usuários, dar e tirar papéis |

## Arquivos
- `Permissao.java`: lista de permissões do sistema.
- `Papel.java`: papéis e as permissões de cada um.
- `Usuario.java`: usuário e os papéis que ele possui.
- `ControleDeAcesso.java`: verifica se o usuário pode ou não fazer uma operação.
- `AcessoNegadoException.java`: erro lançado quando o acesso é negado.
- `SistemaAcademico.java`: operações do sistema (matrícula, notas, disciplinas, usuários).
- `Main.java`: testes mostrando acessos permitidos e negados.

## Requisitos
- Java JDK instalado.
- Terminal ou IDE Java.

## Como executar

1. Abra o terminal na pasta `RBAC`.
2. Compile o programa:

   ```bash
   javac -d out *.java
   ```

3. Execute:

   ```bash
   java -cp out Main
   ```

4. O programa mostra cada operação como `[PERMITIDO]` ou `[NEGADO]`, com o motivo quando for negado.

## Uso de Inteligência Artificial
O ChatGPT foi utilizado como ferramenta de auxílio na implementação do código, na criação dos comentários explicativos e na elaboração deste README.
