package com.e.restaurant;
import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Resources;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class carbohydratesproteins extends AppCompatActivity
{
    DBHelper sqLiteHelper;
    EditText foodname,quantity,pricee;
    EditText foodname1,quantity1,pricee1;
    TextView cresult,presult;
    Button add,reg;

    String[] mycarbo =new String[10] ;
    @Override
    protected void onCreate ( Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carbohydratesproteins);

        //sqLiteHelper = new DBHelper(carbohydrates.this);
        foodname = findViewById(R.id.food);
        quantity = findViewById(R.id.quantity);
        pricee = findViewById(R.id.price);
        foodname1 = findViewById(R.id.food1);
        quantity1 = findViewById(R.id.quantity1);
        pricee1 = findViewById(R.id.price1);
        cresult = findViewById(R.id.result);
        presult = findViewById(R.id.result1);

        add= findViewById(R.id.addfood);
        sqLiteHelper = new DBHelper(carbohydratesproteins.this);
        reg = findViewById(R.id.proccedtoproteins);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick ( View v ) {
                String strfoodname= foodname.getText().toString();
                String strquantity= quantity.getText().toString();
                String strprice= pricee.getText().toString();
                String strfoodname1=foodname1.getText().toString();
                String strquantity1=quantity1.getText().toString();
                String strprice1=pricee1.getText().toString();

                if (
                        strfoodname.trim().equals("") ||strfoodname1.trim().equals("") || strquantity1.trim().equals("")||strquantity.trim().equals("") || strprice.trim().equals("") || strprice1.trim().equals("") )
                {
                    Toast.makeText(carbohydratesproteins.this, "please insert required data ", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {

                Intent intent = new Intent(carbohydratesproteins.this, carbohydratesproteinsresult.class);
                startActivity(intent);}
            }
        });
        add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick ( View v )
            {
                String strfoodname= foodname.getText().toString();
                String strquantity= quantity.getText().toString();
                String strprice= pricee.getText().toString();
                String strfoodname1=foodname1.getText().toString();
                String strquantity1=quantity1.getText().toString();
                String strprice1=pricee1.getText().toString();

                String mynum1=quantity.getText().toString();
                float mnum1= Float.parseFloat(mynum1);

                String mynum2=pricee.getText().toString();
                float mnum2= Float.parseFloat(mynum2);

                float res=mnum1*mnum2;
                cresult.setText(String.valueOf(res));

                String mynum3=quantity1.getText().toString();
                float mnum3= Float.parseFloat(mynum3);

                String mynum4=pricee1.getText().toString();
                float mnum4= Float.parseFloat(mynum4);

                float res1=mnum3*mnum4;
                presult.setText(String.valueOf(res1));

                if (
                        strfoodname.trim().equals("") ||strfoodname1.trim().equals("") || strquantity1.trim().equals("")||strquantity.trim().equals("") || strprice.trim().equals("") || strprice1.trim().equals("")){
                        Toast.makeText(carbohydratesproteins.this, "please insert required data ", Toast.LENGTH_SHORT).show();
                        return;
                    } else
                        {
                        boolean insertdata1 = sqLiteHelper.insertcabo1(
                                (foodname.getText().toString()),
                                quantity.getText().toString(),
                                pricee.getText().toString(),
                                cresult.getText().toString(),

                                foodname1.getText().toString(),
                                    quantity1.getText().toString(),
                                    pricee1.getText().toString(),
                                presult.getText().toString());
                        sqLiteHelper = new DBHelper(carbohydratesproteins.this);
                        if (insertdata1 = true)
                            Toast.makeText(carbohydratesproteins.this, "food inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(carbohydratesproteins.this, "Failed to insert", Toast.LENGTH_LONG).show();
                    }}
                });


}  }
