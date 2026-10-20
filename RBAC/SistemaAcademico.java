import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Sistema acadêmico simples (tipo o SIGA)
// Todo método verifica a permissão antes de fazer qualquer coisa
public class SistemaAcademico {

    private final ControleDeAcesso acesso = new ControleDeAcesso();

    // dados guardados em memória
    private final Set<String> disciplinas = new LinkedHashSet<>();
    private final Map<String, Map<String, Double>> notas = new HashMap<>(); // aluno -> (disciplina -> nota)
    private final List<String> matriculasPendentes = new ArrayList<>();
    private final List<String> matriculasAprovadas = new ArrayList<>();
    private final Map<String, Usuario> usuarios = new HashMap<>();

    public ControleDeAcesso getControleDeAcesso() {
        return acesso;
    }

    public void cadastrarUsuario(Usuario executor, Usuario novo) {
        acesso.exigir(executor, Permissao.GERENCIAR_USUARIOS);
        usuarios.put(novo.getLogin(), novo);
    }

    public void criarDisciplina(Usuario executor, String codigo) {
        acesso.exigir(executor, Permissao.CRIAR_DISCIPLINA);
        disciplinas.add(codigo);
    }

    public void solicitarMatricula(Usuario aluno, String disciplina) {
        acesso.exigir(aluno, Permissao.FAZER_MATRICULA);
        matriculasPendentes.add(aluno.getLogin() + ":" + disciplina);
    }

    public void aprovarMatricula(Usuario executor, String loginAluno, String disciplina) {
        acesso.exigir(executor, Permissao.APROVAR_MATRICULA);
        String pedido = loginAluno + ":" + disciplina;
        if (matriculasPendentes.remove(pedido)) {
            matriculasAprovadas.add(pedido);
        }
    }

    public void lancarNota(Usuario executor, String loginAluno, String disciplina, double nota) {
        acesso.exigir(executor, Permissao.LANCAR_NOTA);
        notas.computeIfAbsent(loginAluno, k -> new HashMap<>()).put(disciplina, nota);
    }

    // professor vê a nota de qualquer um, aluno só vê a dele
    public Map<String, Double> verNotas(Usuario executor, String loginAluno) {
        boolean podeVerTodas = acesso.temPermissao(executor, Permissao.VER_NOTAS_TURMA);
        boolean ehOProprio = executor.getLogin().equals(loginAluno)
                && acesso.temPermissao(executor, Permissao.VER_PROPRIAS_NOTAS);

        if (!podeVerTodas && !ehOProprio) {
            throw new AcessoNegadoException(executor, Permissao.VER_NOTAS_TURMA);
        }
        return notas.getOrDefault(loginAluno, Map.of());
    }

    public List<String> getMatriculasAprovadas() {
        return List.copyOf(matriculasAprovadas);
    }
}
