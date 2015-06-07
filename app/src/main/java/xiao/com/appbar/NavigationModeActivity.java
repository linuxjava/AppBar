package xiao.com.appbar;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

/**
 * Created by guochang on 2015/6/7.
 */
public class NavigationModeActivity extends ActionBarActivity implements ActionBar.TabListener{
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_mode);

        actionBar = getSupportActionBar();

        actionBar.addTab(actionBar.newTab().setText("Tab 1").setTag("1").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Tab 2").setTag("2").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Tab 3").setTag("3").setTabListener(this));

        final ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(actionBar.getThemedContext(),
                R.layout.support_simple_spinner_dropdown_item,
                new String[] { "Item 1", "Item 2", "Item 3" });
        actionBar.setListNavigationCallbacks(listAdapter, new ActionBar.OnNavigationListener() {
            @Override
            public boolean onNavigationItemSelected(int i, long l) {
                Toast.makeText(NavigationModeActivity.this,
                        listAdapter.getItem(i),
                        Toast.LENGTH_SHORT).show();

                return true;
            }
        });
    }
    
    public void onNavigation(View v){
        switch (actionBar.getNavigationMode()) {
            case ActionBar.NAVIGATION_MODE_STANDARD:
                actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
                break;
            case ActionBar.NAVIGATION_MODE_TABS:
                actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
                break;
            case ActionBar.NAVIGATION_MODE_LIST:
                actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
                break;
        }
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        String tag = (String) tab.getTag();
        Toast.makeText(NavigationModeActivity.this, tag,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }
}
