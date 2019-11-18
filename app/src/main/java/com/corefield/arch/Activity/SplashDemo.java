package com.corefield.arch.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.corefield.arch.R;


public class SplashDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_demo);
        ImageView imageView = findViewById(R.id.img_splash);

        Animation animZoomIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
        imageView.startAnimation(animZoomIn);
        LogoLauncher logoLauncher = new LogoLauncher();
        logoLauncher.start();


    }

    private class LogoLauncher extends Thread {


        public void run() {
            try {
                sleep((long) (1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Intent intent = new Intent(SplashDemo.this, LoginActivity.class);
            startActivity(intent);
            SplashDemo.this.finish();
        }
    }
}
