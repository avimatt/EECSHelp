package com.example.david.eecshelp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by David on 3/25/2015.
 */
public class RequestQueueAdapter extends BaseAdapter implements View.OnClickListener {
    private Activity activity;
    private ArrayList data;
    private static LayoutInflater inflater=null;
    public Resources res;
    Request tempValues=null;
    int i = 0;

    /*************  CustomAdapter Constructor *****************/
    public RequestQueueAdapter(Activity a, ArrayList d,Resources resLocal) {

        /********** Take passed values **********/
        activity = a;
        data=d;
        res = resLocal;

        /***********  Layout inflator to call external xml layout () ***********/
        inflater = ( LayoutInflater )activity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    /******** What is the size of Passed Arraylist Size ************/
    public int getCount() {

        if(data.size()<=0)
            return 1;
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    /********* Create a holder Class to contain inflated xml file elements *********/
    public static class ViewHolder{
        //This is where you put the references to the view
        public TextView name;
        public TextView location;
        public TextView timestamp;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View vi = convertView;
        ViewHolder holder;

        if (convertView == null) {

            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            vi = inflater.inflate(R.layout.queue_request_item, null);

            /****** View Holder Object to contain tabitem.xml file elements ******/

            holder = new ViewHolder();

            //Setup objects in view ie holder.txt = TextView vi.findviewbyid...
            holder.name = (TextView) vi.findViewById(R.id.name);
            holder.location = (TextView) vi.findViewById(R.id.location);
            holder.timestamp = (TextView) vi.findViewById(R.id.timestamp);
            vi.setTag(holder);
        } else {
            holder = (ViewHolder) vi.getTag();
        }

        if(data.size()<=0)
        {
            //set to no data
        }
        else {
            /***** Get each Model object from Arraylist ********/
            tempValues = null;
            tempValues = (Request) data.get(position);

            //set the objects in view
            holder.name.setText(tempValues.getName());
            holder.location.setText(tempValues.getLocation());
            holder.timestamp.setText(tempValues.getTimestamp());
            vi.setOnClickListener(new OnItemClickListener(position));
        }
        return vi;
    }

    @Override
    public void onClick(View v) {
        Log.v("CustomAdapter", "=====Row button clicked=====");
    }

    /********* Called when Item click in ListView ************/
    private class OnItemClickListener  implements View.OnClickListener {
        private int mPosition;

        OnItemClickListener(int position){
            mPosition = position;
        }

        @Override
        public void onClick(View arg0) {


            Queue sct = (Queue)activity;

            /****  Call  onItemClick Method inside CustomListViewAndroidExample Class ( See Below )****/

            sct.onItemClick(mPosition);
        }
    }
}
