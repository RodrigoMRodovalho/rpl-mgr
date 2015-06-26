package regmoraes.rplmanager.database.databasemanager;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.content.CursorLoader;

import regmoraes.rplmanager.sistema.controleestoque.IEstoqueMgr;

/**
 * Created by regmoraes on 17/06/15.
 */
public class EstoqueLoader extends CursorLoader {

    private IEstoqueMgr estoqueMgr;

    public EstoqueLoader(Context context,IEstoqueMgr estoqueMgr) {

        super(context);
        this.estoqueMgr = estoqueMgr;
    }

    @Override
    public Cursor loadInBackground() {

        return estoqueMgr.acessarProdutos();
    }
}
