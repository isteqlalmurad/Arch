package com.corefield.arch.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.corefield.arch.R;



public class LoginActivity extends AppCompatActivity {

    private EditText mNameEditText;
    private EditText mPasswordEditText;
    private TextView mInfoTextView;
    private Button mLoginButton;
    private int mCounter = 5;
    private Boolean mActive = true;
    private Handler handler;
    private TextView mTextField;
    private String userName;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        mNameEditText = findViewById(R.id.etUsername);
        mPasswordEditText = findViewById(R.id.etPassword);
        mInfoTextView = findViewById(R.id.counter);
        mTextField = findViewById(R.id.tvcounter);
        mLoginButton = findViewById(R.id.btnLogin);
        mInfoTextView.setText(String.valueOf(mCounter));
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text1 = mNameEditText.getText().toString();
                String text2 = mPasswordEditText.getText().toString();

                if ((mNameEditText.getText().toString()).equals("alpha" ) && (mPasswordEditText.getText().toString()).equals("123")) {
                    Intent murad = new Intent(LoginActivity.this, MainActivity.class);
                    murad.putExtra("ET", text1);
                    murad.putExtra("EN", text2);

                    startActivity(murad);

                } else {
                    Toast.makeText(LoginActivity.this, "error", Toast.LENGTH_SHORT).show();

                    mCounter--;
                    mInfoTextView.setText(String.valueOf(mCounter));
                    if (mCounter <= 0) {
                        mLoginButton.setEnabled(false);
                        handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                mLoginButton.setEnabled(true);
                            }
                        }, 10000);

                        new CountDownTimer(10000, 1000) {

                            public void onTick(long millisUntilFinished) {
                                mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
                                //here you can have your logic to set text to edittext
                            }

                            public void onFinish() {
                                mTextField.setText("reset");
                                mCounter = 5;
                                mInfoTextView.setText(String.valueOf(mCounter));

                            }
                        }.start();
                    }
                }
            }

        });

    }

                               public void AddUser(View view) {

                                     TextView etCreateAccount;

                                     etCreateAccount = findViewById(R.id.etCreateAccount);

                                     Intent intent = new Intent(LoginActivity.this, SignupActivity.class);

                                     startActivity(intent);



    }
}

