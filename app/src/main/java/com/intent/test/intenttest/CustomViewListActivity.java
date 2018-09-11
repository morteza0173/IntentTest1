package com.intent.test.intenttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;

import java.util.ArrayList;

public class CustomViewListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view_list);
        final EditText edt_customViewListActivity_edtTitel= (EditText)findViewById(R.id.edt_customViewListActivity_edtTitel);
        final RadioButton rB_customViewListActivity_firistRadioButton = (RadioButton)findViewById(R.id.rB_customViewListActivity_firistRadioButton);
        RadioButton rB_customViewListActivity_secondRadioButton = (RadioButton)findViewById(R.id.rB_customViewListActivity_secondRadioButton);
        Button button_customViewListActivity_addButton= (Button) findViewById(R.id.button_customViewListActivity_addButton);

        final ArrayList<CustomListView> customListArray = new ArrayList<CustomListView>();

        ListView listView = (ListView)findViewById(R.id.listView_customViewListActivity_listView);

        final CustomListAdapter customListAdapter = new CustomListAdapter(CustomViewListActivity.this, R.layout.custom_list_view, customListArray);
        listView.setAdapter(customListAdapter);

        button_customViewListActivity_addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int img;

                if(rB_customViewListActivity_firistRadioButton.isChecked()){
                    img = 0;
                }else {
                    img=1;
                }

                customListArray.add(new CustomListView(img , edt_customViewListActivity_edtTitel.getText().toString()));
                customListAdapter.notifyDataSetChanged();


            }
        });



    }
}
