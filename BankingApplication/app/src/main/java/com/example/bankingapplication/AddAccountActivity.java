package com.example.bankingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddAccountActivity extends AppCompatActivity {
    EditText aname, anum,email , ifsc,phn,amount;
    FloatingActionButton floatingActionButton;
    Button add;
    UserHelper userHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);
        userHelper = new UserHelper(this);

        aname = findViewById(R.id.aname);
        anum = findViewById(R.id.anum);
        amount = findViewById(R.id.amount);
        ifsc = findViewById(R.id.ifsc);
        email=findViewById(R.id.email);
        phn=findViewById(R.id.phn);
        add = findViewById(R.id.add);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),UsersList.class);
                startActivity(intent);
            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                processInsert(aname.getText().toString(),anum.getText().toString(),email.getText().toString(),ifsc.getText().toString(),phn.getText().toString(),amount.getText().toString());
            }
        });

    }
    private void processInsert(String aname, String anum, String amount,String email,String phn,String ifsc)
    {
        String res=new UserHelper(this).addRecords(aname,anum,amount,email,phn,ifsc, 1);
        Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(getApplicationContext(),UsersList.class);
        startActivity(intent);
    }
}
