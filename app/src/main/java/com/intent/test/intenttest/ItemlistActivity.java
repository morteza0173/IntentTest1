package com.intent.test.intenttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ItemlistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemlist);
        final EditText edt_itemlistActivity_edtName = (EditText)findViewById(R.id.edt_itemlistActivity_edtName);
        Button btn_itemlistActivity_btnAdd = (Button)findViewById(R.id.btn_itemlistActivity_btnAdd);
        ListView listView_itemlistActivity_listViewName = (ListView) findViewById(R.id.listView_itemlistActivity_listViewName);

        final ArrayList<String> arrayList=new ArrayList<String>();
        arrayList.add("morteza");
        arrayList.add("mostafa");
        arrayList.add("ali");

        final ArrayAdapter<String> adapter= new ArrayAdapter<String>(ItemlistActivity.this,android.R.layout.simple_list_item_1,arrayList);

        btn_itemlistActivity_btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.add(edt_itemlistActivity_edtName.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });


        listView_itemlistActivity_listViewName.setAdapter(adapter);
        


    }
}
