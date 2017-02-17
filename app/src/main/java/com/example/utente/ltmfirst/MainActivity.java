package com.example.utente.ltmfirst;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.utente.ltmfirst.model.Student;

import org.w3c.dom.Text;

import java.net.URI;
import java.util.ArrayList;

/**
 * Created by Utente on 08/02/2017.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button go, call, share;
    TextView phoneNumber;
    TextView address;
    TextView mail;
    private final String EMAIL_KEY = "email";

    static RecyclerView recyclerView;
    static StudentAdapter studentAdapter;
    static LinearLayoutManager linearLayoutManager;
    static RelativeLayout layout;
    static LinearLayout studentLayout;


    public void onStart(){
        super.onStart();
        studentAdapter.setDataSet(createDataSet());
    }


    public ArrayList<Student> createDataSet(){
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("Francesco","3295632453","Via Sandro Sandri,71","francesco.stella97@gmail.com","LTM11","27/07/1997"));
        list.add(new Student("Donato","3258874453","Via Sandro Sandri,71","donato.virg@gmail.com","LTM11","21/11/1997"));
        return list;
    }
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        recyclerView = (RecyclerView)findViewById(R.id.layout_main_activity);
        linearLayoutManager = new LinearLayoutManager(this);
        studentAdapter = new StudentAdapter(this);
        recyclerView.setAdapter(studentAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        layout = (RelativeLayout) findViewById(R.id.linear_main_activity);
        /*
        phoneNumber = (TextView) findViewById(R.id.textTel);
        address = (TextView) findViewById(R.id.textAddress);
        mail = (TextView) findViewById(R.id.textMail);
        go = (Button)findViewById(R.id.activity_go_btn);
        call = (Button) findViewById(R.id.activity_call_btn);
        share = (Button) findViewById(R.id.activity_share_btn);

        go.setOnClickListener(this);
        call.setOnClickListener(this);
        share.setOnClickListener(this);
        */

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.fab){
                AlertDialog.Builder builder;
                LayoutInflater inflater;
                final View view ;
                builder = new AlertDialog.Builder(this);
                inflater = this.getLayoutInflater();
                view = getLayoutInflater().inflate(R.layout.dialog_add, null);
                builder.setView(view)
                        .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                String name = ((AppCompatEditText) view.findViewById(R.id.name)).getText().toString();
                                String email = ((AppCompatEditText) view.findViewById(R.id.email)).getText().toString();
                                String tel = ((AppCompatEditText) view.findViewById(R.id.phone)).getText().toString();
                                String date = ((AppCompatEditText) view.findViewById(R.id.date)).getText().toString();
                                String address = ((AppCompatEditText) view.findViewById(R.id.address)).getText().toString();
                                String course = ((AppCompatEditText) view.findViewById(R.id.course)).getText().toString();
                                if (!name.isEmpty() && !email.isEmpty() && !tel.isEmpty() && !date.isEmpty() && !date.isEmpty() && !address.isEmpty() && !course.isEmpty()) {
                                    Student s = new Student(name, tel, address, email, course, date);
                                    studentAdapter.addData(s);
                                    recyclerView.scrollToPosition(0);
                                } else {
                                }
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                builder.setTitle("Add new student");
                builder.create().show();
            }

        else if(v.getId()==R.id.activity_call_btn){
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
        else if(v.getId()== R.id.activity_share_btn){
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, mail.getText().toString());
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        }
    }

    public static void showSnackBar(String name, int type) {
        if(type==0)Snackbar.make(layout,name,Snackbar.LENGTH_SHORT).show();
        if(type==1){

        }
    }


}
