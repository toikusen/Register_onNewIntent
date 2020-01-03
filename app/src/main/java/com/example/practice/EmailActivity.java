package com.example.practice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class EmailActivity extends AppCompatActivity {


    private EditText ed_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

    }

    public void next3(View view) {

        ed_email = findViewById(R.id.email);
        String testEmail = ed_email.getText().toString();

        if (!TextUtils.isEmpty(ed_email.getText().toString())) {
            Log.d("RESULT_EMAIL",testEmail);
            Intent result = new Intent(this, MainActivity.class);
//            SharedPreferences pref= getSharedPreferences("test",MODE_PRIVATE);
//            pref.edit()
//                    .putString("email",ed_email.getText().toString())
//                    .commit();
            startActivityForResult(result,10);
            result.putExtra("testEmail",testEmail);
            setResult(RESULT_OK,result);
            finish();
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("錯誤")
                    .setMessage("信箱欄不可為空白")
                    .setPositiveButton("OK", null)
                    .show();
        }
    }
}
