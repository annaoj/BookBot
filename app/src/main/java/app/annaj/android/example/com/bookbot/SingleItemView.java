package app.annaj.android.example.com.bookbot;

/**
 * Created by Anna on 12/14/2015.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SingleItemView extends Activity {
    // Declare Variables
    TextView txtContentTitle;
    String newPost;
    String usernameLV;
    TextView usernameTitle;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from singleitemview.xml
        setContentView(R.layout.singleitemview);

        // Retrieve data from MainActivity on item click event
        Intent i = getIntent();

        // Get the post
        newPost = i.getStringExtra("newPost");
        //get user
        usernameLV=i.getStringExtra("user");

        // Locate the TextView in singleitemview.xml
        txtContentTitle = (TextView) findViewById(R.id.newPost);

        // Locate the TextView in singleitemview.xml for user
        usernameTitle=(TextView)findViewById(R.id.usernameLV);
        // Load the text into the TextView
        txtContentTitle.setText(newPost);
// Load the text into the TextView
        usernameTitle.setText(usernameLV);

    }
}