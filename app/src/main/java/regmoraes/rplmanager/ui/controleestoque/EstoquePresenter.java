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
public interface EstoquePresenter extends ActionMode.Callback{

    void onMenuItemClicked(MenuItem item);

    boolean onItemLongClicked(AdapterView<?> parent);

}
