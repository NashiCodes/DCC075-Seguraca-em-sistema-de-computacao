// Testes do RBAC no sistema acadêmico
// Papéis: ALUNO, PROFESSOR, COORDENADOR e ADMINISTRADOR
//
// Para rodar (dentro da pasta RBAC):
//   javac -d out *.java
//   java -cp out Main
public class Main {

    // roda a operação e mostra se foi permitida ou negada
    private static void tentar(String descricao, Runnable operacao) {
        try {
            operacao.run();
            System.out.println("[PERMITIDO] " + descricao);
        } catch (AcessoNegadoException e) {
            System.out.println("[NEGADO]    " + descricao + "\n            -> " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SistemaAcademico siga = new SistemaAcademico();
        ControleDeAcesso acesso = siga.getControleDeAcesso();

        // criando os usuários
        Usuario admin = new Usuario("admin", "Ana (TI)", Papel.ADMINISTRADOR);
        Usuario coord = new Usuario("carlos", "Carlos", Papel.COORDENADOR);
        Usuario prof = new Usuario("paula", "Paula", Papel.PROFESSOR);
        Usuario aluno = new Usuario("joao", "João", Papel.ALUNO);
        Usuario colega = new Usuario("maria", "Maria", Papel.ALUNO);

        System.out.println("=== Papéis e permissões ===");
        for (Papel p : Papel.values()) {
            System.out.println(p + " -> " + p.getPermissoes());
        }

        System.out.println("\n=== Administração ===");
        tentar("admin cadastra o aluno joao", () -> siga.cadastrarUsuario(admin, aluno));
        tentar("professora paula tenta cadastrar usuário", () -> siga.cadastrarUsuario(prof, colega));
        tentar("aluno joao tenta se promover a ADMINISTRADOR",
                () -> acesso.atribuirPapel(aluno, aluno, Papel.ADMINISTRADOR));

        System.out.println("\n=== Gestão acadêmica ===");
        tentar("coordenador cria a disciplina DCC075", () -> siga.criarDisciplina(coord, "DCC075"));
        tentar("professora tenta criar disciplina", () -> siga.criarDisciplina(prof, "DCC999"));
        tentar("admin tenta criar disciplina", () -> siga.criarDisciplina(admin, "DCC998"));

        System.out.println("\n=== Matrícula ===");
        tentar("aluno joao solicita matrícula em DCC075", () -> siga.solicitarMatricula(aluno, "DCC075"));
        tentar("professora tenta aprovar a matrícula",
                () -> siga.aprovarMatricula(prof, "joao", "DCC075"));
        tentar("coordenador aprova a matrícula", () -> siga.aprovarMatricula(coord, "joao", "DCC075"));
        System.out.println("            matrículas aprovadas: " + siga.getMatriculasAprovadas());

        System.out.println("\n=== Notas ===");
        tentar("professora lança nota 8.5 para joao", () -> siga.lancarNota(prof, "joao", "DCC075", 8.5));
        // coordenador consegue porque herda do professor
        tentar("coordenador lança nota para maria", () -> siga.lancarNota(coord, "maria", "DCC075", 7.0));
        tentar("aluno joao tenta mudar a própria nota para 10",
                () -> siga.lancarNota(aluno, "joao", "DCC075", 10));
        tentar("aluno joao vê as próprias notas",
                () -> System.out.println("            notas de joao: " + siga.verNotas(aluno, "joao")));
        tentar("aluno joao tenta ver as notas de maria", () -> siga.verNotas(aluno, "maria"));
        tentar("professora vê as notas de maria", () -> siga.verNotas(prof, "maria"));

        System.out.println("\n=== Mudando papéis ===");
        // joao vira monitor e ganha o papel de professor
        tentar("admin dá o papel PROFESSOR para joao", () -> acesso.atribuirPapel(admin, aluno, Papel.PROFESSOR));
        System.out.println("            " + aluno);
        tentar("joao agora consegue ver as notas de maria", () -> siga.verNotas(aluno, "maria"));
        tentar("admin tira o papel PROFESSOR de joao", () -> acesso.revogarPapel(admin, aluno, Papel.PROFESSOR));
        tentar("joao tenta ver as notas de maria de novo", () -> siga.verNotas(aluno, "maria"));
    }
}
