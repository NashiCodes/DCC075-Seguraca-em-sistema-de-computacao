// Erro lançado quando o usuário não tem a permissão necessária
public class AcessoNegadoException extends RuntimeException {

    public AcessoNegadoException(Usuario usuario, Permissao permissao) {
        super("Acesso negado: " + usuario.getLogin() + " " + usuario.getPapeis()
                + " não possui a permissão " + permissao);
    }
}
