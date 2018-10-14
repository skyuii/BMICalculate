package com.example.bmicalculate;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculateButton = findViewById(R.id.calculate_button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText heightEditText = findViewById(R.id.height_edit_text);
                EditText weightEditText = findViewById(R.id.weight_edit_text);
                int h = Integer.parseInt(heightEditText.getText().toString());
                int w = Integer.parseInt(weightEditText.getText().toString());
                float bmi = calculateBMI(h,w);

                String resulText = null;

                if(bmi < 18.5){
                    resulText = "ผอมเกินไป";
                }
                else if(bmi < 25){
                    resulText = "น้ำหนักปกติ";
                }
                else if(bmi < 30){
                    resulText = "อ้วน";
                }
                else {
                    resulText = "อ้วนมาก";
                }
               // String msg = "ค่า BMI เท่ากับ " + String.format(Locale.US,"%.2f",bmi);
                String msg = "น้ำหนักของุณอยู่ในเกณฑ์ " + resulText;
                //heightEditText.getText().toString();

                Toast t = Toast.makeText(MainActivity.this ,
                        msg,
                        Toast.LENGTH_LONG);
                t.show();

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("RESULT");
                dialog.setMessage(msg);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        //todo: code when people click ok

                    }
                });
                dialog.setNegativeButton("NO",null);
                dialog.setCancelable(false);
                dialog.show();



            }
        });
    }

    private float calculateBMI(int heightInCm , int weightInKg){
        float height = heightInCm/100f;
        Log.i(TAG, "ความสูงหน่วยเมตร = " + String.valueOf(height));
        float bmi = weightInKg/(height * height);
        return bmi;
    }
}
