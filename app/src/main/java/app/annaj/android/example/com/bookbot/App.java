package app.annaj.android.example.com.bookbot;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by Anna on 12/11/2015.*/

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        // Register any ParseObject subclass. Must be done before calling Parse.initialize()
       // ParseObject.registerSubclass(RegisterActivity.class);

        Parse.initialize(this, "0kdUktjfQ6J0SErK6dI40vRSiwHI2AdCTgCNNJtb", "fT7NrKkGcy1vMXkB6xfMFDF26MIQ8hM3FMVY3AHT");
    }
}



