 package com.e.restaurant;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.util.Log;


public class DBHelper extends SQLiteOpenHelper {

    private static final String TAG = "databasehelper";
    //the first table for registration

    public static final String TABLE_NAME = "Regdetails";
    public static final String identif = "ID";
    public static final String fname = "firstname";
    public static final String lname = "lastname";
    public static final String usn = "username";
    public static final String pass = "password";

    //2nd table for balanced diet and column names
    public static final String TABLE_NAME_one = "balanced";
    public static final String identification = "id_no";
    public static final String carbo = "carbohydrates";
    public static final String qt = "quantity1";
    public static final String pri = "price1";
    public static final String total1 = "cabstotal";
    public static final String pro = "proteins";
    public static final String qnt = "quantity2";
    public static final String pric = "price2";
    public static final String total2 = "proteintotal";
    public static final String vita = "vitamins";
    public static final String qant = "quantity3";
    public static final String pricc = "price3";
    public static final String total3 = "vitamintotal";;

    //3rd table for carbohydrates and proteins
    public static final String TABLE_NAME2 = "carbohydrate_proteins";
    public static final String ide = "id_no";
    public static final String carbohy = "carbohydrates";
    public static final String qt1 = "quantity1";
    public static final String pri1 = "price1";
    public static final String total11 = "cabstotal";
    public static final String prote = "proteins";
    public static final String qnt1 = "quantity2";
    public static final String pri2= "price2";
    public static final String total22 = "proteintotal";

    // 4th table for carbohydrates and vitamins
    private static final String TABLE_NAME3 = "carbohydrate_vitamins";
    public static final String idd = "id_no";
    public static final String carbohyd = "carbohydrates";
    public static final String qt2 = "quantity1";
    public static final String pr2 = "price1";
    public static final String total111 = "cabstotal";
    public static final String vitam = "vitamins";
    public static final String qnt2 = "quantity2";
    public static final String pric2 = "price2";
    public static final String total333 = "vitamintotal";

    // 5th table for vitamins and proteins
    private static final String TABLE_NAME4 = " vitamins_proteins";
    public static final String idden = "idno";
    public static final String vitami = "vitamin";
    public static final String qt3= "quantity1";
    public static final String pri3 = "price1";
    public static final String total3333= "vitamintotal";
    public static final String proteinn = "protein";
    public static final String qnt3 = "quantity2";
    public static final String pric3 = "price2";
    public static final String total2222= "proteintotal";


    //DATABASE NAME
    public static final String DATABASE_NAME = "diet.db";

    static SQLiteDatabase db;


    public DBHelper ( Context context ) {
        super(context, DATABASE_NAME, null, 1);


    }

    public boolean checkUserLogin ( String username, String password ) {
        SQLiteDatabase db = this.getWritableDatabase();
        String whereclause = "username=? and password=?"; //<<<<<<<<<< ?'s will be replaced according to whereargs on a 1 by 1 basis
        String[] whereargs = new String[]{username, password};
        Cursor cursor = db.query(
                "Regdetails",
                new String[]{"username", "password"},
                whereclause,
                whereargs,
                null, null, null
        );
        int count = cursor.getCount();
        cursor.close();
        return count > 0;
    }

    private static final String CREATE_TABLE_register = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+"("+identif+" INTEGER PRIMARY KEY AUTOINCREMENT,"+fname+" TEXT,"+lname+" TEXT,"+usn+" VARCHAR,"+pass+" VARCHAR)";
    private static final String CREATE_TABLE_balanced = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME_one
            + "("
            +identification+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +carbo+" TEXT,"
            +qt+" TEXT,"
            +pri+" INTEGER,"
            +total1+" INTEGER,"
            +pro+" TEXT,"
            +qnt+" INTEGER,"
            +pric+" TEXT,"
            +total2+" INTEGER,"
            +vita+" TEXT,"
            +qant+" INTEGER,"
            +pricc+" INTEGER,"
            +total3+" INTEGER)";

// creating cabohydrates and protein table
    private static final String CREATE_TABLE_cabsprotein = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME2
            +"("
            +ide+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +carbohy+" TEXT,"
            +qt1+" INTEGER,"
            +pri1+" INTEGER,"
            +total11+" INTEGER,"
            +prote+" TEXT,"
            +qnt1+" INTEGER,"
            +pri2+" INTEGER,"
             +total22+" INTEGER)";
//creating cabohydrates and vitamin table
    private static final String CREATE_TABLE_cabsvita = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME3+
            "("
            +idd+" INTEGER PRIMARY KEY,"
            +carbohyd+" TEXT,"
            +qt2+" INTEGER,"
            +pr2+" INTEGER,"
            +total111+" INTEGER,"
            +vitam+" TEXT,"
            +qnt2+" INTEGER,"
            +pric2+" INTEGER,"
            +total333+" INTEGER)";

    private static final String CREATE_TABLE_vitapro = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME4+
            "("+idden+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +vitami+" TEXT,"
            +qt3+" INTEGER,"
            +pri3+" INTEGER,"
            +total3333+" INTEGER,"
            +proteinn+" TEXT,"
            +qnt3+" INTEGER,"
            +pric3+" INTEGER,"
            +total2222+" INTEGER)";

    @Override
    public void onCreate ( SQLiteDatabase db ) {
        db.execSQL(CREATE_TABLE_register);
        db.execSQL(CREATE_TABLE_balanced );
        db.execSQL(CREATE_TABLE_cabsprotein);
        db.execSQL(CREATE_TABLE_cabsvita);
       db.execSQL(CREATE_TABLE_vitapro);

    }

    @Override
    public void onUpgrade ( SQLiteDatabase db, int oldVersion, int newVersion ) {//drop table to create new one if database version updated
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_one);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME3);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME4);
        onCreate(db);

    }

    public boolean insertdata ( String fnm, String lnme, String usnm, String pss ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(fname, fnm);
        contentValues.put(lname, lnme);
        contentValues.put(usn, usnm);
        contentValues.put(pass, pss);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1)
            return false;
        else
            return true;

    }

    // methods of inserting the button valueus to the balanced diet table


    //inserting carbohydrates name amount and price in balanced diet table
    public boolean insertcabohydrates1 ( String fdnm, String qnty, String price,String ttl,
                                         String fdnm1, String qnty1,String price1,String ttl1,
                                         String fdnm2,String qnty2,String price2,String ttl2) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues1 = new ContentValues();
        contentValues1.put(carbo, fdnm);
        contentValues1.put(qt, qnty);
        contentValues1.put(pri, price);
        contentValues1.put(total1, ttl);
        contentValues1.put(pro, fdnm1);
        contentValues1.put(qnt, qnty1);
        contentValues1.put(pric, price1);
        contentValues1.put(total2, ttl1);
        contentValues1.put(vita, fdnm2);
        contentValues1.put(qant, qnty2);
        contentValues1.put(pricc, price2);
        contentValues1.put(total3, ttl2);

        long result = db.insert(TABLE_NAME_one, null, contentValues1);
        if (result == -1)
            return false;
        else
            return true;
    }

    // insert carbohydrates and proteins quantity price into carbs_protein table
    public boolean insertcabo1 ( String fdnm, String qnty, String price,String ttl,
                                 String fdnm1, String qnty1, String price1,String ttl1) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues1 = new ContentValues();
        contentValues1.put(carbohy, fdnm);
        contentValues1.put(qt1, qnty);
        contentValues1.put(pri1, price);
        contentValues1.put(total11, ttl);
        contentValues1.put(prote, fdnm1);
        contentValues1.put(qnt1, qnty1);
        contentValues1.put(pri2, price1);
        contentValues1.put(total22, ttl1);
        long result = db.insert(TABLE_NAME2, null, contentValues1);
        if (result == -1)
            return false;
        else
            return true;
    }

                    // carbohydrates vitamin table

    // insert carbohydrates quantity price into carbs_vita table
    public boolean insertcabo2 ( String fdnm, String qnty, String price,String ttl,
                                 String fdnm1, String qnty2, String price3,String ttl2 ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues1 = new ContentValues();
        contentValues1.put(carbohyd, fdnm);
        contentValues1.put(qt2, qnty);
        contentValues1.put(pr2, price);
        contentValues1.put(total111, ttl);
        contentValues1.put(vitam, fdnm1);
        contentValues1.put(qnt2, qnty2);
        contentValues1.put(pric2, price3);
        contentValues1.put(total333, ttl2);
        long result = db.insert(TABLE_NAME3, null, contentValues1);
        if (result == -1)
            return false;
        else
            return true;
    }

                    //vitamin protein table

// insert vitamins quantity price into vita_protein table
public boolean insertvita3 ( String fdnm, String qnty, String price,String ttl2,
                             String fdnm1, String qnty1, String price1,String ttl1) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues contentValues1 = new ContentValues();
    contentValues1.put(vitami, fdnm);
    contentValues1.put(qt3, qnty);
    contentValues1.put(pri3, price);
    contentValues1.put(total3333, ttl2);
    contentValues1.put(proteinn, fdnm1);
    contentValues1.put(qnt3, qnty1);
    contentValues1.put(pric3, price1);
    contentValues1.put(total2222, ttl1);
    long result = db.insert(TABLE_NAME4, null, contentValues1);
    if (result == -1)
        return false;
    else
        return true;
}
    // inserting proteins in vita_protein table
    public boolean insertprote3 ( String fdnm, String qnty, String price ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues1 = new ContentValues();

        long result = db.insert(TABLE_NAME4, null, contentValues1);
        if (result == -1)
            return false;
        else
            return true;
    }

    public String getLoginData ( String name, String password1 ) {
        SQLiteDatabase sql = this.getReadableDatabase();
        String query = " select count(*) from " + TABLE_NAME_one+ " where username =? and password=?";
        Cursor cursor = sql.rawQuery(query, null);
        cursor.moveToFirst();
        String count = cursor.getString(cursor.getColumnIndex(cursor.getColumnName(0)));
        return count;
    }
    // display all data from balanced diet table
    public Cursor getdata () {
    SQLiteDatabase db = this.getWritableDatabase();
    String query = "SELECT * FROM " + TABLE_NAME_one;
    Cursor data = db.rawQuery(query,null);
   return data;
    }
    //display all data from carbohydrates protein table
    public Cursor getdata2 () {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME2;
        Cursor data = db.rawQuery(query,null);
        return data;
    }
    // display all data from carbohydrates vitamin
    public Cursor getdata3 () {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME3,null);
        return data;
    }
    // display data all data from vitamin proteins table
    public Cursor getdata4 () {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME4;
        Cursor data = db.rawQuery(query,null);
        return data;
    }

    // delete value from balanced diet table
public Integer deletedata1(String id){
    SQLiteDatabase db = this.getWritableDatabase();
    return db.delete(TABLE_NAME_one,"id_no=?", new String[] {id} );
}
// delete value from carbohydrates_proteins table
    public Integer deletedata2(String id){
        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(TABLE_NAME2,"id_no=?", new String[] {id} );
    }
    // delete value from carbohydrates_vitamin table
    public Integer deletedata3(String id){
        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(TABLE_NAME3,"id_no=?", new String[] {id} );
    }
    // delete value from vitamin protein table
    public Integer deletedata4(String id){
        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(TABLE_NAME4,"id_no=?", new String[] {id} );
    }
    //find sum of carbohydrates total in balanced diet
    public int sumcabs (){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT SUM(cabstotal) FROM " + TABLE_NAME_one, null);
        c.moveToFirst();
        int i = c.getInt(0);
        c.close();
        return  i; }
    //find sum of carbohydrates total in cabs protein diet
    public int sumcabs2(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT SUM(cabstotal) FROM " + TABLE_NAME2, null);
        c.moveToFirst();
        int i = c.getInt(0);
        c.close();
        return  i; }
    //find sum of carbohydrates total in carbohydrates vitamin diet
    public int sumcabs3 (){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT SUM(cabstotal) FROM " + TABLE_NAME3, null);
        c.moveToFirst();
        int i = c.getInt(0);
        c.close();
        return  i; }
    //find sum of proteins total in balanced diet
    public int sumpro1 (){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT SUM(proteintotal) FROM " + TABLE_NAME_one, null);
        c.moveToFirst();
        int i = c.getInt(0);
        c.close();
        return  i; }
    //find sum of proteins total in carb and pro diet
    public int sumpro2 (){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT SUM(proteintotal) FROM " + TABLE_NAME2, null);
        c.moveToFirst();
        int i = c.getInt(0);
        c.close();
        return  i; }
    //find sum of proteins total in vitamin and pro diet
    public int sumpro4 (){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT SUM(proteintotal) FROM " + TABLE_NAME4, null);
        c.moveToFirst();
        int i = c.getInt(0);
        c.close();
        return  i; }
    //find sum of vitamin total in balanced diet
    public int sumvita1 (){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT SUM(vitamintotal) FROM " + TABLE_NAME_one, null);
        c.moveToFirst();
        int i = c.getInt(0);
        c.close();
        return  i; }
    //find sum of vitamin total in carbohydrates vitamin diet
    public int sumvita3 (){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT SUM(vitamintotal) FROM " + TABLE_NAME3, null);
        c.moveToFirst();
        int i = c.getInt(0);
        c.close();
        return  i; }
// sum of vitamin total in vitamin proteins
    public int sumvita4 (){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT SUM(vitamintotal) FROM " + TABLE_NAME4, null);
        c.moveToFirst();
        int i = c.getInt(0);
        c.close();
        return  i; }

}




