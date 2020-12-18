package com.sd.lap_7_12;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtid,txtname,txtsur,txtage,txttel,txtsearch;
    Button btnsearch,btnsave,btnedit,btndel;
    SQLiteDatabase db;
    DataBaseHelper mydb = new DataBaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb.getWritableDatabase();
        initial();
        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String [] data = mydb.SelectData(txtsearch.getText().toString());
                if(data != null){
                    txtid.setText(data[0]);
                    txtname.setText(data[1]);
                    txtsur.setText(data[2]);
                    txtage.setText(data[3]);
                    txttel.setText(data[4]);
                }else{
                    Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_LONG).show();
                }

            }
        });
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long r = mydb.insertData(txtname.getText().toString(),txtsur.getText().toString(),txtage.getText().toString(),txttel.getText().toString());
                if(r>0){
                    Toast.makeText(getApplicationContext(), "Insert Complete", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Insert Fail", Toast.LENGTH_LONG).show();
                }
            }
        });
//        btnedit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                long r = mydb.EditData(txtid.getText().toString(), txtname.getText().toString(), txtsur.getText().toString(), txtage.getText().toString(), txttel.getText().toString());
//                if(r>0){
//                    Toast.makeText(getApplicationContext(), "Edit Complete", Toast.LENGTH_LONG).show();
//                }else{
//                    Toast.makeText(getApplicationContext(), "Edit Fail", Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//        btndel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                long r = mydb.DeleteData(txtid.getText().toString());
//                if(r>0){
//                    Toast.makeText(getApplicationContext(), "Delete Complete", Toast.LENGTH_LONG).show();
//                }else{
//                    Toast.makeText(getApplicationContext(), "Delete Fail", Toast.LENGTH_LONG).show();
//                }
//            }
//        });
    }

    public void initial() {
        txtsearch = findViewById(R.id.txtsearch);
        txtid = findViewById(R.id.txtid);
        txtname = findViewById(R.id.txtnm);
        txtsur = findViewById(R.id.txtsn);
        txtage = findViewById(R.id.txtage);
        txttel  =findViewById(R.id.txtph);
        btnsave = findViewById(R.id.btncf);
        btnsearch = findViewById(R.id.btnse);
        btnedit= findViewById(R.id.btned);
        btndel = findViewById(R.id.btndel);
    }
}