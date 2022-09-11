package com.example.quranpakwithtranslation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Rv_ParahAyatWithTranslation extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    SqlLiteDbHelper dbHelper;
    List<Rv_model> contList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rv_parah_ayat_with_translation);

        Intent intent=getIntent();
        Log.d("Position: ", String.valueOf(intent.getIntExtra("position", 0)));
//        readTV.setText(intent.getIntExtra("position", 0));
        // to make the Navigation drawer icon always appear on the action bar

        contList = new ArrayList<>();
        contList.clear();
        dbHelper = new SqlLiteDbHelper(Rv_ParahAyatWithTranslation.this);
        dbHelper.openDataBase();
        contList = dbHelper.getRvParaData(String.valueOf(intent.getIntExtra("position", 0)));

        recyclerView = findViewById(R.id.recyclerView);


        recyclerView.setHasFixedSize(true);

        //LinearLayoutManager GridLayoutManager
        // layoutManager = new LinearLayoutManager(MainActivity.this);
        layoutManager = new LinearLayoutManager(Rv_ParahAyatWithTranslation.this,
                LinearLayoutManager.HORIZONTAL,
                true);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new Rv_Adapter(contList) ;
        recyclerView.setAdapter(adapter);
    }

}