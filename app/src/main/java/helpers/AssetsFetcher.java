package helpers;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by nissimpardo on 03/01/16.
 */
public class AssetsFetcher {
    public static ArrayList<HashMap<String, Object>> loadJSONArrayFromAssets(Context context, String fileName) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        ArrayList<HashMap<String, Object>> params = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject obj = (JSONObject)jsonArray.get(i);
                HashMap<String, Object> hash = new HashMap<>();
                hash.put("title", obj.get("title"));
                hash.put("type", obj.get("cellType"));
                params.add(hash);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return params;
    }
}
