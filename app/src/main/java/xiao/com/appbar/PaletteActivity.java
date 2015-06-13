package xiao.com.appbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by guochang on 2015/6/13.
 */
public class PaletteActivity extends ActionBarActivity{
    private ImageView mImg;
    private TextView mVibrant, mDarkVibrante, mLightVibrante, mMute
            , mLightMute, mDarkMute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.palette);

        mImg = (ImageView) findViewById(R.id.img);
        mVibrant = (TextView) findViewById(R.id.vibrant_tv);
        mDarkVibrante = (TextView) findViewById(R.id.vibrant_dark_tv);
        mLightVibrante = (TextView) findViewById(R.id.vibrant_light_tv);
        mMute = (TextView) findViewById(R.id.mute_tv);
        mLightMute = (TextView) findViewById(R.id.mute_light_tv);
        mDarkMute = (TextView) findViewById(R.id.mute_dark_tv);

        mImg.setBackgroundResource(R.mipmap.test1);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test1);

        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                setBackgroundColor(mVibrant, palette.getVibrantSwatch());
                setBackgroundColor(mDarkVibrante, palette.getDarkVibrantSwatch());
                setBackgroundColor(mLightVibrante, palette.getLightVibrantSwatch());
                setBackgroundColor(mMute, palette.getMutedSwatch());
                setBackgroundColor(mLightMute, palette.getDarkMutedSwatch());
                setBackgroundColor(mDarkMute, palette.getLightMutedSwatch());
            }
        });
    }

    private void setBackgroundColor(View view, Palette.Swatch swatch) {
        if (view != null && swatch != null) {
            view.setBackgroundColor(swatch.getRgb());
        }else{
            ((TextView)view).setText("none");
        }
    }
}
