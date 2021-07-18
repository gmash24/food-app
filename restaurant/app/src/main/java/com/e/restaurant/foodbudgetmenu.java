package com.e.restaurant;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class foodbudgetmenu extends AppCompatActivity {
    Button CiP,BALANCED,CiV,ViP;
    @Override

    protected void onCreate ( Bundle savedInstanceState ) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.budgetmenu);
        CiP = findViewById(R.id.cp);
        BALANCED =findViewById(R.id.balanced);
        CiV=findViewById(R.id.cv);
        ViP=findViewById(R.id.vp);

        BALANCED.setOnClickListener(new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick ( View v ) {
                                            Intent intent = new Intent(foodbudgetmenu.this, balancedbudget.class);
                                            startActivity(intent);
                                        }
                                    }
        );
        ViP.setOnClickListener(new View.OnClickListener()
                              {
                                  @Override
                                  public void onClick ( View v ) {
                                      Intent intent = new Intent(foodbudgetmenu.this, vitaminproteinbudget.class);
                                      startActivity(intent);
                                  }
                              }
        );

        CiV.setOnClickListener(new View.OnClickListener()
                              {
                                  @Override
                                  public void onClick ( View v ) {
                                      Intent intent = new Intent(foodbudgetmenu.this, carbohydratesvitaminbudget.class);
                                      startActivity(intent);
                                  }
                              }
        );
        CiP.setOnClickListener(new View.OnClickListener()
                              {
                                  @Override
                                  public void onClick ( View v ) {
                                      Intent intent = new Intent(foodbudgetmenu.this, carbohydratesproteinsbudget.class);
                                      startActivity(intent);
                                  }
                              }
        );
    }
    }

