package xiao.com.appbar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by guochang on 2015/6/7.
 */
public class ActionBarTabsActivity extends ActionBarActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_bar_tabs);
    }

    public void onAddTab(View v) {
        final ActionBar bar = getSupportActionBar();
        final int tabCount = bar.getTabCount();
        final String text = "Tab " + tabCount;
        bar.addTab(bar.newTab()
                .setText(text)
                .setTabListener(new Tablisten(new TabContentFragment(text))));

    }

    public void onRemoveTab(View v) {
        final ActionBar bar = getSupportActionBar();
        if (bar.getTabCount() > 0) {
            bar.removeTabAt(bar.getTabCount() - 1);
        }
    }

    public void onToggleTabs(View v) {
        final ActionBar bar = getSupportActionBar();

        if (bar.getNavigationMode() == ActionBar.NAVIGATION_MODE_TABS) {
            bar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        } else {
            bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        }
    }

    public void onRemoveAllTabs(View v) {
        getSupportActionBar().removeAllTabs();
    }


    private class Tablisten implements ActionBar.TabListener{
        private TabContentFragment tabContentFragment;

        public Tablisten(TabContentFragment fragment){
            tabContentFragment = fragment;
        }

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
            fragmentTransaction.add(R.id.fragment_content, tabContentFragment, tabContentFragment.getText());
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
            fragmentTransaction.remove(tabContentFragment);
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
            Toast.makeText(ActionBarTabsActivity.this, "Reselected!", Toast.LENGTH_SHORT).show();
        }
    }

    public class TabContentFragment extends Fragment {
        private String mText;

        public TabContentFragment(String text) {
            mText = text;
        }

        public String getText() {
            return mText;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            TextView text = new TextView(ActionBarTabsActivity.this);
            text.setText(mText);

            return text;
        }
    }
}
