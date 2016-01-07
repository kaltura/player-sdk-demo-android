package com.kaltura.kalturaplayerdemos;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.kaltura.playersdk.PlayerViewController;

public class MainActivity extends AppCompatActivity implements PlayerFragment.OnFragmentInteractionListener, View.OnClickListener {
    private PlayerFragment mPlayerFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);
        button = (Button)findViewById(R.id.button2);
        button.setOnClickListener(this);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mPlayerFragment != null && !isFinishing()) {
            mPlayerFragment.killPlayer();
            mPlayerFragment = null;
            ((Button)findViewById(R.id.button)).setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.d("URI", uri.toString());
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            mPlayerFragment.pausePlayer();
            getFragmentManager().popBackStack();
            findViewById(R.id.button).setVisibility(View.VISIBLE);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button) {
            v.setVisibility(View.INVISIBLE);
            findViewById(R.id.button2).setVisibility(View.INVISIBLE);
            boolean isPlayer = false;
            if (mPlayerFragment == null) {
                mPlayerFragment = new PlayerFragment();
                isPlayer = true;
            }
            FragmentTransaction transaction = getFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_up, R.anim.slide_down);
//        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
            transaction.add(R.id.fragment_container, mPlayerFragment);
            transaction.addToBackStack(mPlayerFragment.getClass().getName());
            transaction.commit();
            if (!isPlayer) {
                mPlayerFragment.resumePlayer();
            }
        } else {
            Intent intent = new Intent(this, OfflineActivity.class);
            startActivity(intent);
        }
    }
}
