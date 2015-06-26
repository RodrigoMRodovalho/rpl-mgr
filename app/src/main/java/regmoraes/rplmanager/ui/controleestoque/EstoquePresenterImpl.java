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
public class EstoquePresenterImpl implements EstoquePresenter,OnLoaderDataListener {

    //private Context context;
    private EstoqueView estoqueView;
    //private IEstoqueMgr estoqueMgr;
    private EstoqueIterator estoqueIterator;

    public EstoquePresenterImpl(FrgEstoque fragment) {

        this.estoqueView = fragment;
        estoqueIterator = new EstoqueIteratorImpl(fragment,this);
        estoqueIterator.startLoader();
    }


    @Override
    public boolean onItemLongClicked(AdapterView<?> parent) {
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

    @Override
    public void onSuccessLoadedData(CursorAdapterProduto cursorAdapterProduto) {
        estoqueView.preencherListView(cursorAdapterProduto);
    }
}
