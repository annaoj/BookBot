package app.annaj.android.example.com.bookbot;

/**
 * Created by Anna on 12/11/2015.

public class Parse extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        // Register any ParseObject subclass. Must be done before calling Parse.initialize()
        ParseObject.registerSubclass(RegisterActivity.class);

        Parse.initialize(this, "APPLICATION_ID", "CLIENT_KEY");
    }
}



<meta-data
        android:name="com.parse.APPLICATION_ID"
        android:value="0kdUktjfQ6J0SErK6dI40vRSiwHI2AdCTgCNNJtb" />
<meta-data
        android:name="com.parse.CLIENT_KEY"
        android:value="fT7NrKkGcy1vMXkB6xfMFDF26MIQ8hM3FMVY3AHT" />*/