package app.annaj.android.example.com.bookbot;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends Activity {

    protected EditText mUsername;
            protected EditText mPassword;
            protected Button mLoginBtn;
            protected Button mCreatAccountBtn;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_login);



                mUsername =(EditText)findViewById(R.id.usernameLoginTextBox);
                mPassword =(EditText)findViewById(R.id.passwordLoginTextBox);
                mLoginBtn =(Button)findViewById(R.id.loginBtn);
                mCreatAccountBtn =(Button)findViewById(R.id.createAccBtn);

                //listen to when create acc btn is clicked
                mCreatAccountBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent takeUserToReg=new Intent(LoginActivity.this,RegisterActivity.class);
                        startActivity(takeUserToReg);
                    }
        });


        //listen to when th login btn is clicked
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the user input and convert to string
                String username = mUsername.getText().toString().trim();
                String password = mPassword.getText().toString().trim();


                //login the user using parse sdk,using logincallback method
                ParseUser.logInInBackground(username, password, new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {

                        if (user != null) {
                            // Hooray! The user is logged in.
                            Toast.makeText(LoginActivity.this, "welcome back!", Toast.LENGTH_LONG).show();

                            //take user to UserHomePage

                            Intent takeUserToHP = new Intent(LoginActivity.this, UserHomePageActivity.class);
                            startActivity(takeUserToHP);

                        } else {
                            // Signup failed. Look at the ParseException to see what happened.
                            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
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
            }
        });








    }

}
