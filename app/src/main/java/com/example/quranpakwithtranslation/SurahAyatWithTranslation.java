package com.example.quranpakwithtranslation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;

public class SurahAyatWithTranslation extends AppCompatActivity {


    TextView readTV;
    SqlLiteDbHelper dbHelper;
    ArrayList<model> contList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surah_ayat_with_translation);


        Intent intent = getIntent();
        Log.d("Position: ", String.valueOf(intent.getIntExtra("position", 0)));
//        readTV.setText(intent.getIntExtra("position", 0));
        // to make the Navigation drawer icon always appear on the action bar

        readTV = (TextView) findViewById(R.id.searchData);
        contList = new ArrayList<>();
        contList.clear();
        dbHelper = new SqlLiteDbHelper(SurahAyatWithTranslation.this);
        dbHelper.openDataBase();
        contList = dbHelper.getSurahData(String.valueOf(intent.getIntExtra("position", 0) + 1));
        String msg = "";
        if (contList != null) {
            for (int i = 0; i < contList.size(); i++) {

                model cont = contList.get(i);
                msg = msg + "AyahNO: " + cont.getAyahNo() + "SurahID: " + cont.getSurahID() + "\n" + cont.getArabic() + "\n" + cont.getUrdu() + "\n" + cont.getEnglish() + "\n\n\n";
                readTV.setTypeface(ResourcesCompat.getFont(this, R.font.noorehuda));
                readTV.setText(msg);
            }
        } else {
            Toast.makeText(SurahAyatWithTranslation.this, "cant access data", Toast.LENGTH_SHORT).show();
        }
    }
}


