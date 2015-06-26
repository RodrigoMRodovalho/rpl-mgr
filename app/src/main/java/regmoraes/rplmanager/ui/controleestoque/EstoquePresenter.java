package regmoraes.rplmanager.ui.controleestoque;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v7.view.ActionMode;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

/**
 * Created by regmoraes on 17/06/15.
 */
public interface EstoquePresenter extends LoaderManager.LoaderCallbacks<Cursor>,ActionMode.Callback,AdapterView.OnItemLongClickListener{

    void onMenuItemClicked(MenuItem item);

    void onItemLongClicked(int position);

    @Override
    boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id);

    @Override
    void onLoaderReset(android.support.v4.content.Loader<Cursor> loader);

    @Override
    void onLoadFinished(android.support.v4.content.Loader<Cursor> loader, Cursor data);

    @Override
    android.support.v4.content.Loader<Cursor> onCreateLoader(int id, Bundle args);
}
