package com.example.digdig.listviewmultiplechoice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.digdig.listviewmultiplechoice.model.FileSportManagement;
import com.example.digdig.listviewmultiplechoice.model.Sports;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemClickListener {
ListView listViewSports;
Button btnShow;
TextView textViewSports;
ArrayList<Sports> listOfSports;
ArrayAdapter<Sports> adapterSports;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    //te

    private void initialize() {
        listViewSports = (ListView) findViewById(R.id.listViewSports);
        btnShow = (Button) findViewById(R.id.buttonShow);
        textViewSports = (TextView) findViewById(R.id.textView);
        btnShow.setOnClickListener(this);

        listOfSports = FileSportManagement.readFile(this,"sports.txt");
        adapterSports =  new ArrayAdapter<Sports>(this,android.R.layout.simple_list_item_checked,listOfSports);
        listViewSports.setAdapter(adapterSports);
    }

    @Override
    public void onClick(View v) {
        SparseBooleanArray checked = listViewSports.getCheckedItemPositions();
        StringBuilder sb =  new StringBuilder("");
// i is the position in the cheked map
        for (int i = 0; i<checked.size();i++)
        {
            int key = checked.keyAt(i);
            if (checked.valueAt(i))
            {
                String elements = listOfSports.get(key).toString();
                sb.append(elements+","+key+","+i+"\n");

            }
        }
        textViewSports.setText(sb);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
