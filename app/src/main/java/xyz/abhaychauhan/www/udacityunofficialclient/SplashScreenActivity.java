package xyz.abhaychauhan.www.udacityunofficialclient;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Felipe on 10/31/16.
 */
public class SplashScreenActivity extends AppCompatActivity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 3600;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_splash);
        hideActionBar();
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainIntent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
        super.onCreate(savedInstanceState);
    }
    public void hideActionBar() {
        try {
            getSupportActionBar().hide();
            getActionBar().hide();
        } catch (Exception e) {//ignore}
        }
    }
}
