package com.example.ryan.table_top_generator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;


public class SectionSelect extends ActionBarActivity {

    Button npcButton;
    Button villageButton;

    //checkbox
    CheckBox jobCheck;

    //spinners
    Spinner jobBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_select);

        npcButton = (Button) findViewById(R.id.npc_button);
        villageButton = (Button) findViewById(R.id.village_button);

        //views for npc boxes
        View jobView = findViewById(R.id.job_box);

        //checkbox


        //spinners
        jobBox = (Spinner) jobView.findViewById(R.id.box_spinner);
        applyAdapter(jobBox, R.array.job_array);




    }

    public void applyAdapter(Spinner component, int array){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        component.setAdapter(adapter);
    }

    //for npc button being clicked
    public void npcSetClick(View view){
                Intent mIntent = new Intent(this, NPCGenerator.class);
                startActivity(mIntent);
    }
    public void villSetClick(){
        villageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("trial","village was clicked");
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_section_select, menu);
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
