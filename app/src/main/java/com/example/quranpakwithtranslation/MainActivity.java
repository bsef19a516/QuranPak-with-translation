package com.example.quranpakwithtranslation;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView readTV;
    SqlLiteDbHelper dbHelper;
    ArrayList<model> contList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readTV = (TextView) findViewById(R.id.readTV);
        contList = new ArrayList<>();
        contList.clear();
        dbHelper = new SqlLiteDbHelper(this);
        dbHelper.openDataBase();
        contList = dbHelper.getDetails();
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
            Toast.makeText(MainActivity.this, "cant access data", Toast.LENGTH_SHORT).show();
        }
    }
}