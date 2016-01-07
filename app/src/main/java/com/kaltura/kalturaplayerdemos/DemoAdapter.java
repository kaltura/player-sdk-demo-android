package com.kaltura.kalturaplayerdemos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by nissimpardo on 03/01/16.
 */
public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.ItemViewHolder> {
    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        public ItemViewHolder(View itemView) {
            super(itemView);
        }
    }
    private Context mContext;
    private ArrayList<HashMap<String, Object>> mItems;

    public DemoAdapter(Context context, ArrayList<HashMap<String, Object>> items) {
        super();
        mContext = context;
        mItems = items;
    }

//    @Override
//    public int getCount() {
//        if (mItems == null) {
//            return 0;
//        }
//        return mItems.size();
//    }

//    @Override
//    public boolean isEnabled(int position) {
//        return ((Integer)mItems.get(position).get("type")).intValue() == 1;
//    }

//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return null;
//    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

    }

//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//
//    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        HashMap<String, Object> hash = mItems.get(position);
//        switch (((Integer)hash.get("type")).intValue()) {
//            case 0:
//                InputCellView inputCellView = (InputCellView)inflater.inflate(R.layout.input_cell,parent, false);
//                inputCellView.setParams(hash);
//                return inputCellView;
//            case 1:
//                DownloadCell downloadCell = (DownloadCell)inflater.inflate(R.layout.action_cell, parent, false);
//                downloadCell.setParams(hash);
//                return downloadCell;
//        }
//        return null;
//    }


}
