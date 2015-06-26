package regmoraes.rplmanager.ui.main;

import android.support.v4.app.Fragment;
import android.support.v7.view.ActionMode;

/**
 * Created by regmoraes on 25/06/15.
 */
public interface MainView {

    void setFragment(Fragment fragment);
    void startCAB(ActionMode.Callback callback);
}
