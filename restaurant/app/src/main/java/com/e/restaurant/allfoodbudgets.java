package com.e.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class allfoodbudgets extends AppCompatActivity {
    DBHelper sqlitehelper;
    EditText ident;
    TextView n1,n2,n3,n4,n5,n6,n7,n8,n9,n10;
    Button balancedresult,cabsproresult,cabsvitaresult,vitaproresult,
            cabs1,cabs2,cabs3,
            pro1,pro2,
            vita4,pro4,vita3,vita1;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allfoodbudgets);
        sqlitehelper= new DBHelper(allfoodbudgets.this);

        balancedresult= findViewById(R.id.buttona);
        cabs1= findViewById(R.id.button1);
        pro1= findViewById(R.id.button2);
        vita1= findViewById(R.id.button3);

        n1=findViewById(R.id.textview1);
        n2=findViewById(R.id.textview2);
        n3=findViewById(R.id.textview3);
        n4=findViewById(R.id.textView4);
        n6=findViewById(R.id.textview6);
        n7=findViewById(R.id.textview7);
        n8=findViewById(R.id.textview8);
        n9=findViewById(R.id.textview9);
        n10=findViewById(R.id.textview10);

        cabsproresult=findViewById(R.id.buttonaa);
        cabs2= findViewById(R.id.button11);
        pro2= findViewById(R.id.button22);

        cabsvitaresult=findViewById(R.id.buttonaaa);
        cabs3= findViewById(R.id.button111);
        vita3= findViewById(R.id.button333);

        vitaproresult=findViewById(R.id.buttonaaaa);
        vita4= findViewById(R.id.button33333);
        pro4= findViewById(R.id.button2222);

        //calculates vitamin total in vitamin protein table
        vita4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick ( View v ) {
                int c = sqlitehelper.sumvita4();
                if(c==0){
                    Toast.makeText(allfoodbudgets.this,"record is empty", Toast.LENGTH_LONG).show();
                }else
                {   String carbstotal=Integer.toString(c);
                    n9.setText(carbstotal);
                    Toast.makeText(allfoodbudgets.this,"record shown below", Toast.LENGTH_LONG).show();
                }
            }});



        vita3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick ( View v ) {
                int c = sqlitehelper.sumvita3();
                if(c==0){
                    Toast.makeText(allfoodbudgets.this,"record is empty", Toast.LENGTH_LONG).show();
                }else
                {   String carbstotal=Integer.toString(c);
                    n8.setText(carbstotal);
                    Toast.makeText(allfoodbudgets.this,"record shown below", Toast.LENGTH_LONG).show();
                }
            }});
        pro4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick ( View v ) {
                int c = sqlitehelper.sumpro4();
                if(c==0){
                    Toast.makeText(allfoodbudgets.this,"record is empty", Toast.LENGTH_LONG).show();
                }else
                {   String carbstotal=Integer.toString(c);
                    n10.setText(carbstotal);
                    Toast.makeText(allfoodbudgets.this,"record shown below", Toast.LENGTH_LONG).show();
                }
            }});
        vita1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick ( View v ) {
                int c = sqlitehelper.sumvita1();
                if(c==0){
                    Toast.makeText(allfoodbudgets.this,"record is empty", Toast.LENGTH_LONG).show();
                }else
                {   String carbstotal=Integer.toString(c);
                    n3.setText(carbstotal);
                    Toast.makeText(allfoodbudgets.this,"record shown below", Toast.LENGTH_LONG).show();
                }
            }});
        pro2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick ( View v ) {
                int c = sqlitehelper.sumpro2();
                if(c==0){
                    Toast.makeText(allfoodbudgets.this,"record is empty", Toast.LENGTH_LONG).show();
                }else
                {   String carbstotal=Integer.toString(c);
                    n6.setText(carbstotal);
                    Toast.makeText(allfoodbudgets.this,"record shown below", Toast.LENGTH_LONG).show();
                }
            }});
        pro1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick ( View v ) {
                int c = sqlitehelper.sumpro1();
                if(c==0){
                    Toast.makeText(allfoodbudgets.this,"record is empty", Toast.LENGTH_LONG).show();
                }else
                {   String carbstotal=Integer.toString(c);
                    n2.setText(carbstotal);
                    Toast.makeText(allfoodbudgets.this,"record shown below", Toast.LENGTH_LONG).show();
                }
            }});
        cabs3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick ( View v ) {
                int c = sqlitehelper.sumcabs3();
                if(c==0){
                    Toast.makeText(allfoodbudgets.this,"record is empty", Toast.LENGTH_LONG).show();
                }else
                {   String carbstotal=Integer.toString(c);
                    n7.setText(carbstotal);
                    Toast.makeText(allfoodbudgets.this,"record shown below", Toast.LENGTH_LONG).show();
                }
            }});
        cabs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick ( View v ) {
                int c = sqlitehelper.sumcabs2();
                if(c==0){
                    Toast.makeText(allfoodbudgets.this,"record is empty", Toast.LENGTH_LONG).show();
                }else
                {   String carbstotal=Integer.toString(c);
                    n4.setText(carbstotal);
                    Toast.makeText(allfoodbudgets.this,"record shown below", Toast.LENGTH_LONG).show();
                }
            }});


        cabs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick ( View v ) {
                int c = sqlitehelper.sumcabs();
                if(c==0){
                    Toast.makeText(allfoodbudgets.this,"record is empty", Toast.LENGTH_LONG).show();
                }else
                    {   String carbstotal=Integer.toString(c);
                        n1.setText(carbstotal);
                        Toast.makeText(allfoodbudgets.this,"record shown below", Toast.LENGTH_LONG).show();
                }
            }});
                vitaproresult.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick ( View v )
                                       {
                                           Cursor data = sqlitehelper.getdata4();
                                           if(data.getCount()==0){
                                               // show message
                                               showmessage("ERROR","No record found");
                                           }
                                           StringBuffer buffer= new StringBuffer();
                                           while(data.moveToNext()){
                                               buffer.append("id :"+data.getInt(0));
                                               buffer.append("\n");
                                               buffer.append("vitamins :"+data.getString(1));
                                               buffer.append("\n");
                                               buffer.append("quantity :"+data.getString(2));
                                               buffer.append("\n");
                                               buffer.append("price :"+data.getString(3));
                                               buffer.append("\n");
                                               buffer.append("vitamins total :"+data.getString(4));
                                               buffer.append("\n");
                                               buffer.append("proteins :"+data.getString(5));
                                               buffer.append("\n");
                                               buffer.append("quantity :"+data.getString(6));
                                               buffer.append("\n");
                                               buffer.append("price :"+data.getString(7));
                                               buffer.append("\n");
                                               buffer.append("proteins total :"+data.getString(8));
                                               buffer.append("\n");
                                               buffer.append("\n");
                                           }
                                           showmessage("Data",buffer.toString());
                                       }

                                   }
        );
        //view cabs and vita table
        cabsvitaresult.setOnClickListener(new View.OnClickListener() {
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
                                               buffer.append("id :"+data.getInt(0));
                                               buffer.append("\n");
                                               buffer.append("carbohydrates :"+data.getString(1));
                                               buffer.append("\n");
                                               buffer.append("quantity :"+data.getString(2));
                                               buffer.append("\n");
                                               buffer.append("price :"+data.getString(3));
                                               buffer.append("\n");
                                               buffer.append("carboydrates total :"+data.getString(4));
                                               buffer.append("\n");
                                               buffer.append("vitamins :"+data.getString(5));
                                               buffer.append("\n");
                                               buffer.append("quantity :"+data.getString(6));
                                               buffer.append("\n");
                                               buffer.append("price :"+data.getString(7));
                                               buffer.append("\n");
                                               buffer.append("vitamins total :"+data.getString(8));
                                               buffer.append("\n");
                                               buffer.append("\n");
                                           }
                                           showmessage("Data",buffer.toString());
                                       }

                                   }
        );

        //view cabs and protein table
        cabsproresult.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick ( View v )
                                       {
                                           Cursor data = sqlitehelper.getdata2();
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
                                               buffer.append("price :"+data.getString(3));
                                               buffer.append("\n");
                                               buffer.append("carbohydrates total :"+data.getString(4));
                                               buffer.append("\n");
                                               buffer.append("proteins :"+data.getString(5));
                                               buffer.append("\n");
                                               buffer.append("quantity :"+data.getString(6));
                                               buffer.append("\n");
                                               buffer.append("price :"+data.getString(7));
                                               buffer.append("\n");
                                               buffer.append("proteins total :"+data.getString(8));
                                               buffer.append("\n");
                                               buffer.append("\n");
                                           }
                                           showmessage("Data",buffer.toString());
                                       }

                                   }
        );

        balancedresult.setOnClickListener(new View.OnClickListener()
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
                                               buffer.append("carbohydrates quantity :"+data.getString(2));
                                               buffer.append("\n");
                                               buffer.append("price :"+data.getString(3));
                                               buffer.append("\n");
                                               buffer.append("carbohydrates total :"+data.getString(4));
                                               buffer.append("\n");
                                               buffer.append("proteins :"+data.getString(5));
                                               buffer.append("\n");
                                               buffer.append("quantity :"+data.getString(6));
                                               buffer.append("\n");
                                               buffer.append("proteins total :"+data.getString(7));
                                               buffer.append("\n");
                                               buffer.append("vitamins :"+data.getString(8));
                                               buffer.append("\n");
                                               buffer.append("quantity :"+data.getString(9));
                                               buffer.append("\n");
                                               buffer.append("price :"+data.getString(10));
                                               buffer.append("\n");
                                               buffer.append("vitamins total :"+data.getString(11));
                                               buffer.append("\n");
                                               buffer.append("\n");

                                           }
                                           showmessage("Balanced diet",buffer.toString());
                                       }

                                   }

        );

    }
    public void showmessage(String title,String message)
    {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }
    }
