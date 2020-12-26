package com.sd.lap_7_12;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class showDataAll extends AppCompatActivity {

    ArrayList<String> arrname = new ArrayList<String>();
    ArrayList<String> arrid = new ArrayList<String>();
    ArrayList<String> arrsur = new ArrayList<String>();
    ArrayList<String> arrage = new ArrayList<String>();
    ArrayList<String> arrphone = new ArrayList<String>();
    ListView lst;
    ArrayAdapter adp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_show_layout);
        lst = findViewById(R.id.list_pp);
        DataBaseHelper mydb = new DataBaseHelper(this);
        Cursor cur = mydb.selectAllData();
        arrname.clear();
        arrid.clear();
        arrage.clear();
        arrphone.clear();
        arrsur.clear();
        if(cur != null){
            if(cur.moveToFirst()){
                do{
                    arrid.add(cur.getString(0));
                    arrname.add(cur.getString(1));

                }while (cur.moveToNext());
            }
        }
        cur.close();

        adp = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,arrname);

        lst.setAdapter(adp);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                Toast.makeText(showDataAll.this,arrid.get(position),Toast.LENGTH_SHORT).show();

                Intent obj = new Intent(showDataAll.this,showdata_Info.class);
                obj.putExtra("id", arrid.get(position));
                obj.putExtra("name", arrname.get(position));

                startActivity(obj);
            }
        });
    }
}
