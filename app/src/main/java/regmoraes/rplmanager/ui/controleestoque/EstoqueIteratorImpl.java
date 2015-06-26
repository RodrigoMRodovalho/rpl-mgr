package regmoraes.rplmanager.ui.controleestoque;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import regmoraes.rplmanager.database.databasemanager.EstoqueLoader;
import regmoraes.rplmanager.sistema.controleestoque.EstoqueMgr;
import regmoraes.rplmanager.sistema.controleestoque.IEstoqueMgr;
import regmoraes.rplmanager.ui.main.MainActivity;

/**
 * Created by rrodovalho on 26/06/15.
 */
public class EstoqueIteratorImpl implements EstoqueIterator,LoaderManager.LoaderCallbacks<Cursor> {

    private Context context;
    private IEstoqueMgr estoqueMgr;
    private LoaderManager loaderManager;
    private OnLoaderDataListener estoquePresenter;
    public static final int LOADER_ID = 1;

    public EstoqueIteratorImpl(Fragment fragment,OnLoaderDataListener estoquePresenter){
        this.context = fragment.getActivity().getApplicationContext();
        this.estoqueMgr = EstoqueMgr.getInstacia(context);
        this.loaderManager = fragment.getLoaderManager();
        this.estoquePresenter = estoquePresenter;
    }

        @Override
    public void startLoader() {
        this.loaderManager.initLoader(LOADER_ID, null, this);
    }

    @Override
    public android.support.v4.content.Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new EstoqueLoader(context,estoqueMgr);
    }

    @Override
    public void onLoadFinished(android.support.v4.content.Loader<Cursor> loader, Cursor data) {

        CursorAdapterProduto mCursorAdapterProduto =
                new CursorAdapterProduto(context,data);

        this.estoquePresenter.onSuccessLoadedData(mCursorAdapterProduto);

    }

    @Override
    public void onLoaderReset(android.support.v4.content.Loader<Cursor> loader) {

        /* TODO */
    }
}
