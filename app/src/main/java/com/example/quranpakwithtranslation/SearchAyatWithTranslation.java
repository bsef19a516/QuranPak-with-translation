package com.example.quranpakwithtranslation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;

public class SearchAyatWithTranslation extends AppCompatActivity {

    TextView readTV;
    SqlLiteDbHelper dbHelper;
    ArrayList<model> contList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_ayat_with_translation);
        try {
        Intent intent=getIntent();
        String surahNo=intent.getStringExtra("surahNo");
        String ayatNo=intent.getStringExtra("ayatNo");
//        readTV.setText(intent.getIntExtra("position", 0));
        // to make the Navigation drawer icon always appear on the action bar

        readTV = (TextView) findViewById(R.id.searchData);
        contList = new ArrayList<>();
        dbHelper = new SqlLiteDbHelper(SearchAyatWithTranslation.this);
        dbHelper.openDataBase();

            contList = dbHelper.getSearchData(surahNo,ayatNo);

        String msg ="";
        if(contList!=null) {
            for (int i = 0; i < contList.size(); i++) {

                model cont = contList.get(i);
                msg = msg +"AyahNO: "+ cont.getAyahNo() + "SurahID: " + cont.getSurahID() + "\n" + cont.getArabic() + "\n" + cont.getUrdu() + "\n" + cont.getEnglish() + "\n\n\n";
                readTV.setTypeface(ResourcesCompat.getFont(this, R.font.noorehuda));
                readTV.setText(msg);
            }
        }
        else{
            Toast.makeText(SearchAyatWithTranslation.this, "cant access data", Toast.LENGTH_SHORT).show();
        }
        }
        catch (Exception e)
        {
            Toast.makeText(SearchAyatWithTranslation.this,"getSearchData not working", Toast.LENGTH_SHORT).show();
        }
    }

}