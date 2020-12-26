package com.sd.lap_7_12;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class list_activity extends AppCompatActivity {
    String[] value;
    ListView lt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_show_layout);
        lt = findViewById(R.id.list_pp);

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.listv,value);
        lt.setAdapter(adapter);
    }
}
