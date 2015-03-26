package com.example.david.eecshelp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class Queue extends ActionBarActivity  {
    ArrayList<Request> reqList;
    ArrayAdapter<Request> arrayAdapter;

    ListView queueListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue);

        reqList =  new ArrayList<Request>();
        arrayAdapter = new ArrayAdapter<Request>(this,android.R.layout.simple_list_item_1,reqList);
        queueListView = (ListView) findViewById(R.id.queueListView);

        queueListView.setOnItemClickListener(new ListClickHandler());
        queueListView.setAdapter(arrayAdapter);
        populateList();
    }

    private void populateList() {
        Request request = new Request("P35 1696 BBB","Noah Nuechterlein","9:45","ncnuech@umich.edu","This is my Issue");
        reqList.add(request);
        //add clear all button into arraylist.
        arrayAdapter.notifyDataSetChanged();

    }
    private class ListClickHandler implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> Adapter, View view, int position, long arg3) {
            Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_LONG).show();
            launchDetailedView(position);
        }
    }

    private void launchDetailedView(int requestPos) {
        // TODO Auto-generated method stub
        Request passingReq = arrayAdapter.getItem(requestPos);
        Intent intent = new Intent(getBaseContext(),RequestActivity.class);
        intent.putExtra("requestObj",passingReq);
        this.startActivityForResult(intent,0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_queue, menu);
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
}
