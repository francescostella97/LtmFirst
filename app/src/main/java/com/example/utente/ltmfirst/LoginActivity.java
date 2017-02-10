package com.example.utente.ltmfirst;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Vibrator;

/**
 * Created by Utente on 10/02/2017.
 */

public class LoginActivity extends AppCompatActivity {
    TextView login_btn;
    EditText email_et;
    EditText psw_et;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email_et = (EditText) findViewById(R.id.login_email_txt);
        psw_et = (EditText) findViewById(R.id.login_pwd_txt);
        login_btn = (TextView) findViewById(R.id.login_log_btn);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(doLogin(email_et.getText().toString(), psw_et.getText().toString())) {

                Vibrator x = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                // Vibrate for 500 milliseconds
                x.vibrate(500);
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
            }
        });
    }

    private boolean doLogin (String email, String password) {
        if (email.length() == 0 || password.length() == 0) {
            Toast.makeText(LoginActivity.this,getText(R.string.login_res_ko),Toast.LENGTH_LONG).show();
            return false;
        } else return true;
    }
}
