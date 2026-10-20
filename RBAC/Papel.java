import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

// Papéis do sistema e as permissões de cada um
// O coordenador herda as permissões do professor
public enum Papel {

    ALUNO(null,
            Permissao.VER_PROPRIAS_NOTAS,
            Permissao.FAZER_MATRICULA),

    PROFESSOR(null,
            Permissao.VER_NOTAS_TURMA,
            Permissao.LANCAR_NOTA),

    COORDENADOR(PROFESSOR,
            Permissao.APROVAR_MATRICULA,
            Permissao.CRIAR_DISCIPLINA),

    // admin só cuida de usuários, não mexe em nota nem matrícula
    ADMINISTRADOR(null,
            Permissao.GERENCIAR_USUARIOS,
            Permissao.ATRIBUIR_PAPEIS);

    private final Set<Permissao> permissoes;

    Papel(Papel pai, Permissao... proprias) {
        EnumSet<Permissao> todas = EnumSet.noneOf(Permissao.class);
        Collections.addAll(todas, proprias);
        // se tiver papel pai, pega as permissões dele também
        if (pai != null) {
            todas.addAll(pai.getPermissoes());
        }
        this.permissoes = Collections.unmodifiableSet(todas);
    }

    public Set<Permissao> getPermissoes() {
        return permissoes;
    }

    public boolean possui(Permissao permissao) {
        return permissoes.contains(permissao);
    }
}
