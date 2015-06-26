package regmoraes.rplmanager.ui.controleestoque;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import regmoraes.rplmanager.R;
import regmoraes.rplmanager.database.databasemanager.EstoqueLoader;
import regmoraes.rplmanager.sistema.controleestoque.EstoqueMgr;
import regmoraes.rplmanager.sistema.controleestoque.IEstoqueMgr;

/**
 * Created by regmoraes on 17/06/15.
 */
public class EstoquePresenterImpl implements EstoquePresenter {

    private Context context;
    private EstoqueView estoqueView;
    private IEstoqueMgr estoqueMgr;

    public EstoquePresenterImpl(FrgEstoque fragment) {

        this.context = fragment.getActivity().getApplicationContext();
        this.estoqueView = fragment;
        this.estoqueMgr = EstoqueMgr.getInstacia(context);

        LoaderManager mLoaderManager = fragment.getLoaderManager();

        int LOADER_ID = 1;
        mLoaderManager.initLoader(LOADER_ID, null, this);
    }

    @Override
    public android.support.v4.content.Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new EstoqueLoader(context,estoqueMgr);
    }

    @Override
    public void onLoadFinished(android.support.v4.content.Loader<Cursor> loader, Cursor data) {

        CursorAdapterProduto mCursorAdapterProduto =
                new CursorAdapterProduto(context,data);

        estoqueView.preencherListView(mCursorAdapterProduto);

    }

    @Override
    public void onLoaderReset(android.support.v4.content.Loader<Cursor> loader) {

        /* TODO */
    }


    @Override
    public void onItemLongClicked(int position) {


    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        switch (parent.getId()){

            case R.id.listView_estoque:

                estoqueView.startCAB(this);
                break;

            default:break;
        }

        return true;
    }

    @Override
    public void onMenuItemClicked(MenuItem item) {

        switch (item.getItemId()){

            case R.id.editar:

                Fragment fragment = new FrgEstoque();
                estoqueView.setFragment(fragment);
                
                break;
            default:break;
        }
    }

    @Override
    public void onDestroyActionMode(ActionMode actionMode) {

    }

    @Override
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return false;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        //actionMode.getMenuInflater().inflate(R.menu.action_mode_estoque_item, menu);
        return false;
    }

    @Override
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {

        actionMode.getMenuInflater().inflate(R.menu.action_mode_estoque_item, menu);
        return true;
    }
}
