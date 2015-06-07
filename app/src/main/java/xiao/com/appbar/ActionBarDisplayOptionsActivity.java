package xiao.com.appbar;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by guochang on 2015/6/7.
 */
public class ActionBarDisplayOptionsActivity extends ActionBarActivity implements View.OnClickListener{
    private ActionBar actionBar;
    private Button mLogoBtn;
    private ActionBar.LayoutParams mCustomViewLayoutParams;
    private Button mCustomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_options);

        actionBar = getSupportActionBar();

        findViewById(R.id.toggle_visibility).setOnClickListener(this);
        findViewById(R.id.toggle_home_as_up).setOnClickListener(this);
        findViewById(R.id.toggle_show_home).setOnClickListener(this);
        mLogoBtn = (Button) findViewById(R.id.toggle_use_logo);
        mLogoBtn.setOnClickListener(this);
        findViewById(R.id.toggle_show_title).setOnClickListener(this);
        findViewById(R.id.toggle_show_custom).setOnClickListener(this);
        findViewById(R.id.cycle_custom_gravity).setOnClickListener(this);

        mCustomViewLayoutParams = new ActionBar.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mCustomView = new Button(this);
        mCustomView.setText("1234");

        actionBar.setCustomView(mCustomView, mCustomViewLayoutParams);
    }

    @Override
    public void onClick(View v) {
        int flags = 0;

        switch (v.getId()){
            case R.id.toggle_visibility:
                if(actionBar.isShowing()){
                    actionBar.hide();
                }else {
                    actionBar.show();
                }
                break;
            case R.id.toggle_home_as_up:
                flags = ActionBar.DISPLAY_HOME_AS_UP;
                break;
            case R.id.toggle_show_home:
                flags = ActionBar.DISPLAY_SHOW_HOME;

                break;
            case R.id.toggle_use_logo:
                flags = ActionBar.DISPLAY_USE_LOGO;
                actionBar.setLogo(R.mipmap.ic_launcher);
                break;
            case R.id.toggle_show_title:
                flags = ActionBar.DISPLAY_SHOW_TITLE;
                break;
            case R.id.toggle_show_custom:
                flags = ActionBar.DISPLAY_SHOW_CUSTOM;
                break;
            case R.id.cycle_custom_gravity:
                ActionBar.LayoutParams lp = mCustomViewLayoutParams;
                int newGravity = 0;
                switch (lp.gravity & Gravity.HORIZONTAL_GRAVITY_MASK) {
                    case Gravity.LEFT:
                        newGravity = Gravity.CENTER_HORIZONTAL;
                        break;
                    case Gravity.CENTER_HORIZONTAL:
                        newGravity = Gravity.RIGHT;
                        break;
                    case Gravity.RIGHT:
                        newGravity = Gravity.LEFT;
                        break;
                }
                lp.gravity = lp.gravity & ~Gravity.HORIZONTAL_GRAVITY_MASK | newGravity;
                actionBar.setCustomView(mCustomView, lp);
                return;
        }

        actionBar.setDisplayOptions(actionBar.getDisplayOptions() ^ flags, flags);

        if((actionBar.getDisplayOptions() & ActionBar.DISPLAY_SHOW_HOME) == 0){
            mLogoBtn.setEnabled(false);
        }else {
            mLogoBtn.setEnabled(true);
        }
    }
}
