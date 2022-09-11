package com.example.quranpakwithtranslation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;


public class Rv_SurahActivity extends AppCompatActivity{
        ListView SurahName;
        List<String> names;
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.rv_surah_names);
            SurahName =(ListView) findViewById(R.id.rv_surah_names);

            com.islamiculoom.tasreefapp.Common.QuranData.QDH qdh = new com.islamiculoom.tasreefapp.Common.QuranData.QDH();
            names = qdh.GetSurahNames();
            try {
                ArrayAdapter arrayAdapter = new ArrayAdapter<String>(Rv_SurahActivity.this, android.R.layout.simple_list_item_1, names);
                SurahName.setAdapter(arrayAdapter);
            }
            catch (Exception e)
            {
                Toast.makeText(this, "errorrrrrrr", Toast.LENGTH_SHORT).show();
            }
            SurahName.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                    Intent intent = new Intent(Rv_SurahActivity.this, Rv_SurahAyatWithTranslation.class);
                    intent.putExtra("position"  , position);
                    startActivity(intent);
//                    Log.d("Position: ", String.valueOf(position));

                }

            });
        }
}


