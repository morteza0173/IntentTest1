package com.intent.test.intenttest;

import android.app.Activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter{
    private int resourceId;
    private Activity activity;
    private ArrayList<CustomListView> data;

    public CustomListAdapter (Activity activity, int resourceId, ArrayList<CustomListView> object) {
        super(activity,resourceId,object);

        this.resourceId = resourceId;
        this.activity = activity;
        this.data = object;

        }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View view = convertView;
        view = this.activity.getLayoutInflater().inflate(this.resourceId, null);

        ImageView customImageView = (ImageView) view.findViewById(R.id.imageView_customListView_imageView);
        TextView customTextView = (TextView) view.findViewById(R.id.textView_customListView_title);


        CustomListView customListView = data.get(position);
        customTextView.setText(customListView.textView_customListView);

        if(customListView.imageView_customListView==0 ){
            customImageView.setImageResource(R.drawable.ic_update_black_24dp);
        }else {
            customImageView.setImageResource(R.drawable.ic_fiber_new_black_24dp);
        }

        return view;
    }
}




