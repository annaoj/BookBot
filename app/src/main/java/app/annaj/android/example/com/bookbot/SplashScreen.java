package app.annaj.android.example.com.bookbot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_screen);
        Thread splashThread=new Thread(){
            public void run(){
                try {
                    sleep(3000);
                    Intent startBrowseBook=new Intent(getApplicationContext(),BrowseBooksActivity.class);
                    startActivity(startBrowseBook);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        splashThread.start();
    }
}
