package com.example.quranpakwithtranslation;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;


public class SqlLiteDbHelper extends SQLiteOpenHelper {

        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "quran_database.sqlite";
        private static final String DB_PATH_SUFFIX = "/databases/";
        static Context ctx;
        public SqlLiteDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            ctx = context;
        }
        public ArrayList<model> getDetails() {
            SQLiteDatabase db = this.getReadableDatabase();
            ArrayList<model> contList = new ArrayList<>();
            Cursor cursor = db.rawQuery("SELECT * FROM tayah", null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    model cont = new model(cursor.getInt(1),cursor.getInt(2), cursor.getString(3), cursor.getString(5), cursor.getString(6), cursor.getInt(10));
                    contList.add(cont);
                }
                cursor.close();
                db.close();
            }
            return contList;
        }
    public ArrayList<model> getParaData(String paraid) {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<model> contList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM tayah Where ParaID='"+paraid+"'", null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                model cont = new model(cursor.getInt(1),cursor.getInt(2), cursor.getString(3), cursor.getString(5), cursor.getString(6), cursor.getInt(10));
                contList.add(cont);
            }
            cursor.close();
            db.close();
        }
        return contList;
    }
    /*public ArrayList<Rv_model> getRvParaData(String paraid) {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Rv_model> contList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM tayah Where ParaID='"+paraid+"'", null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                Rv_model cont = new Rv_model(cursor.getInt(1),cursor.getInt(2), cursor.getInt(10) ,cursor.getString(3), cursor.getString(5));
                contList.add(cont);
            }
            cursor.close();
            db.close();
        }
        return contList;
    }*/
    public ArrayList<model> getSurahData(String surahid) {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<model> contList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM tayah Where SuraID='"+surahid+"'", null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                model cont = new model(cursor.getInt(1),cursor.getInt(2), cursor.getString(3), cursor.getString(5), cursor.getString(6), cursor.getInt(10));
                contList.add(cont);
            }
            cursor.close();
            db.close();
        }
        return contList;
    }

    public ArrayList<model> getSearchData(String surahid, String ayatId) {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<model> contList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM tayah Where SuraID='"+surahid+"' AND AyaNo='"+ayatId+"'", null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                model cont = new model(cursor.getInt(1),cursor.getInt(2), cursor.getString(3), cursor.getString(5), cursor.getString(6), cursor.getInt(10));
                contList.add(cont);
            }
            cursor.close();
            db.close();
        }
        return contList;
    }


    public void CopyDataBaseFromAsset() throws IOException {
            InputStream myInput = ctx.getAssets().open(DATABASE_NAME);
// Path to the just created empty db
            String outFileName = getDatabasePath();

// if the path doesn't exist first, create it
            File f = new File(ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            if (!f.exists())
                f.mkdir();

// Open the empty db as the output stream
            OutputStream myOutput = new FileOutputStream(outFileName);

// transfer bytes from the inputfile to the outputfile
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
// Close the streams
            myOutput.flush();
            myOutput.close();
            myInput.close();

        }
        private static String getDatabasePath() {
            return ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX + DATABASE_NAME;
        }
        public SQLiteDatabase openDataBase() throws SQLException {
            File dbFile = ctx.getDatabasePath(DATABASE_NAME);
            if (!dbFile.exists()) {
                try {
                    CopyDataBaseFromAsset();
                    System.out.println("Copying sucess from Assets folder");
                } catch (IOException e) {
                    throw new RuntimeException("Error creating source database", e);
                }
            }
            return SQLiteDatabase.openDatabase(dbFile.getPath(), null, SQLiteDatabase.NO_LOCALIZED_COLLATORS | SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
}
