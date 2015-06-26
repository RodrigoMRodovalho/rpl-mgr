package regmoraes.rplmanager.ui.main;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import regmoraes.rplmanager.R;
import regmoraes.rplmanager.ui.controleestoque.FrgEstoque;


public class MainActivity extends ActionBarActivity implements MainView {

    private MainPresenter presenter;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private String[] leftSliderData = {"Estoque", "Vendas", "Clientes"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new MainPresenterImpl(this);

        iniciarView();
        iniciarDrawer();
    }

    private void iniciarView() {

        setContentView(R.layout.activity_main);

        if (toolbar != null) {
            toolbar.setTitle(R.string.app_name);
            setSupportActionBar(toolbar);
        }

        ListView leftDrawerList = (ListView) findViewById(R.id.navigation_drawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ArrayAdapter<String> navigationDrawerAdapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, leftSliderData);

        leftDrawerList.setAdapter(navigationDrawerAdapter);
        leftDrawerList.setOnItemClickListener(presenter);
    }

    private void iniciarDrawer() {

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            @Override
            public void onDrawerClosed(android.view.View drawerView) {
                super.onDrawerClosed(drawerView);

            }

            @Override
            public void onDrawerOpened(android.view.View drawerView) {
                super.onDrawerOpened(drawerView);

            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setFragment(Fragment fragment) {

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    @Override
    public void startCAB(ActionMode.Callback callback) {

        startSupportActionMode(callback);
    }
}