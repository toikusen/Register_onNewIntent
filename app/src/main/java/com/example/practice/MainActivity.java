package com.example.practice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_LOGIN = 10 ;
    private EditText username;
    private EditText password;
    private EditText email;
    private String resultUsername;
    private String resultPassword;
    private String resultEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.un);
        password = findViewById(R.id.pw);
        email = findViewById(R.id.em);

    }
    public void login(View view){
        Intent username = new Intent(this,UsernameActivity.class);
        startActivityForResult(username,REQUEST_CODE_LOGIN);
    }

    @Override
    protected void onStart() {
        super.onStart();
        resultUsername = username.getText().toString();
        resultPassword = password.getText().toString();
        resultEmail = email.getText().toString();
        Log.d("RESULT",resultUsername + "/" + resultPassword + "/" + resultEmail);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

            if(requestCode==REQUEST_CODE_LOGIN){
                if (resultCode!=RESULT_OK) {
                    finish();
                }else {
//                    String result = data.getStringExtra("RESULT");
//                    email.setText(result);
                    username.setText(getSharedPreferences("test", MODE_PRIVATE).getString("user",""));
                    password.setText(getSharedPreferences("test", MODE_PRIVATE).getString("password",""));
                    email.setText(getSharedPreferences("test", MODE_PRIVATE).getString("email",""));
                }
            }
    }
}

