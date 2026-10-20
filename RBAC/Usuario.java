import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

// Usuário do sistema, pode ter mais de um papel
public class Usuario {

    private final String login;
    private final String nome;
    private final Set<Papel> papeis = EnumSet.noneOf(Papel.class);

    public Usuario(String login, String nome, Papel... papeisIniciais) {
        this.login = login;
        this.nome = nome;
        Collections.addAll(papeis, papeisIniciais);
    }

    public String getLogin() {
        return login;
    }

    public String getNome() {
        return nome;
    }

    // devolve só para leitura, para ninguém mudar os papéis por fora
    public Set<Papel> getPapeis() {
        return Collections.unmodifiableSet(papeis);
    }

    // só o ControleDeAcesso deve chamar esses dois
    void adicionarPapel(Papel papel) {
        papeis.add(papel);
    }

    void removerPapel(Papel papel) {
        papeis.remove(papel);
    }

    @Override
    public String toString() {
        return nome + " (" + login + ") " + papeis;
    }
}
