package com.example.listview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

public class PhotoAdapter extends BaseAdapter {

    Context context;
    String[] names;
    int[] photos;
//    private static LayoutInflater inflater = null;
    private static LayoutInflater inflate = null;


//    public PhotoAdapter(MainActivity context, String[] names, int[] photos, LayoutInflater inflater) {
//        this.context = context;
//        this.names = names;
//        this.photos = photos;
//        this.inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
//    }

    public PhotoAdapter(MainActivity context, String[] names, int[] photos) {
        this.context = context;
        this.names = names;
        this.photos = photos;
    }


    @Override
    public int getCount() {
//       IT IS IMPORTANT TO RETURN THE SIZE/LENGTH OF THE ARRAY
//        IT WILL DETERMINE HOW MANY TIMES THE GET VIEW WILL BE LOOPED. I THINK
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // GET VIEW METHOD IS AUTOMATICALLY CALLED WHENEVER IT IS SET AS AN ADAPTER TO A VIEW EX:LISTVIEW/SPINNER
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//       YOU CAN GET THE INFLATER SERVICE VIA THIS ONE OR VIA FROM THE COMMENTED CODE IN THE CONSTRUCTOR
//        IT IS BECAUSE YOU CANNOT USE GETLAYOURINFLATER() IN COMPONENTS THAT DOES NOT HAVE CONTEXT EXAMPLE FRAGMENTS, ADAPTER
//        ONLY ACTIVITY, APPLICATION etc. CAN USE THAT DIRECTLY
        LayoutInflater inflate = LayoutInflater.from(context);

        convertView = inflate.inflate(R.layout.activity_listview_ui, null);

        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        tvName.setText(names[position]);

        ImageView ivPhoto = (ImageView) convertView.findViewById(R.id.ivPhoto);
        ivPhoto.setImageResource(photos[position]);

        return convertView;
    }
}
