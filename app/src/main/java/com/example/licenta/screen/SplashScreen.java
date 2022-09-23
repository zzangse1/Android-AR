package com.example.licenta.screen;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.licenta.MainActivity;
import com.example.licenta.R;


public class SplashScreen extends AppCompatActivity {


    protected void onCreate(Bundle savedInstance) {

        super.onCreate(savedInstance);



        Thread timer1 = new Thread(){
            @Override
            public void run(){
                try{
                    sleep(3000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally{

                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                }


            }
        };
        timer1.start();
    }

}