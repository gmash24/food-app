package com.e.restaurant;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class user extends AppCompatActivity
{

        Button LogInButton, RegisterButton;
        DBHelper sqLiteHelper;
        private EditText name;
        private EditText pass;
@Override
protected void onCreate ( Bundle savedInstanceState ) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    sqLiteHelper = new DBHelper(user.this);

    //Declaration of button variables with
    LogInButton = findViewById(R.id.logindetails);
    RegisterButton = findViewById(R.id.registermenu);

    name = findViewById(R.id.USERNAME);
    pass = findViewById(R.id.password);


    RegisterButton.setOnClickListener(new View.OnClickListener() {
                                          @Override

                                          public void onClick ( View view ) {
                                              Intent intent = new Intent(user.this, Register.class);
                                              startActivity(intent);
                                          }
                                      }
    );

    LogInButton.setOnClickListener(
            new View.OnClickListener() {
                @Override

                public void onClick ( View v ) {

                    String name2 = name.getText().toString();
                    String password2 = pass.getText().toString();
                    sqLiteHelper = new DBHelper(user.this);
                    if (
                            sqLiteHelper.checkUserLogin(name2, password2)) {
                        Intent intent = new Intent(user.this,food.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_LONG).show();

                    } else
                        {
                        Toast.makeText(getApplicationContext(), "You are not Registerd!", Toast.LENGTH_LONG).show();

                    }

                }
            });


}}
