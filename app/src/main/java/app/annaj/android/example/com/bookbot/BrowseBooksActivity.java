package app.annaj.android.example.com.bookbot;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.parse.Parse;
import com.parse.ParseUser;

public class BrowseBooksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_books);


         Parse.enableLocalDatastore(this);
         Parse.initialize(this);

        ParseUser currentUser = ParseUser.getCurrentUser();
       /* if (currentUser != null) {
            // do stuff with the user



        } else {
            // show the signup or login screen

            Intent takeUserToLogin=new Intent(this,LoginActivity.class);
            startActivity(takeUserToLogin);
        }*/

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ///float btn
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //inflate menu.add items to action bar
        getMenuInflater().inflate(R.menu.browsebooks, menu);
        return true; //super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle action bar item clicks here
        //will automatically handle clicks on the Bowse book page
        //as long as you specify a parent activity in manifest.xml

        int id=item.getItemId();
        switch (id){
            case R.id.createNewPost:
                //take user to post activity

                Intent intent=new Intent(this,CreatNewPostActivity.class);
                startActivity(intent);
                break;

            case R.id.logoutUser:
                //log out with Parse
                ParseUser.logOut();
                //take back to log in screen
                Intent takeUSerToLogin=new Intent(this,LoginActivity.class);
                startActivity(takeUSerToLogin);

                break;


            case R.id.scannerMenu:
                //take to scanner

                break;


        }

        return super.onOptionsItemSelected(item);
    }


}
