package app.annaj.android.example.com.bookbot;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class BookListingActivity extends AppCompatActivity {
    // Declare Variables
    ListView listview;
    List<ParseObject> ob;
    ProgressDialog mProgressDialog;
    ArrayAdapter<String> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from listview_main.xml
        setContentView(R.layout.listview_main);

        // Execute RemoteDataTask AsyncTask
        new RemoteDataTask().execute();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id=item.getItemId();
        switch (id){
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.browsebook_menu, menu);
        return true;
    }

    // RemoteDataTask AsyncTask
    private class RemoteDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(BookListingActivity.this);
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            // Locate the class table named "BookPosts" in Parse.com
            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(
                    "BookPosts");
            query.orderByDescending("_created_at");
            try {
                ob = query.find();
            } catch (ParseException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Locate the listview in listview_main.xml
            listview = (ListView) findViewById(R.id.listview);
            // Pass the results into an ArrayAdapter
            adapter = new ArrayAdapter<String>(BookListingActivity.this,
                    R.layout.listview_item);
            // Retrieve object "newPost" from Parse.com database
            for (ParseObject bookPosts : ob) {
                adapter.add((String) bookPosts.get("newPost"));
            }
            // Binds the Adapter to the ListView
            listview.setAdapter(adapter);
            // Close the progressdialog
            mProgressDialog.dismiss();
            // Capture button clicks on ListView items
            listview.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    // Send single item click data to SingleItemView Class
                    Intent i = new Intent(BookListingActivity.this,
                            SingleItemView.class);
                    // Pass data "newPost" and "user" followed by the position
                    i.putExtra("newPost", ob.get(position).getString("newPost")
                            .toString());
                    i.putExtra("user",ob.get(position).get("user").toString());
                    // Open SingleItemView.java Activity
                    startActivity(i);
                }
            });
        }
    }
}