package com.example.david.eecshelp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.widget.TextView;


public class RequestActivity extends ActionBarActivity {

    Request targetRequest;
    TextView nameTxt;
    TextView locationTxt;
    TextView emailTxt;
    TextView issueTxt;
    TextView timeTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        Intent intent = this.getIntent();
        targetRequest = (Request) intent.getSerializableExtra("requestObj");

        nameTxt = (TextView) findViewById(R.id.nameTxt);
        locationTxt = (TextView) findViewById(R.id.locationTxt);
        emailTxt = (TextView) findViewById(R.id.emailTxt);
        issueTxt = (TextView) findViewById(R.id.issueTxt);
        timeTxt = (TextView) findViewById(R.id.timeTxt);

        populateOutputFields();
    }

    private void populateOutputFields() {
        nameTxt.setText(targetRequest.name);
        locationTxt.setText(targetRequest.location);
        emailTxt.setText(targetRequest.email);
        issueTxt.setText(targetRequest.issue);
        timeTxt.setText(targetRequest.timestamp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_request, menu);
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
