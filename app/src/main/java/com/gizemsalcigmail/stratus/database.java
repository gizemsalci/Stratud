package com.gizemsalcigmail.stratus;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by GizemSalci on 4.1.2017.
 */

public class database extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "sqllite_database";//com.gizemsalcigmail.stratus.database adı

    private static final String TABLE_NAME = "sorular";
    private static String SORU = "soru";
    private static String ASIKKI = "a_sikki";
    private static String BSIKKI = "b_sikki";
    private static String CSIKKI = "c_sikki";
    private static String DOGRUSIK = "dogru_sik";
    private static String ID = "id";

    public database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {  // Databesi oluşturuyoruz.Bu methodu biz çağırmıyoruz. Databese de obje oluşturduğumuzda otamatik çağırılıyor.
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + SORU + " TEXT,"
                + DOGRUSIK + " TEXT,"
                + ASIKKI + " TEXT,"
                + BSIKKI + " TEXT,"
                + CSIKKI + " TEXT" + ")";

        db.execSQL(CREATE_TABLE);
/*


        soru soru4 = new soru(4,"","","","","");
        soruEkle(soru4);

        soru soru5 = new soru(5,"","","","","");
        soruEkle(soru5);

*/
    }

    public int getRowCount() {
        // Bu method bu uygulamada kullanılmıyor ama her zaman lazım olabilir.Tablodaki row sayısını geri döner.
        //Login uygulamasında kullanacağız
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int rowCount = cursor.getCount();
        db.close();
        cursor.close();
        // return row count
        return rowCount;
    }

    public void soruEkle(soru item) {
        //kitapEkle methodu ise adı üstünde Databese veri eklemek için
        SQLiteDatabase db = this.getWritableDatabase(); //
        ContentValues values = new ContentValues();
        values.put(SORU,item.soru);
        values.put(ASIKKI,item.a);
        values.put(BSIKKI,item.b);
        values.put(CSIKKI,item.c);
        values.put(DOGRUSIK,item.cevap);

        db.insert(TABLE_NAME, null, values);
        db.close(); //Database Bağlantısını kapattık*/
    }

    public soru soruDetay(int id){
        //Databeseden id si belli olan row u çekmek için.
        //Bu methodda sadece tek row değerleri alınır.
        //HashMap bir çift boyutlu arraydir.anahtar-değer ikililerini bir arada tutmak için tasarlanmıştır.
        //map.put("x","300"); mesala burda anahtar x değeri 300.


        String selectQuery = "SELECT * FROM " + TABLE_NAME+ " WHERE id="+id;
        soru soru = new soru() ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if(cursor.getCount() > 0){
            soru.ID=cursor.getInt(0);
            soru.soru=cursor.getString(1);
            soru.a=cursor.getString(2);
            soru.b=cursor.getString(3);
            soru.c=cursor.getString(4);
            soru.cevap=cursor.getString(5);

        }
        cursor.close();
        db.close();
        // return kitap
        return soru;
    }

    public  ArrayList<soru> getSoruList(){

        //Bu methodda ise tablodaki tüm değerleri alıyoruz
        //ArrayList adı üstünde Array lerin listelendiği bir Array.Burda hashmapleri listeleyeceğiz
        //Herbir satırı değer ve value ile hashmap a atıyoruz. Her bir satır 1 tane hashmap arrayı demek.
        //olusturdugumuz tüm hashmapleri ArrayList e atıp geri dönüyoruz(return).

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        ArrayList<soru> ListSoru = new ArrayList<soru>();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                soru soru =new soru();
                for(int i=0; i<cursor.getColumnCount();i++)
                {
                    soru.ID=cursor.getInt(0);
                    soru.soru=cursor.getString(1);
                    soru.a=cursor.getString(2);
                    soru.b=cursor.getString(3);
                    soru.c=cursor.getString(4);
                    soru.cevap=cursor.getString(5);

                }

                ListSoru.add(soru);
            } while (cursor.moveToNext());
        }
        db.close();
        // return kitap liste
        return ListSoru;
    }





    public void resetTables(){
        //Bunuda uygulamada kullanmıyoruz. Tüm verileri siler. tabloyu resetler.
        SQLiteDatabase db = this.getWritableDatabase();
        // Delete All Rows
        db.delete(TABLE_NAME, null, null);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

    }

}

