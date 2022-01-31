package com.example.bankingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    EditText username1,pass1,cpass;
    Button  signup_btn;
    ApplicationDB applicationDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        applicationDB=new ApplicationDB(this);

        username1=findViewById(R.id.username1);
        pass1=findViewById(R.id.pass1);
        cpass=findViewById(R.id.cpass);
        signup_btn=findViewById(R.id.signup_btn);


        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username= username1.getText().toString().trim ();
                String pass=pass1.getText().toString().trim ();
                String cpassword= cpass.getText().toString().trim ();
                if(pass.equals(cpassword))
                {
                    applicationDB.addUser(username,pass);
                    Toast.makeText(SignUpActivity.this, "Signed up successfully", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(SignUpActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(SignUpActivity.this, "password is not matching", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}