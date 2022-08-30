package com.example.quranpakwithtranslation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    TextView readTV;
    SqlLiteDbHelper dbHelper;
    ArrayList<model> contList;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer
        navigationView=findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.search_button :
                        Toast.makeText(getApplicationContext(),"Retur is Clicked",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, ParaActivity.class);
                        startActivity(intent);
                        //drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_account:
                        Toast.makeText(getApplicationContext(),"nav-account is Clicked",Toast.LENGTH_LONG).show();
                        //drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }

                return true;
            }
        });
        Intent intent=getIntent();
        Log.d("Position: ", String.valueOf(intent.getIntExtra("position", 0)));
//        readTV.setText(intent.getIntExtra("position", 0));
        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        readTV = (TextView) findViewById(R.id.readTV);
        contList = new ArrayList<>();
        contList.clear();
        dbHelper = new SqlLiteDbHelper(MainActivity.this);
        dbHelper.openDataBase();
        contList = dbHelper.getParaData(String.valueOf(intent.getIntExtra("position", 0)+1));
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
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}