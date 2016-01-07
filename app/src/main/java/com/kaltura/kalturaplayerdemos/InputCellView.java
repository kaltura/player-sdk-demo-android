package com.kaltura.kalturaplayerdemos;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;

/**
 * TODO: document your custom view class.
 */
public class InputCellView extends RelativeLayout {
    HashMap<String, Object> mParams;


    public InputCellView(Context context) {
        super(context);
    }

    public InputCellView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InputCellView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setParams(HashMap<String, Object> params) {
        mParams = params;
        ((TextView)findViewById(R.id.textView)).setText((String) params.get("title"));
    }

    public String getValue() {
        return ((EditText)findViewById(R.id.editText)).getText().toString();
    }

    public String getTitle() {
        return (String)mParams.get("title");
    }
}
