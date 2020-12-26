package com.sd.lap_7_12;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class showdata_Info extends AppCompatActivity {

    EditText tid,tnm,tsur,tage,tph;
    DataBaseHelper mydb = new DataBaseHelper(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_showinfo);
        tid = findViewById(R.id.txtshid);
        tnm = findViewById(R.id.txtshnm);
        tsur = findViewById(R.id.txtshsn);
        tage = findViewById(R.id.txtshage);
        tph = findViewById(R.id.txtshph);


        Bundle bun = getIntent().getExtras();
        String eid = bun.getString("id");
        String name = bun.getString("name");



        String [] data = mydb.SelectData(name);
        if(data != null){
            tid.setText(data[0]);
            tnm.setText(data[1]);
            tsur.setText(data[2]);
            tage.setText(data[3]);
            tph.setText(data[4]);
        }else{
            Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_LONG).show();
        }

//        tid.setText(eid);
//        tnm.setText(name);

    }
}
