package com.java.mahbixver20;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

public class DBManager extends SQLiteOpenHelper {

    private static final String dbName = "dbContact";

    public DBManager(@Nullable Context context) {
        super(context, dbName, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
            String qry = "create table tbl_contact (id integer primary key autoincrement, name text, prize integer)";
            db.execSQL(qry );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String qry = "DROP TABLE IF EXISTS tbl_contact";
        db.execSQL(qry);
        onCreate(db);
    }
    public String addRecord(String name,String prize){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("prize",prize);

        float res =db.insert("tbl_contact",null,cv);


        if(res == -1 )
            return "failed";
        else
            return "SuccessFully inserted";
    }

    public Cursor readAllData(){
        SQLiteDatabase db =this.getWritableDatabase();
        String qry = "select * from tbl_contact order by id desc";
        Cursor cursor = db.rawQuery(qry,null);
        return cursor;
    }
}
