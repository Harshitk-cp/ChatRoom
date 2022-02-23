package com.harshit.chatroom;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_room);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 10);


        EditText etEnterName = findViewById(R.id.etEnterName);

        findViewById(R.id.btnEnterRoom)
                .setOnClickListener(v -> {

                    if(etEnterName.getText().toString().isEmpty()){
                        etEnterName.setError("Your name is required");
                    }
                    else{
                        Intent intent = new Intent(this, ChatActivity.class);
                        intent.putExtra("name", etEnterName.getText().toString());
                        startActivity(intent);
                    }


                });

    }
}