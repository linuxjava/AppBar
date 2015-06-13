package xiao.com.appbar;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by guochang on 2015/6/11.
 */
public class ActionBarWithDrawerLayout extends ActionBarActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private DrawerLayout.DrawerListener drawerListener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(View view, float v) {
            Log.d("xiao1", "onDrawerSlide");
            mActionBarDrawerToggle.onDrawerSlide(view, v);
        }

        @Override
        public void onDrawerOpened(View view) {
            Log.d("xiao1", "onDrawerOpened");
            mActionBarDrawerToggle.onDrawerOpened(view);
        }

        @Override
        public void onDrawerClosed(View view) {
            Log.d("xiao1", "onDrawerClosed");
            mActionBarDrawerToggle.onDrawerClosed(view);
        }

        @Override
        public void onDrawerStateChanged(int i) {
            Log.d("xiao1", "onDrawerStateChanged");
            mActionBarDrawerToggle.onDrawerStateChanged(i);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(drawerListener);

        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.string.drawer_open, R.string.drawer_close);
        mActionBarDrawerToggle.syncState();

        //显示做上角返回图标
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mActionBarDrawerToggle.onOptionsItemSelected(item)){
            //捕获点击左上角图标事件
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mActionBarDrawerToggle.onConfigurationChanged(newConfig);
    }
}
