package xiao.com.appbar;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLogoTitle(View v){
        startActivity(new Intent(this, LogoTitleActivity.class));
    }

    public void onActionBarDisplayOptions(View v){
        startActivity(new Intent(this, ActionBarDisplayOptionsActivity.class));
    }

    public void onModeNavigation(View v){
        startActivity(new Intent(this, NavigationModeActivity.class));
    }

    public void onActionBarTabs(View v){
        startActivity(new Intent(this, ActionBarTabsActivity.class));
    }

    public void onActionBarMenu(View v){
        startActivity(new Intent(this, ActionBarMenu.class));
    }

    public void onActionBarWithDrawerLayout(View v){
        startActivity(new Intent(this, ActionBarWithDrawerLayout.class));
    }

    public void onPaletteActivity(View v){
        startActivity(new Intent(this, PaletteActivity.class));
    }

}
