package com.example.quranpakwithtranslation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.islamiculoom.tasreefapp.Common.QuranData.QDH;

import java.util.List;

public class Rv_ParaActivity extends AppCompatActivity {
    ListView parahNames;
    List<String> names;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rv_para_names);
        parahNames=(ListView) findViewById(R.id.rv_parah_names);

            QDH qdh = new QDH();
            names = qdh.GetParahNames();
        try {
            ArrayAdapter arrayAdapter = new ArrayAdapter<String>(Rv_ParaActivity.this, android.R.layout.simple_list_item_1, names);
            parahNames.setAdapter(arrayAdapter);
        }
        catch (Exception e)
        {
            Toast.makeText(this, "errorrrrrrr", Toast.LENGTH_SHORT).show();
        }
        parahNames.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Rv_ParaActivity.this, Rv_ParahAyatWithTranslation.class);
                intent.putExtra("position"  , position);
                startActivity(intent);
//                Log.d("Position: ", String.valueOf(position));

            }

        });
    }
}
