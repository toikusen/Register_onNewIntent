package com.example.practice;

import androidx.annotation.Nullable;
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

public class PasswordActivity extends AppCompatActivity {

    private EditText ed_password;
    private String testPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
    }

    public void next2(View view){
        final Intent password = getIntent();
        ed_password = findViewById(R.id.password);
        testPassword = ed_password.getText().toString();

        if(!TextUtils.isEmpty(ed_password.getText().toString())){
            Log.d("RESULT_PASSWORD", testPassword);
            Intent email = new Intent(this, EmailActivity.class);
            SharedPreferences pref = getSharedPreferences("test", MODE_PRIVATE);
            pref.edit()
                    .putString("password",ed_password.getText().toString())
                    .commit();

            email
                    .putExtra("testUsername",password.getStringExtra("testUsername"))
                    .putExtra("testPassword", testPassword);
            startActivity(email);

        }else{
            new AlertDialog.Builder(this)
                    .setTitle("錯誤")
                    .setMessage("密碼欄不可為空白")
                    .setPositiveButton("OK",null)
                    .show();
        }

    }
}
