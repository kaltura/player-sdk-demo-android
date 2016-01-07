package com.kaltura.kalturaplayerdemos;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kaltura.playersdk.KPPlayerConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import helpers.AssetsFetcher;
import helpers.VideoDownloader;

public class OfflineActivity extends Activity {
    private KPPlayerConfig mConfig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline);
        ArrayList<HashMap<String, Object>> cells = AssetsFetcher.loadJSONArrayFromAssets(this, "demoParams.json");
        Log.d("test", cells.toString());
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final DemoAdapter adapter = new DemoAdapter(this, cells);
        recyclerView.setAdapter(adapter);

        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 4:

                        break;
                    case 5:
                        downloadVideo(adapter, (DownloadCell)view);
                        break;
                    case 6:
                        fetchParams(adapter);
                        break;
                }
            }
        });
    }

    private void fetchParams(DemoAdapter adapter) {
//        String domain = ((InputCellView)adapter.getItem(0)).getValue();
//        String uiConf = ((InputCellView)adapter.getItem(1)).getValue();
//        String partnerId = ((InputCellView)adapter.getItem(2)).getValue();
//        String entryId = ((InputCellView)adapter.getItem(3)).getValue();
//        mConfig = new KPPlayerConfig(domain, uiConf,partnerId);
//        mConfig.setEntryId(entryId);
    }

    private void downloadVideo(DemoAdapter adapter, DownloadCell view) {
        final TextView textView = (TextView)view.findViewById(R.id.textView2);
        if (!textView.getTag().equals("Get Licensce")) {
            textView.setVisibility(View.INVISIBLE);
            final ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
            progressBar.setVisibility(View.VISIBLE);

//        String url = ((InputCellView)adapter.getView(4, null, null)).getValue();
//            String url = "http://www.sample-videos.com/video/mp4/720/big_buck_bunny_720p_1mb.mp4";
            VideoDownloader downloader = new VideoDownloader(this, "test", new VideoDownloader.VideoDownloaderListener() {
                @Override
                public void onDownloadFinished(String fileName) {
                    progressBar.setProgress(100);
                    progressBar.setVisibility(View.INVISIBLE);
                    textView.setVisibility(View.VISIBLE);
                    textView.setText("Get Licensce");
                }

                @Override
                public void onProgressUpdated(float progress) {
                    progressBar.setProgress((int) (progress * 100));
                }
            });
//            downloader.execute(url);
        } else {
            getLicensce();
        }
    }

    private void getLicensce() {

    }

}
