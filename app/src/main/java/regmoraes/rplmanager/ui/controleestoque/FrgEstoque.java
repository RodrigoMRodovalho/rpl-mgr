package regmoraes.rplmanager.ui.controleestoque;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import regmoraes.rplmanager.R;
import regmoraes.rplmanager.ui.main.MainView;

/**
 * Created by regmoraes on 11/06/15.
 */
public class FrgEstoque extends Fragment implements EstoqueView, AdapterView.OnItemLongClickListener{

    private MainView activityPresenter;
    private EstoquePresenterImpl presenter;
    private ListView mListView;


    public FrgEstoque() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
        activityPresenter = (MainView) getActivity();
        presenter = new EstoquePresenterImpl(this);
    }


    @Override
    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        android.view.View view = inflater.inflate(R.layout.fragment_estoque,container,false);
        mListView = (ListView) view.findViewById(R.id.listView_estoque);
        mListView.setOnItemLongClickListener(this);

        return view;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.estoque, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        presenter.onMenuItemClicked(item);
        return true;
    }

    @Override
    public void preencherListView(CursorAdapterProduto mCursorAdapter) {

        mListView.setAdapter(mCursorAdapter);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        presenter.onItemLongClicked();
        return false;
    }

    @Override
    public void setFragment(Fragment fragment) {

        activityPresenter.setFragment(fragment);
    }

    @Override
    public void startCAB(ActionMode.Callback callback) {

        activityPresenter.startCAB(callback);
    }
}
