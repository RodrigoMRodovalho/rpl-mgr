package regmoraes.rplmanager.database.databasemanager;

import android.database.Cursor;

/**
 * Created by regmoraes on 11/06/15.
 */
public interface IProdutoDAO {

    Cursor acessarProdutoPorID(int idProduto);
    Cursor acessarProdutos();

    void alterarQtdCx(int idProduto, float qtdCx);
    void alterarQtdPca(int idProduto, int qtdPca);
}
