package com.example.quranpakwithtranslation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Rv_SurahAyatWithTranslation extends AppCompatActivity {

    RecyclerView recyclerView2;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager2;
    SqlLiteDbHelper dbHelper;
    List<model> contList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rv_surah_ayat_with_translation);

        Intent intent=getIntent();
        Log.d("Position: ", String.valueOf(intent.getIntExtra("position", 0)));
//        readTV.setText(intent.getIntExtra("position", 0));
        // to make the Navigation drawer icon always appear on the action bar

        contList = new ArrayList<>();
        contList.clear();
        dbHelper = new SqlLiteDbHelper(Rv_SurahAyatWithTranslation.this);
        dbHelper.openDataBase();
        contList = dbHelper.getSurahData(String.valueOf(intent.getIntExtra("position", 0)+1));

        recyclerView2 = findViewById(R.id.recyclerView2);


        recyclerView2.setHasFixedSize(true);

        //LinearLayoutManager GridLayoutManager
        // layoutManager = new LinearLayoutManager(MainActivity.this);
        layoutManager2 = new LinearLayoutManager(Rv_SurahAyatWithTranslation.this,
                LinearLayoutManager.HORIZONTAL,
                true);
        recyclerView2.setLayoutManager(layoutManager2);

        adapter = new Rv_Adapter(contList) ;
        recyclerView2.setAdapter(adapter);
    }

}