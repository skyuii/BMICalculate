package com.example.bmicalculate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



       Toast t2 = Toast.makeText(this, "Android",Toast.LENGTH_SHORT);
       t2.show();



       Button startButton = findViewById(R.id.start_button);
       startButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast t = Toast.makeText(SplashActivity.this, "Hello",Toast.LENGTH_SHORT);
               t.show();
           }
       });

        Toast t3 = Toast.makeText(this, "Studio",Toast.LENGTH_SHORT);
        t2.show();

        Button exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //startButton.setText("เริ่มต้น"); //change button name

        //MyListener listener = new MyListener();

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

        //startButton.setOnClickListener(this);
    }

    /*@Override
    public void onClick(View v) {
        Log.d("bmi","Hello Android");
    }

    private class MyListener implements View.OnClickListener {


        @Override
        public void onClick(View v) {
            Log.d("bmi","ok");
        }
    }*/
}
