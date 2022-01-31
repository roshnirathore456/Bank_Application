package com.example.bankingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText username,pass;
    Button login_btn,signup;
    ApplicationDB applicationDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        applicationDB = new ApplicationDB (this);

        username=findViewById(R.id.username);
        pass=findViewById(R.id.pass);
        login_btn=findViewById(R.id.login_btn);
        signup=findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user= username.getText().toString().trim ();
                String password= pass.getText().toString().trim ();
                Boolean res= applicationDB.checkUser(user , password);
                if(res == true)
                {
                    Intent intent=new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"successfully Loged in ",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}