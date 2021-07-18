package com.e.restaurant;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    Button LogInButton, RegisterButton;
    EditText firstname,lastname,username, Password;
    String usernameholder, PasswordHolder;
    Boolean EditTextEmptyHolder;
    DBHelper sqLiteHelper;
    SQLiteDatabase sqLiteDatabaseObj;


    @Override
    protected void onCreate ( Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        LogInButton = findViewById(R.id.loginbutton);
        RegisterButton = findViewById(R.id.registerbutton);

        firstname = findViewById(R.id.FIRSTNAME);
        lastname = findViewById(R.id.LASTNAME);
        username = findViewById(R.id.USERNAME);
        Password = findViewById(R.id.PASSWORD);


        sqLiteHelper = new DBHelper(this);
        addData();

        //Adding click listener to log in button.
        LogInButton.setOnClickListener(new View.OnClickListener()
                                       {
                                           @Override

                                           public void onClick ( View view )
                                           {
                                               Intent intent = new Intent(Register.this, user.class);
                                               Register.this.startActivity(intent);
                                           }
                                       }
        );


    }


    public void addData()
    {
        // Adding click listener to register button.


        RegisterButton.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick ( View v )
                    {
                        boolean insertdata1= sqLiteHelper.insertdata
                                (
                                        firstname.getText().toString(),
                                        lastname.getText().toString(),
                                        username.getText().toString(),
                                        Password.getText().toString());
                        if(insertdata1=true)
                            Toast.makeText(Register.this,"User Registered Successfully", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Register.this,"Failed to insert", Toast.LENGTH_LONG).show();

                        CheckEditTextStatus();
                        RegisterinFunction ();
                    }

                    public void CheckEditTextStatus()
                    {

                        // Getting value from All EditText and storing into String Variables.
                        usernameholder = username.getText().toString();
                        PasswordHolder = Password.getText().toString();

                        // Checking EditText is empty or no using TextUtils.
                        if( TextUtils.isEmpty(usernameholder) || TextUtils.isEmpty(PasswordHolder)){

                            EditTextEmptyHolder = false ;

                        }
                        else {

                            EditTextEmptyHolder = true ;
                        }
                       // if (CheckEditTextStatus();= true)
                    }


                    // Login function starts from here.
                    public void RegisterinFunction ()
                    {

                        if (EditTextEmptyHolder)
                        {
                            // Opening SQLite database write permission.
                            sqLiteDatabaseObj = sqLiteHelper.getWritableDatabase();

                        } else
                            {
                            //If any of login EditText empty then this block will be executed.
                            Toast.makeText(Register.this, "Please Enter UserName or Password.", Toast.LENGTH_LONG).show();

                        }
                    }

                }
        );



    }

}

