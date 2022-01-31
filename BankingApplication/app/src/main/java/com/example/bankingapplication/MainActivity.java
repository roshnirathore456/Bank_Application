package com.example.bankingapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView image=findViewById(R.id.image);
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.fade);
        image.startAnimation(animation);


         Thread timer= new Thread()
         {
             @Override
             public void run() {
                 try {
                     sleep(8000);
                     Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                     startActivity(intent);
                     finish();
                     super.run();



                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }


             }
         };
         timer.start();


    }


}

