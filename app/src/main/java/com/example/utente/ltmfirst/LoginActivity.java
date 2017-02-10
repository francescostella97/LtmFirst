package com.example.utente.ltmfirst;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Utente on 10/02/2017.
 */

public class LoginActivity extends AppCompatActivity {
    TextView login_btn;
    EditText username_et;
    EditText psw_et;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_btn.setEnabled(false);
        login_btn = (TextView) findViewById(R.id.login_log_btn);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(doLogin(username_et.getText().toString(), psw_et.getText().toString())) {

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
            }
        });
    }

    private boolean doLogin (String username, String password){
        if (username.length()==0 || password.length()==0) {
            login_btn.setEnabled(true);
            return false;
        }
        else return true;
}
