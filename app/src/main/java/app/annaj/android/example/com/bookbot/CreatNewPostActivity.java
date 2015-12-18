package app.annaj.android.example.com.bookbot;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class CreatNewPostActivity extends AppCompatActivity {
    protected EditText mPostBookEditText,mBookTitlePostBook,mAuthorPostBook;
    protected Spinner mBuySellSpinnerPostBookS;
    protected Button mPostBookBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat_new_post);


        //init
        mPostBookEditText=(EditText)findViewById(R.id.postbookEditText);
        mPostBookBtn=(Button)findViewById(R.id.postBookBtn);
        mBookTitlePostBook=(EditText)findViewById(R.id.bookTitlePostBook);
        mAuthorPostBook=(EditText)findViewById(R.id.authorPostBook);
        mBuySellSpinnerPostBookS=(Spinner)findViewById(R.id.buySellSpinnerPostBookS);
        //listen to post button
        mPostBookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get current user

                ParseUser currentUser=ParseUser.getCurrentUser();
                String currentUserUsername=currentUser.getUsername();

                //get the post entered and convert into string
                String newPost=mPostBookEditText.getText().toString();
                String authorBook= mAuthorPostBook.getText().toString();
                String titleBook=mBookTitlePostBook.getText().toString();

                ///Validation if post is empty
                if (newPost.isEmpty()){
                    //show error meassage
                    AlertDialog.Builder builder = new AlertDialog.Builder(CreatNewPostActivity.this);
                    builder.setMessage("Post can not be empty");
                    builder.setTitle("Error");
                    builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            //close dialog
                            dialogInterface.dismiss();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();


                }
                else {


                    //save the status in Parse

                    ParseObject bookpostObject = new ParseObject("BookPosts");
                    bookpostObject.put("newPost", newPost);
                    bookpostObject.put("authorBook", authorBook);
                    bookpostObject.put("titleBook", titleBook);

                    bookpostObject.put("user", currentUserUsername);
                    bookpostObject.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                //succes
                                Toast.makeText(CreatNewPostActivity.this, "Succes", Toast.LENGTH_LONG).show();

                                //take user to browse book
                                Intent takeUserToBrowse = new Intent(CreatNewPostActivity.this, UserHomePageActivity.class);
                                startActivity(takeUserToBrowse);
                            } else {
                                //error
                                AlertDialog.Builder builder = new AlertDialog.Builder(CreatNewPostActivity.this);
                                builder.setMessage(e.getMessage());
                                builder.setTitle("sorry");
                                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int which) {
                                        //close dialog
                                        dialogInterface.dismiss();
                                    }
                                });
                                AlertDialog dialog = builder.create();
                                dialog.show();
                            }
                        }
                    });

                }//end of else
            }
        });






        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

}
