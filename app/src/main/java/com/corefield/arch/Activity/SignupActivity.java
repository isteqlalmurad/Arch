package com.corefield.arch.Activity;




import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.corefield.arch.R;


public class SignupActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);




    }

    public void BackToSignUP(View view) {

        finish();

    }


}
