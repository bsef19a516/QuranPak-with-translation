package com.example.quranpakwithtranslation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Search extends AppCompatActivity {
    EditText surahNo;
    EditText ayatNo;
    Button search;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
        surahNo=(EditText) findViewById(R.id.surahNumber);
        ayatNo=(EditText) findViewById(R.id.ayatNumber);
        search=(Button) findViewById(R.id.searchButton);

        search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Search.this, SearchAyatWithTranslation.class);
                intent.putExtra("surahNo"  ,  surahNo.toString());
                intent.putExtra("ayatNo"  ,  ayatNo.toString());
                startActivity(intent);
            }

        });
    }
}
