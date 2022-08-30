package com.example.quranpakwithtranslation;

public class model {
    int surahID;
    int ayahNo;
    int paraID;
    String arabic;
    String urdu;
    String english;

    public int getParaID() {
        return paraID;
    }

    public model(int surahID, int ayahNo, String arabic, String urdu, String english, int paraID) {
        this.surahID = surahID;
        this.ayahNo = ayahNo;
        this.arabic = arabic;
        this.urdu = urdu;
        this.english = english;
        this.paraID=paraID;
    }

    public String getArabic() {
        return arabic;
    }

    public int getSurahID() {
        return surahID;
    }

    public int getAyahNo() {
        return ayahNo;
    }

    public String getUrdu() {
        return urdu;
    }

    public String getEnglish() {
        return english;
    }

    public void setSurahID(int surahID) {
        this.surahID = surahID;
    }

    public void setAyahNo(int ayahNo) {
        this.ayahNo = ayahNo;
    }

    public void setArabic(String arabic) {
        this.arabic = arabic;
    }

    public void setUrdu(String urdu) {
        this.urdu = urdu;
    }

    public void setEnglish(String english) {
        this.english = english;
    }
}
