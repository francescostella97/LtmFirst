package com.example.utente.ltmfirst.model;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

import com.example.utente.ltmfirst.MainActivity;
import com.example.utente.ltmfirst.R;

/**
 * Created by Utente on 17/02/2017.
 */

public class SingleItemActivity extends AppCompatActivity {
    AppCompatEditText name;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_item);

        Intent intent = getIntent();

        name = (AppCompatEditText) findViewById(R.id.single_item_name);
        name.setText(intent.getStringExtra("name"));
        setTitle(name.getText().toString());
        name.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(name.getText().toString().length()!=25) setTitle(name.getText().toString());
                else Toast.makeText(SingleItemActivity.this,"Max length reached",Toast.LENGTH_SHORT).show();
            }
        });

    }


}
