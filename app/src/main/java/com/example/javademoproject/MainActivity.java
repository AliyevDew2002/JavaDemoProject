package com.example.javademoproject;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import model.Member;
import model.User;

public class MainActivity<var> extends AppCompatActivity {
    static final String TAG=MainActivity.class.toString();
    int LAUNCHER_DETAIL=1001;
    TextView main_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    ActivityResultLauncher<Intent> detailLauncher=registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode()==Activity.RESULT_OK){
                        Intent data=result.getData();
                       Member member= (Member) data.getSerializableExtra("member");
                       Log.d(TAG,member.toString());
                       main_text.setText(member.toString());
                    }
                }
            });



    void initViews(){
        main_text=findViewById(R.id.main_text);
        Button button=findViewById(R.id.main_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user=new User(7007,"User");
              startActivity(user);
            }
        });
    }
    void startActivity(User user){
        Intent intent=new Intent(this,DetailPage.class);
        intent.putExtra("user",user);
        detailLauncher.launch(intent);
    }
}