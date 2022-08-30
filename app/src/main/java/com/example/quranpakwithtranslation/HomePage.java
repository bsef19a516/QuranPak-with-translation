package com.example.quranpakwithtranslation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class HomePage extends AppCompatActivity {
    Button buttonPara, buttonSurah;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        buttonPara=(Button) findViewById(R.id.buttonPara);
        buttonSurah=(Button) findViewById(R.id.buttonSurah);
        buttonPara.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, ParaActivity.class);
                startActivity(intent);
            }
        });
        buttonSurah.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, SurahActivity.class);
                startActivity(intent);
            }
        });
    }
}
