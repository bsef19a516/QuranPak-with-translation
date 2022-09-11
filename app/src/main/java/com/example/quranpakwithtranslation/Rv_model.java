package com.example.quranpakwithtranslation;

public class Rv_model {
    int surahID;
    int ayahNo;
    int paraID;
    String arabic;
    String tran;

    public Rv_model(int surahID, int ayahNo, int paraID, String arabic, String tran) {
        this.surahID = surahID;
        this.ayahNo = ayahNo;
        this.paraID = paraID;
        this.arabic = arabic;
        this.tran = tran;
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

    public String getTran() {
        return tran;
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

    public void setTran(String tran) {
        this.tran = tran;
    }
}
