// Classe que decide se o usuário pode ou não fazer algo
// Se nenhum papel dele tiver a permissão, é negado
public class ControleDeAcesso {

    public boolean temPermissao(Usuario usuario, Permissao permissao) {
        for (Papel papel : usuario.getPapeis()) {
            if (papel.possui(permissao)) {
                return true;
            }
        }
        return false;
    }

    // mesma coisa, mas lança erro se não tiver permissão
    public void exigir(Usuario usuario, Permissao permissao) {
        if (!temPermissao(usuario, permissao)) {
            throw new AcessoNegadoException(usuario, permissao);
        }
    }

    // só quem tem ATRIBUIR_PAPEIS pode dar ou tirar papel
    public void atribuirPapel(Usuario executor, Usuario alvo, Papel papel) {
        exigir(executor, Permissao.ATRIBUIR_PAPEIS);
        alvo.adicionarPapel(papel);
    }

    public void revogarPapel(Usuario executor, Usuario alvo, Papel papel) {
        exigir(executor, Permissao.ATRIBUIR_PAPEIS);
        alvo.removerPapel(papel);
    }
}
