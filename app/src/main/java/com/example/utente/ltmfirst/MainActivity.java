package com.example.utente.ltmfirst;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.net.URI;

/**
 * Created by Utente on 08/02/2017.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button go;
    Button call;
    TextView phoneNumber;
    TextView address;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNumber = (TextView) findViewById(R.id.textTel);
        address = (TextView) findViewById(R.id.textAddress);

        go = (Button)findViewById(R.id.activity_go_btn);
        call = (Button) findViewById(R.id.activity_call_btn);
        go.setOnClickListener(this);
        call.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.activity_call_btn){
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            Uri uri = Uri.parse("tel:" +phoneNumber.getText().toString());
            intent.setData(uri);
            startActivity(intent);
        }
        else if (v.getId()==R.id.activity_go_btn){
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            Uri uri = Uri.parse("geo:0,0?=" +address.getText().toString());
            intent.setData(uri);
            startActivity(intent);
        }
    }
}
