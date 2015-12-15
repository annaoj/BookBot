package app.annaj.android.example.com.bookbot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.parse.ParseUser;

public class UserHomePageActivity extends AppCompatActivity {

    protected Button mBookList;
    protected Button mPostBook;
    protected Button mScanner;
    protected Button mSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mBookList = (Button) findViewById(R.id.btnBookListing);
        mPostBook = (Button) findViewById(R.id.btnPostyourbookHP);
        mScanner = (Button) findViewById(R.id.btnScannerHP);
        mSearch = (Button) findViewById(R.id.btnSearch);

        //listen to when Book Listing  btn is clicked
mBookList.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent takeUserToList=new Intent(UserHomePageActivity.this,BrowseBooksActivity.class);
        startActivity(takeUserToList);
    }
});
        //listen to when Post your book  btn is clicked
mPostBook.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent takeUserToPost=new Intent(UserHomePageActivity.this,CreatNewPostActivity.class);
        startActivity(takeUserToPost);
    }
});
        //listen to when Scanner  btn is clicked

        //listen to when Search  btn is clicked






        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.browsebook_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.createNewPost:
                //take user to post activity

                Intent intent = new Intent(this, CreatNewPostActivity.class);
                startActivity(intent);
                break;

            case R.id.logoutUser:
                //log out with Parse
                ParseUser.logOut();
                //take back to log in screen
                Intent takeUSerToLogin = new Intent(this, LoginActivity.class);
                startActivity(takeUSerToLogin);

                break;


            case R.id.action_settings:
                //take to scanner

                break;


        }

        return super.onOptionsItemSelected(item);
    }

}
