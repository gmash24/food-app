package com.e.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class food extends AppCompatActivity {
    Button reg,reg2,reg3,reg4;
    @Override

    protected void onCreate ( Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food);
         reg=findViewById(R.id.nutrientsbutton);
         reg2=findViewById(R.id.diet);
       reg3=findViewById(R.id.budget);
       reg4=findViewById(R.id.bmi);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick ( View v ) {
                Intent intent = new Intent(food.this, foodinfo.class);
                startActivity(intent);
            }

        }
        );
        reg2.setOnClickListener(new View.OnClickListener()
                              {
                                  @Override
                                  public void onClick ( View v ) {
                                      Intent intent = new Intent(food.this, foodoption.class);
                                      startActivity(intent);
                                  }
                              }
        );
        reg3.setOnClickListener(new View.OnClickListener()
                              {
                                  @Override
                                  public void onClick ( View v ) {
                                      Intent intent = new Intent(food.this, allfoodbudgets.class);
                                      startActivity(intent);
                                  }
                              }
        );
        reg4.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick ( View v ) {
                                       Intent intent = new Intent(food.this, bmi.class);
                                       startActivity(intent);
                                   }

                               }
        );


    }


}