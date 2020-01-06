package com.example.practice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class UsernameActivity extends AppCompatActivity {

    private EditText ed_username;
    private String testUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_username);

    }

    public void next1(View view){
        ed_username = findViewById(R.id.username);
        testUsername = ed_username.getText().toString();

        if(!TextUtils.isEmpty(ed_username.getText().toString())){
            Log.d("RESULT_USERNAME", testUsername);
            Intent password = new Intent(this,PasswordActivity.class);
            SharedPreferences pref = getSharedPreferences("test", MODE_PRIVATE);
            pref.edit()
                    .putString("user",ed_username.getText().toString())
                    .commit();

//            password.putExtra("testUsername", testUsername);
            startActivity(password);

        }else {
            new AlertDialog.Builder(this)
                    .setTitle("訊息")
                    .setMessage("帳號欄不可為空白")
                    .setPositiveButton("OK",null)
                    .show();
        }

    }

}
