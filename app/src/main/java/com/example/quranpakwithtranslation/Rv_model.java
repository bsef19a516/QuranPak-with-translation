package com.example.quranpakwithtranslation;

public class Rv_model {
    int surahID;
    int ayahNo;
    int paraID;
    String arabic;
    String urdu;
    String eng;

    public Rv_model(int surahID, int ayahNo, int paraID, String arabic, String urdu, String eng) {
        this.surahID = surahID;
        this.ayahNo = ayahNo;
        this.paraID = paraID;
        this.arabic = arabic;
        this.urdu = urdu;
        this.eng = eng;
    }

    public int getSurahID() {
        return surahID;
    }

    public int getAyahNo() {
        return ayahNo;
    }

    public int getParaID() {
        return paraID;
    }

    public String getArabic() {
        return arabic;
    }

    public String getUrduTran() {
        return urdu;
    }

    public String getEngTran() {
        return eng;
    }

    public void setSurahID(int surahID) {
        this.surahID = surahID;
    }

    public void setAyahNo(int ayahNo) {
        this.ayahNo = ayahNo;
    }

    public void setParaID(int paraID) {
        this.paraID = paraID;
    }

    public void setArabic(String arabic) {
        this.arabic = arabic;
    }

    public void setUrduTran(String tran) {
        this.urdu = tran;
    }

    public void setEngTran(String tran) {
        this.eng = tran;
    }
}
