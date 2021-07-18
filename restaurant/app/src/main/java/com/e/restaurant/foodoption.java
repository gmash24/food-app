package com.e.restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class foodoption extends AppCompatActivity {
    Button CP,BALANCED,CV,VP;
    @Override

    protected void onCreate ( Bundle savedInstanceState )
    {
        setContentView(R.layout.foodoption);
        super.onCreate(savedInstanceState);
        CP = findViewById(R.id.cp);
        BALANCED =findViewById(R.id.balanced);
        CV=findViewById(R.id.cv);
        VP=findViewById(R.id.vp);

        BALANCED.setOnClickListener(new View.OnClickListener()
                              {
                                  @Override
                                  public void onClick ( View v ) {
                                      Intent intent = new Intent(foodoption.this, balanced.class);
                                      startActivity(intent);
                                  }
                              }
        );
        VP.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick ( View v ) {
                Intent intent = new Intent(foodoption.this, vitaminprotein.class);
                startActivity(intent);
            }
    }
    );

        CV.setOnClickListener(new View.OnClickListener()
                              {
                                  @Override
                                  public void onClick ( View v ) {
                                      Intent intent = new Intent(foodoption.this, carbohydratesvitamin.class);
                                      startActivity(intent);
                                  }
                              }
        );
        CP.setOnClickListener(new View.OnClickListener()
                              {
                                  @Override
                                  public void onClick ( View v ) {
                                      Intent intent = new Intent(foodoption.this, carbohydratesproteins.class);
                                      startActivity(intent);
                                  }
                              }
        );
    }


}




