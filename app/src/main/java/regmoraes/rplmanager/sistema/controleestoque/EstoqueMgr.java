package regmoraes.rplmanager.sistema.controleestoque;

import android.content.Context;
import android.database.Cursor;

import regmoraes.rplmanager.database.databasemanager.ProdutoDAO;
import regmoraes.rplmanager.database.databasemanager.DataBaseHelper;
import regmoraes.rplmanager.database.databasemanager.IProdutoDAO;

/**
 * Created by regmoraes on 13/06/15.
 */
public class EstoqueMgr implements IEstoqueMgr {

    private IProdutoDAO iProdutoDAO;
    private Context context;
    private DataBaseHelper mDataBaseHelper;
    private static EstoqueMgr instacia;

    public static EstoqueMgr getInstacia(Context context){

        if(instacia == null){

            instacia = new EstoqueMgr(context);
        }

        return instacia;
    }

    public EstoqueMgr(Context context){

        this.context = context;
        this.mDataBaseHelper = DataBaseHelper.getInstancia(this.context);
        this.mDataBaseHelper.setBancoDados();
        this.iProdutoDAO = ProdutoDAO.getInstancia(this.context);
    }

    @Override
    public void adicionarEstoqueCx(int idProduto, float qtdCx) {

        Cursor mCursor = iProdutoDAO.acessarProdutoPorID(idProduto);
        float estoqueAtualCx = mCursor.getFloat(mCursor.getColumnIndex("qtd_estoque_cx"));
        int estoqueAtualPca = mCursor.getInt(mCursor.getColumnIndex("qtd_estoque_pca"));

        estoqueAtualCx += qtdCx;

        switch (idProduto){

            case 0:
                estoqueAtualPca = estoqueAtualPca * 8;
                break;

            case 1:
                estoqueAtualPca = estoqueAtualPca * 6;
                break;

            default:break;
        }

        iProdutoDAO.alterarQtdCx(idProduto,estoqueAtualCx);
        iProdutoDAO.alterarQtdPca(idProduto,estoqueAtualPca);
    }

    @Override
    public void adicionarEstoquePca(int idProduto, int qtdPca) {

        Cursor mCursor = iProdutoDAO.acessarProdutoPorID(idProduto);
        float estoqueAtualCx = mCursor.getFloat(mCursor.getColumnIndex("qtd_estoque_cx"));
        int estoqueAtualPca = mCursor.getInt(mCursor.getColumnIndex("qtd_estoque_pca"));

        estoqueAtualPca += qtdPca;

        switch (idProduto){

            case 0:
                estoqueAtualCx = estoqueAtualPca/8;
                break;

            case 1:
                estoqueAtualCx = estoqueAtualPca/6;
                break;

            default:break;
        }

        iProdutoDAO.alterarQtdCx(idProduto,estoqueAtualCx);
        iProdutoDAO.alterarQtdPca(idProduto,estoqueAtualPca);
    }

    @Override
    public void removerEstoqueCx(int idProduto, float qtdCx) {

        Cursor mCursor = iProdutoDAO.acessarProdutoPorID(idProduto);
        float estoqueAtualCx = mCursor.getFloat(mCursor.getColumnIndex("qtd_estoque_cx"));
        int estoqueAtualPca = mCursor.getInt(mCursor.getColumnIndex("qtd_estoque_pca"));

        estoqueAtualCx -= qtdCx;

        switch (idProduto){

            case 0:
                estoqueAtualCx = estoqueAtualPca/8;
                break;

            case 1:
                estoqueAtualCx = estoqueAtualPca/6;
                break;

            default:break;
        }

        iProdutoDAO.alterarQtdCx(idProduto, estoqueAtualCx);
        iProdutoDAO.alterarQtdPca(idProduto, estoqueAtualPca);
    }

    @Override
    public void removerEstoquePca(int idProduto, int qtdPca) {

        Cursor mCursor = iProdutoDAO.acessarProdutoPorID(idProduto);
        float estoqueAtualCx = mCursor.getFloat(mCursor.getColumnIndex("qtd_estoque_cx"));
        int estoqueAtualPca = mCursor.getInt(mCursor.getColumnIndex("qtd_estoque_pca"));

        estoqueAtualPca -= qtdPca;

        switch (idProduto){

            case 0:
                estoqueAtualCx = estoqueAtualPca/8;
                break;

            case 1:
                estoqueAtualCx = estoqueAtualPca/6;
                break;

            default:break;
        }

        iProdutoDAO.alterarQtdCx(idProduto, estoqueAtualCx);
        iProdutoDAO.alterarQtdPca(idProduto,estoqueAtualPca);
    }

   /* @Override
    public void editarEstoque(AbstractProduto produto) {

    }*/

    @Override
    public Cursor acessarProdutoPorID(int idProduto) {
        return iProdutoDAO.acessarProdutoPorID(idProduto);
    }

    @Override
    public Cursor acessarProdutos() {
        return iProdutoDAO.acessarProdutos();
    }
}
