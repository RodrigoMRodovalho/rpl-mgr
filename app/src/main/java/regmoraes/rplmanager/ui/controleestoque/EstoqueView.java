package regmoraes.rplmanager.ui.controleestoque;

import android.support.v4.app.Fragment;
import android.support.v7.view.ActionMode;

/**
 * Created by regmoraes on 13/06/15.
 */
public interface EstoqueView{

    void preencherListView(CursorAdapterProduto mCursorAdapter);
    void setFragment(Fragment fragment);
    void startCAB(ActionMode.Callback callback);
}
