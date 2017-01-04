package com.gizemsalcigmail.stratus;

/**
 * Created by GizemSalci on 4.1.2017.
 */

public class soru {

    public int ID;
    public String a,b,c,soru,cevap;

    public soru()
    {}

    public soru(int ID, String a, String b, String c, String soru, String cevap) {
        this.ID = ID;
        this.a = a;
        this.b = b;
        this.c = c;
        this.soru = soru;
        this.cevap = cevap;
    }



    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getSoru() {
        return soru;
    }

    public void setSoru(String soru) {
        this.soru = soru;
    }

    public String getCevap() {
        return cevap;
    }

    public void setCevap(String cevap) {
        this.cevap = cevap;
    }
}
