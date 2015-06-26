package regmoraes.rplmanager.ui.main;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import regmoraes.rplmanager.R;
import regmoraes.rplmanager.ui.controleestoque.FrgEstoque;

/**
 * Created by regmoraes on 25/06/15.
 */
public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;

    public MainPresenterImpl(MainView mainView) {

        this.mainView = mainView;
    }

    @Override
    public void dialogEntradaCallback() {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.button_confirmar_entrada:
                dialogEntradaCallback();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Fragment fragment = null;

        switch (position){

            case 0:
                fragment = new FrgEstoque();
                break;

            case 1:
                break;

            case 2:
                break;

            default:break;
        }

        mainView.setFragment(fragment);
    }
}
