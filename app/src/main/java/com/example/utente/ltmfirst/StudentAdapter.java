package com.example.utente.ltmfirst;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.utente.ltmfirst.control.Keys;
import com.example.utente.ltmfirst.model.SingleItemActivity;
import com.example.utente.ltmfirst.model.Student;

import java.util.ArrayList;

/**
 * Created by Utente on 15/02/2017.
 */

public class StudentAdapter extends RecyclerView.Adapter{
    public ArrayList <Student> dataSet = new ArrayList<>();
    private final Context context;

    public StudentAdapter(Context c){
        context = c;
    }
    public void setDataSet(ArrayList<Student> dataSet){
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }

    public void addData(Student s){
        this.dataSet.add(0,s);
        notifyItemInserted(0);
    }

    public void removeData(int position){
        this.dataSet.remove(position);
        notifyItemRemoved(position);
    }
    public void removeData(Student s){
        this.dataSet.remove(s);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_student,parent,false);
        return new StudentVH(view);
    }
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder vHolder, int position) {
        //update screen with data
        Student student = dataSet.get(position);
        final StudentVH holder = (StudentVH)vHolder;

        holder.name.setText(student.getName());
        holder.mail.setText(student.getEmail());
        holder.address.setText(student.getAddress());
        holder.course.setText(student.getCourse());
        holder.tel.setText(student.getPhone());
        holder.birthDay.setText(student.getBirthDay());

        holder.btnViewOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //creating a popup menu
                PopupMenu popup = new PopupMenu(vHolder.itemView.getContext(), holder.btnViewOption);
                //inflating menu from xml resource
                popup.inflate(R.menu.menu);
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.item_delete:
                                remove(holder);
                                break;/*
                            case R.id.item_edit:
                                break;/*
                            case R.id.menu3:
                                //handle menu3 click
                                break;*/
                        }
                        return false;
                    }
                });
                //displaying the popup
                popup.show();

            }
        });
    }

    public void remove(StudentVH holder){
        final StudentVH myHolder = holder;
        final int position = myHolder.getAdapterPosition();
        final  Student student = dataSet.get(position);

        Snackbar snackbar = Snackbar
                .make(MainActivity.layout,"Student removed",Snackbar.LENGTH_LONG)
                .setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //int adapterPosition = myHolder.getAdapterPosition();
                        dataSet.add(position,student);
                        notifyItemInserted(position);
                        MainActivity.recyclerView.scrollToPosition(position);
                        //removeData(student);
                    }
                });
        snackbar.show();
        removeData(position);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    //student holder
    public class StudentVH extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView name,mail,address,course,tel,birthDay;
        public Button btnGo,btnCall,btnInfo,btnShare;
        LinearLayout layout ;
        public TextView btnViewOption;
        public StudentVH(View view){
            super(view);

            name = (TextView) view.findViewById(R.id.textName);
            mail = (TextView) view.findViewById(R.id.textMail);
            address = (TextView) view.findViewById(R.id.textAddress);
            course = (TextView) view.findViewById(R.id.text_Course);
            tel = (TextView) view.findViewById(R.id.textTel);
            birthDay = (TextView) view.findViewById(R.id.textDate);

            btnInfo = (Button) view.findViewById(R.id.activity_info_btn);
            btnCall = (Button) view.findViewById(R.id.activity_call_btn);
            btnGo = (Button) view.findViewById(R.id.activity_go_btn);
            btnShare = (Button) view.findViewById(R.id.activity_share_btn);
            btnInfo.setOnClickListener(this);
            btnShare.setOnClickListener(this);
            btnGo.setOnClickListener(this);
            btnCall.setOnClickListener(this);

            btnViewOption = (TextView) view.findViewById(R.id.textViewOptions);
            layout = (LinearLayout) view.findViewById(R.id.item_student_layout);
            layout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.activity_info_btn){
                Intent intent = new Intent( context,SingleItemActivity.class);
                intent.putExtra(Keys.name,name.getText().toString());
                context.startActivity(intent);
                AppCompatActivity main = (AppCompatActivity)v.getContext();
            } else if(v.getId()==R.id.activity_call_btn){


                //main.finish();
            }

        }
    }
}

