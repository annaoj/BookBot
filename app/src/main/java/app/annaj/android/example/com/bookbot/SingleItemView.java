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
    TextView txtname;
    String newPost;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from singleitemview.xml
        setContentView(R.layout.singleitemview);

        // Retrieve data from MainActivity on item click event
        Intent i = getIntent();

        // Get the name
        newPost = i.getStringExtra("newPost");

        // Locate the TextView in singleitemview.xml
        txtname = (TextView) findViewById(R.id.newPost);

        // Load the text into the TextView
        txtname.setText(newPost);

    }
}