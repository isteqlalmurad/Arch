package com.corefield.arch.Activity;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.corefield.arch.R;

public class TrialActivity extends AppCompatActivity {

    private TextView ReciveText1, ReciveText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trial);

        ReciveText1 = findViewById(R.id.ReciveText1);
        ReciveText2 = findViewById(R.id.ReciveText2);

        String text = getIntent().getStringExtra("ET");
        String number = getIntent().getStringExtra("EN");

        ReciveText1.setText(text);
        ReciveText2.setText(number);



        Back();

            }


    public void Back(){

        Button mButtonLogin = findViewById(R.id.mButtonLogin);
        mButtonLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });


    }
}




