package com.e.restaurant;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class balanceddietfinalresult extends AppCompatActivity{
     DBHelper sqlitehelper;
    EditText ident;
    Button seedata,start,delete;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.balanceddietresult);
        delete=findViewById(R.id.cleardb);
        start= findViewById(R.id.start);
        seedata= findViewById(R.id.viewfood);
        sqlitehelper= new DBHelper(balanceddietfinalresult.this);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick ( View v ) {
                Integer deleterows = sqlitehelper.deletedata1(ident.getText().toString());
                if(deleterows >0){
                    Toast.makeText(balanceddietfinalresult.this,"Data deleted",Toast.LENGTH_LONG).show();
                }else
                {
                    Toast.makeText(balanceddietfinalresult.this,"Data not updated",Toast.LENGTH_LONG).show();
                }


            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick ( View v ) {
                Intent intent = new Intent(balanceddietfinalresult.this, foodoption.class);
                startActivity(intent);

            }});
        seedata.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick ( View v )
            {  Cursor data = sqlitehelper.getdata();
                if(data.getCount()==0){
                    // show message
                    showmessage("ERROR","No record found");
                }
                StringBuffer buffer= new StringBuffer();
                while(data.moveToNext()){
                    buffer.append("id :"+data.getInt(0));
                    buffer.append("\n");
                    buffer.append("carbohydrates :"+data.getString(1));
                    buffer.append("\n");
                    buffer.append("quantity :"+data.getString(2));
                    buffer.append("\n");
                    buffer.append("proteins :"+data.getString(5));
                    buffer.append("\n");
                    buffer.append("quantity :"+data.getString(6));
                    buffer.append("\n");
                    buffer.append("vitamins :"+data.getString(9));
                    buffer.append("\n");
                    buffer.append("quantity :"+data.getString(10));
                    buffer.append("\n");
                    buffer.append("\n");
                }
                showmessage("Balanced diet",buffer.toString());
            }

        }

        ); }
        public void showmessage(String title,String message)
    {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }
}

