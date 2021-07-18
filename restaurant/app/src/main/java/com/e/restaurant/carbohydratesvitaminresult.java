package com.e.restaurant;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class carbohydratesvitaminresult extends AppCompatActivity{
    DBHelper sqlitehelper;
    EditText ident;
    Button seedata,start,delete;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carbohydratevitaminresult);
        seedata= findViewById(R.id.viewfood);
        ident= findViewById(R.id.price);
        start= findViewById(R.id.start);
        sqlitehelper= new DBHelper(carbohydratesvitaminresult.this);
        delete=findViewById(R.id.cleardb);

        //clear button
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick ( View v ) {
                Intent intent = new Intent(carbohydratesvitaminresult.this, foodoption.class);
                startActivity(intent);

            }});
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick ( View v ) {
                Integer deleterows = sqlitehelper.deletedata3(ident.getText().toString());
                if(deleterows >0){
                    Toast.makeText(carbohydratesvitaminresult.this,"Data deleted",Toast.LENGTH_LONG).show();
                }else
                    {
                        Toast.makeText(carbohydratesvitaminresult.this,"Data not updated",Toast.LENGTH_LONG).show();
                }
            }
        });
        seedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick ( View v )
            {
                Cursor data = sqlitehelper.getdata3();
                if(data.getCount()==0){
                    // show message
                    showmessage("ERROR","No record found");
                }
                StringBuffer buffer= new StringBuffer();
                while(data.moveToNext()){
                    buffer.append("id :"+data.getString(0));
                    buffer.append("\n");
                    buffer.append("carbohydrates :"+data.getString(1));
                    buffer.append("\n");
                    buffer.append("quantity :"+data.getString(2));
                    buffer.append("\n");
                    buffer.append("vitamin :"+data.getString(5));
                    buffer.append("\n");
                    buffer.append("quantity :"+data.getString(6));
                    buffer.append("\n");
                    buffer.append("\n");
                }
                showmessage("Data",buffer.toString());
            }

                                   }
        );}
    public void showmessage(String title,String message)
    {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }
}


