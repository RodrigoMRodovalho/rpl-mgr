package regmoraes.rplmanager.sistema.controleestoque;

import android.database.Cursor;

/**
 * Created by regmoraes on 11/06/15.
 */
public interface IEstoqueMgr{

    void adicionarEstoqueCx(int idProduto, float qntCx);
    void adicionarEstoquePca(int idProduto, int qtdPca);

    void removerEstoqueCx(int idProduto, float qtdCx);
    void removerEstoquePca(int idProduto, int qtdPca);

    //void editarEstoque(AbstractProduto produto);

    Cursor acessarProdutoPorID(int idProduto);
    Cursor acessarProdutos();
}
