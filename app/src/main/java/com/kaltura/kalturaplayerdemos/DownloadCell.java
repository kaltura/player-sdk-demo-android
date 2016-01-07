package com.kaltura.kalturaplayerdemos;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by nissimpardo on 03/01/16.
 */
public class DownloadCell extends RelativeLayout {
    HashMap<String, Object> mParams;

    public DownloadCell(Context context) {
        super(context);
    }

    public DownloadCell(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DownloadCell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setParams(HashMap<String, Object> params) {
        mParams = params;
        ((TextView)findViewById(R.id.textView2)).setText((String) params.get("title"));
    }
}
