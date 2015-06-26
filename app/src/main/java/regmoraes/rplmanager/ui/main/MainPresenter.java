package regmoraes.rplmanager.ui.main;

import android.view.View;
import android.widget.AdapterView;

/**
 * Created by regmoraes on 25/06/15.
 */
public interface MainPresenter{

    void listClick(int position);

    void onClick(View v);

    void dialogEntradaCallback();
}
