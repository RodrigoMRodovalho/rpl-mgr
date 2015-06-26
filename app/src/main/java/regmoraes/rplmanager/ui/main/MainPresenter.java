package regmoraes.rplmanager.ui.main;

import android.view.View;
import android.widget.AdapterView;

/**
 * Created by regmoraes on 25/06/15.
 */
public interface MainPresenter extends AdapterView.OnItemClickListener,View.OnClickListener{

    @Override
    void onItemClick(AdapterView<?> parent, View view, int position, long id);

    @Override
    void onClick(View v);

    void dialogEntradaCallback();
}
