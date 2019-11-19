package com.corefield.arch.Activity;




import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.corefield.arch.DATABASE.SignupDatabaseManager;
import com.corefield.arch.R;


public class SignupActivity extends AppCompatActivity {

   private SignupDatabaseManager  signupDatabaseManager;

   private  Button signUp ;
   private  TextView userName ;
   private  TextView fullName ;
   private  TextView email ;
   private  TextView password ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

         signUp = findViewById(R.id.btn_singup);
         userName = findViewById(R.id.et_creat_account_user_name);
         fullName = findViewById(R.id.et_Creat_account_full_name);
         email = findViewById(R.id.et_email);
         password = findViewById(R.id.et_second_password);


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String txt1 = userName.getText().toString();
                String txt2 = fullName.getText().toString();
                String txt3 = email.getText().toString();
                String txt4 = password.getText().toString();

                signupDatabaseManager = new SignupDatabaseManager(getApplicationContext());
                signupDatabaseManager.open();
                signupDatabaseManager.insert(txt1,txt2,txt3,txt4);
                signupDatabaseManager.close();
                Toast.makeText(SignupActivity.this, "User Successfully Added", Toast.LENGTH_SHORT).show();

                finish();

            }
        });



    }

    public void BackToSignUP(View view) {

        finish();

    }


}
