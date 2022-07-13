package com.example.javademoproject;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import model.Member;
import model.User;

public class DetailPage extends AppCompatActivity {
    static final String TAG=DetailPage.class.toString();
    private Object User;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);
        initViews();
    }
    void initViews(){
        TextView text_id=findViewById(R.id.detail_text);
        Button button_id=findViewById(R.id.detail_button);

        button_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Member member=new Member(1001,"Member");

                backActivity(member);
            }
        });

       User user=(User) getIntent().getSerializableExtra("user");
       Log.d(TAG,user.toString());
       text_id.setText(user.toString());
    }

    void backActivity(Member member){
        Intent intent=new Intent();
        intent.putExtra("member",member);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }
}