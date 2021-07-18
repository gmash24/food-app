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

public class carbohydratesvitamin extends AppCompatActivity
{
    DBHelper sqLiteHelper;
    EditText foodname,quantity,pricee;
    EditText foodname2,quantity2,pricee2;
    Button add,reg;
    TextView cresult,vresult;
    String[] mycarbo =new String[10] ;
    @Override
    protected void onCreate ( Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carbohydratesvitamins);
        foodname = findViewById(R.id.food);
        quantity = findViewById(R.id.quantity);
        pricee = findViewById(R.id.price);
        foodname2 = findViewById(R.id.food2);
        quantity2 = findViewById(R.id.quantity2);
        pricee2 = findViewById(R.id.price2);
        cresult = findViewById(R.id.result);
        vresult = findViewById(R.id.result2);

        add= findViewById(R.id.addfood);
        reg = findViewById(R.id.proccedtovitamins);
        sqLiteHelper = new DBHelper(carbohydratesvitamin.this);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick ( View v ) {
                String strfoodname= foodname.getText().toString();
                String strquantity= quantity.getText().toString();
                String strprice= pricee.getText().toString();
                String strfoodname2=foodname2.getText().toString();
                String strquantity2=quantity2.getText().toString();
                String strprice2= pricee2.getText().toString();

                if (
                        strfoodname.trim().equals("") ||strfoodname2.trim().equals("") || strquantity.trim().equals("") || strquantity2.trim().equals("") ||strprice.trim().equals("") ||strprice2.trim().equals("") )
                {
                    Toast.makeText(carbohydratesvitamin.this, "please insert required data ", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    Intent intent = new Intent(carbohydratesvitamin.this, carbohydratesvitaminresult.class);
                startActivity(intent);
            }}
        });
        add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick ( View v )
            {
                String strfoodname= foodname.getText().toString();
                String strquantity= quantity.getText().toString();
                String strprice= pricee.getText().toString();
                String strfoodname2=foodname2.getText().toString();
                String strquantity2=quantity2.getText().toString();
                String strprice2= pricee2.getText().toString();
                String mynum1=quantity.getText().toString();
                float mnum1= Float.parseFloat(mynum1);

                String mynum2=pricee.getText().toString();
                float mnum2= Float.parseFloat(mynum2);

                float res=mnum1*mnum2;
                cresult.setText(String.valueOf(res));


                String mynum5=quantity2.getText().toString();
                float mnum5= Float.parseFloat(mynum5);

                String mynum6=pricee2.getText().toString();
                float mnum6= Float.parseFloat(mynum6);

                float res2=mnum5*mnum6;
                vresult.setText(String.valueOf(res2));



                if (
                        strfoodname.trim().equals("") ||strfoodname2.trim().equals("") || strquantity.trim().equals("") || strquantity2.trim().equals("") ||strprice.trim().equals("") ||strprice2.trim().equals("") )
                {
                    Toast.makeText(carbohydratesvitamin.this, "please insert required data ", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {

                    boolean insertdata1= sqLiteHelper.insertcabo2(
                        (foodname.getText().toString()),
                         quantity.getText().toString(),
                         pricee.getText().toString(),
                            cresult.getText().toString(),

                            foodname2.getText().toString(),
                            quantity2.getText().toString(),
                            pricee2.getText().toString(),
                            vresult.getText().toString());

                sqLiteHelper = new DBHelper(carbohydratesvitamin.this);
                if(insertdata1=true)
                    Toast.makeText(carbohydratesvitamin.this,"food inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(carbohydratesvitamin.this,"Failed to insert", Toast.LENGTH_LONG).show();
            }}

        });
    }

}
