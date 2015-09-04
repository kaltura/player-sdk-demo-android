package kaltura.com.kalturaplaydemo;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Point;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.kaltura.playersdk.KPPlayerConfig;
import com.kaltura.playersdk.PlayerViewController;
import com.kaltura.playersdk.events.KPlayerEventListener;
import com.kaltura.playersdk.events.KPlayerJsCallbackReadyListener;
import com.kaltura.playersdk.events.OnToggleFullScreenListener;


public class MainActivity extends ActionBarActivity implements PlayerFragment.OnFragmentInteractionListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Inflate the layout for this fragment

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setVisibility(View.INVISIBLE);
                Fragment fragment = new PlayerFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_up, R.anim.slide_down);
//        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                transaction.add(R.id.fragment_container, fragment);
                transaction.commit();
            }
        });
//        mPlayerView = (PlayerViewController)findViewById(R.id.player);
//        mPlayerView.setActivity(this);
//
//        KPPlayerConfig config = new  KPPlayerConfig("http://cdnapi.kaltura.com/html5/html5lib/v2.32/mwEmbedFrame.php", "26698911", "kaltura_player");
//        config.setWid("_1831271");
//        config.setCacheSt("1437571069");
//        config.setEntryId("1_o426d3i4");
//        mPlayerView.setComponents(config.getVideoURL());

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
    public void onFragmentInteraction(Uri uri) {

    }
}
