package regmoraes.rplmanager.database.databasemanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


/**
 * Created by regmoraes on 11/06/15.
 */
public class ProdutoDAO implements IProdutoDAO {

    private DataBaseHelper mDb;
    private SQLiteDatabase bdQuery;

    public static final String TABELA = "produtos";
    public static final String ID = "_id";
    public static final String NOME = "nome";
    public static final String PRECO_CUSTO = "preco_custo";
    public static final String QTD_ESTOQUE_CX = "qtd_estoque_cx";
    public static final String QTD_ESTOQUE_PCA = "qtd_estoque_pca";

    private static ProdutoDAO instancia;

    private ProdutoDAO(Context context){

        mDb = DataBaseHelper.getInstancia(context);
        bdQuery = mDb.getWritableDatabase();
    }

    public static ProdutoDAO getInstancia(Context context) {

        if(instancia == null){

            instancia = new ProdutoDAO(context);

        }
        return instancia;
    }

    @Override
    public void alterarQtdCx(int idProduto, float qtdCx) {

        String[] whereArgs = {Integer.toString(idProduto)};

        ContentValues values = new ContentValues();
        values.put(QTD_ESTOQUE_CX, qtdCx);

        bdQuery.update(TABELA, values, "where id = ?", whereArgs);
    }

    @Override
    public void alterarQtdPca(int idProduto, int qtdPca) {

        String[] whereArgs = {Integer.toString(idProduto)};

        ContentValues values = new ContentValues();
        values.put(QTD_ESTOQUE_PCA, Integer.toString(qtdPca));

        bdQuery.update(TABELA, values, "where id = ?", whereArgs);
    }

    @Override
    public Cursor acessarProdutoPorID(int idProduto) {

        String[] whereArgs = {Integer.toString(idProduto)};
        Cursor cursor = bdQuery.rawQuery("select * from " +
                TABELA + "where " + ID + " = ?", whereArgs);

        if(cursor != null) {
            cursor.moveToFirst();
        }

        return cursor;
    }

    @Override
    public Cursor acessarProdutos() {

        Cursor cursor = bdQuery.rawQuery("select * from " + TABELA, null);

        if(cursor != null) {
            cursor.moveToFirst();
        }

        return cursor;
    }

    /*@Override
    public void alterarProduto(AbstractProduto produto){

        String[] whereArgs = {Integer.toString(produto.getIdProduto())};

        ContentValues values = new ContentValues();
        values.put(NOME, produto.getNome());
        values.put(PRECO_CUSTO, produto.getPrecoCusto());
        values.put(QTD_ESTOQUE_CX, produto.getQtdeEstoqueCx());
        values.put(QTD_ESTOQUE_PCA, produto.getQtdeEstoquePca());

        bdQuery.update(TABELA, values, "where id=?", whereArgs);
    }*/
}
