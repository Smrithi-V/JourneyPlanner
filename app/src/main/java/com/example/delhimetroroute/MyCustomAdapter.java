package com.example.delhimetroroute;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyCustomAdapter extends BaseAdapter {

    private final Context ctx;
    private final List<MyData> myDataList;

    public MyCustomAdapter(Context ctx, List<MyData> myDataList) {
        this.ctx = ctx;
        this.myDataList = myDataList;
    }

    @Override
    public int getCount() {
        return myDataList.size();
    }

    @Override
    public MyData getItem(int position) {
        return myDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View myConvertView = convertView;
        if (myConvertView == null) {
            LayoutInflater inflater = LayoutInflater.from(ctx);
            myConvertView = inflater.inflate(R.layout.list_items, parent, false);
        }

        MyData currentItem = getItem(position);

        ImageView imageItem = myConvertView.findViewById(R.id.list_item_image);
        TextView titleItem = myConvertView.findViewById(R.id.list_item_title);

        if (imageItem != null) {
            imageItem.setImageResource(currentItem.getImage());
        }

        if (titleItem != null) {
            titleItem.setText(currentItem.getTitle());
        }

        return myConvertView;
    }
}
