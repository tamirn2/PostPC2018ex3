package com.tamir.mythreadapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button asyncButton = findViewById(R.id.activity_main_async_button);
        asyncButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AsyncActivity.class);
                startActivity(intent);
            }
        });


        Button handlerButton = findViewById(R.id.activity_main_handler_button);
        handlerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HandlerActivity.class);
                startActivity(intent);
            }
        });
    }

}
