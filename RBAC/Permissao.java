// Todas as permissões que existem no sistema
// No RBAC o usuário não recebe permissão direto, ele recebe pelos papéis
public enum Permissao {
    VER_PROPRIAS_NOTAS,
    FAZER_MATRICULA,
    VER_NOTAS_TURMA,    // ver nota de qualquer aluno
    LANCAR_NOTA,
    APROVAR_MATRICULA,
    CRIAR_DISCIPLINA,
    GERENCIAR_USUARIOS,
    ATRIBUIR_PAPEIS     // dar ou tirar papel de alguém
}
