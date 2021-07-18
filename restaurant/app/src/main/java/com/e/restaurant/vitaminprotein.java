package com.e.restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class vitaminprotein extends AppCompatActivity {
    Button apl,orng,bnn,mng,kls,cbg,spnch,bro,msrm,tg;
    DBHelper sqLiteHelper;
    TextView vresult,presult;
    EditText foodname1,quantity1,pricee1;
    EditText foodname2,quantity2,pricee2;
    Button add,reg;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vitaminproteins);
        foodname1 = findViewById(R.id.food1);
        quantity1 = findViewById(R.id.quantity1);
        pricee1 = findViewById(R.id.price1);
        foodname2 = findViewById(R.id.food2);
        quantity2 = findViewById(R.id.quantity2);
        pricee2 = findViewById(R.id.price2);
        presult = findViewById(R.id.result1);
        vresult = findViewById(R.id.result2);
        add= findViewById(R.id.addfood);
        sqLiteHelper = new DBHelper(vitaminprotein.this);

        reg = findViewById(R.id.proccedtoproteins);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick ( View v ) {
                String strfoodname1=foodname1.getText().toString();
                String strquantity1=quantity1.getText().toString();
                String strprice1=pricee1.getText().toString();
                String strfoodname2=foodname2.getText().toString();
                String strquantity2=quantity2.getText().toString();
                String strprice2= pricee2.getText().toString();
                if (
                        strfoodname2.trim().equals("") ||strfoodname1.trim().equals("")||strquantity1.trim().equals("")||strquantity2.trim().equals("")|| strprice1.trim().equals("") || strprice2.trim().equals("") )
                {
                    Toast.makeText(vitaminprotein.this, "please insert required data ", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {

                    Intent intent = new Intent(vitaminprotein.this, vitaminproteinresult.class);
                startActivity(intent);}
            }
        });
        add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick ( View v )
            {
                String strfoodname2=foodname2.getText().toString();
                String strquantity2=quantity2.getText().toString();
                String strprice2= pricee2.getText().toString();
                String strfoodname1=foodname1.getText().toString();
                String strquantity1=quantity1.getText().toString();
                String strprice1=pricee1.getText().toString();

                String mynum3=quantity1.getText().toString();
                float mnum3= Float.parseFloat(mynum3);

                String mynum4=pricee1.getText().toString();
                float mnum4= Float.parseFloat(mynum4);

                float res1=mnum3*mnum4;
                presult.setText(String.valueOf(res1));

                String mynum5=quantity2.getText().toString();
                float mnum5= Float.parseFloat(mynum5);

                String mynum6=pricee2.getText().toString();
                float mnum6= Float.parseFloat(mynum6);

                float res2=mnum5*mnum6;
                vresult.setText(String.valueOf(res2));


                if (
                        strfoodname1.trim().equals("") ||strfoodname2.trim().equals("") ||strquantity1.trim().equals("")||strquantity2.trim().equals("")|| strprice1.trim().equals("") || strprice2.trim().equals("") )
                {
                    Toast.makeText(vitaminprotein.this, "please insert required data ", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {

                    boolean insertdata1= sqLiteHelper.insertvita3(
                        ( foodname2.getText().toString()),
                        quantity2.getText().toString(),
                        pricee2.getText().toString(),
                            vresult.getText().toString(),

                            foodname1.getText().toString(),
                    quantity1.getText().toString(),
                            pricee1.getText().toString(),
                            presult.getText().toString());
                if(insertdata1=true)
                    Toast.makeText(vitaminprotein.this,"food inserted", Toast.LENGTH_LONG).show();
                else{
                    Toast.makeText(vitaminprotein.this,"Failed to insert", Toast.LENGTH_LONG).show();
            }

        }


    }
});

}}