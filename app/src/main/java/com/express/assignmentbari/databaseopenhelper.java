package com.express.assignmentbari;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class databaseopenhelper extends SQLiteOpenHelper {
    public static final  String database_name="system.db";
    public static final  String table1="physics";
    public static final  String table2="chemistry";
    public static final  String table3="biology";
    public static final  String table4="urdu";
    public static final  String table5="english";
    //physics
    public static final  String physics1="id";
    public static final  String physics2="name";
    public static final  String physics3="subject";
    public static final  String physics4="marks";
    //chemistry
    public static final  String chemistry1="id";
    public static final  String chemistry2="name";
    public static final  String chemistry3="subject";
    public static final  String chemistry4="marks";
    //biology
    public static final  String biology1="id";
    public static final  String biology2="name";
    public static final  String biology3="subject";
    public static final  String biology4="marks";
    //urdu
    public static final  String urdu1="id";
    public static final  String urdu2="name";
    public static final  String urdu3="subject";
    public static final  String urdu4="marks";
    //english
    public static final  String english1="id";
    public static final  String english2="name";
    public static final  String english3="subject";
    public static final  String english4="marks";

    public databaseopenhelper(@Nullable Context context) {
        super(context, database_name, null, 1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL("create table "+table1+"(id integer primary key autoincrement,name text,subject text,marks integer)");
        db.execSQL("create table "+table2+"(id integer primary key autoincrement,name text,subject text,marks integer)");
        db.execSQL("create table "+table3+"(id integer primary key autoincrement,name text,subject text,marks integer)");
        db.execSQL("create table "+table4+"(id integer primary key autoincrement,name text,subject text,marks integer)");
        db.execSQL("create table "+table5+"(id integer primary key autoincrement,name text,subject text,marks integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("drop table if exists "+table1);
        db.execSQL("drop table if exists "+table2);
        db.execSQL("drop table if exists "+table3);
        db.execSQL("drop table if exists "+table4);
        db.execSQL("drop table if exists "+table5);
        onCreate(db);
    }
    //english
    public boolean insertdataeng(String name,String subject,String marks){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(english2,name);
        contentValues.put(english3,subject);
        contentValues.put(english4,marks);
        long result=db.insert(table5,null,contentValues);
        if (result==-1)
            return false;
        return
                true;
    }
    public Cursor getalldataeng(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+table5,null);
        return res;
    }
    public boolean updatedataeng(String id,String name,String subject,String marks){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(english1,id);
        contentValues.put(english2,name);
        contentValues.put(english3,subject);
        contentValues.put(english4,marks);

        db.update(table5,contentValues,"ID=?",new String[]{id});
        return true;
    }
    public Integer deletedataeng(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(table5,"ID=?",new String[]{id});
    }
    //urdu
    public boolean insertdataurdu(String name,String subject,String marks){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(urdu2,name);
        contentValues.put(urdu3,subject);
        contentValues.put(urdu4,marks);
        long result=db.insert(table4,null,contentValues);
        if (result==-1)
            return false;
        return
                true;
    }
    public Cursor getalldataurdu(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+table4,null);
        return res;
    }
    public boolean updatedataurdu(String id,String name,String subject,String marks){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(urdu1,id);
        contentValues.put(urdu2,name);
        contentValues.put(urdu3,subject);
        contentValues.put(urdu4,marks);

        db.update(table4,contentValues,"ID=?",new String[]{id});
        return true;
    }
    public Integer deletedataurdu(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(table4,"ID=?",new String[]{id});
    }
    //bio
    public boolean insertdatabio(String name,String subject,String marks){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(biology2,name);
        contentValues.put(biology3,subject);
        contentValues.put(biology4,marks);
        long result=db.insert(table3,null,contentValues);
        if (result==-1)
            return false;
        return
                true;
    }
    public Cursor getalldatabio(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+table3,null);
        return res;
    }
    public boolean updatedatabio(String id,String name,String subject,String marks){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(biology1,id);
        contentValues.put(biology2,name);
        contentValues.put(biology3,subject);
        contentValues.put(biology4,marks);

        db.update(table3,contentValues,"ID=?",new String[]{id});
        return true;
    }
    public Integer deletedatabio(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(table3,"ID=?",new String[]{id});
    }
    //chem
    public boolean insertdatachem(String name,String subject,String marks){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(chemistry2,name);
        contentValues.put(chemistry3,subject);
        contentValues.put(chemistry4,marks);
        long result=db.insert(table2,null,contentValues);
        if (result==-1)
            return false;
        return
                true;
    }
    public Cursor getalldatachem(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+table2,null);
        return res;
    }
    public boolean updatedatachem(String id,String name,String subject,String marks){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(chemistry1,id);
        contentValues.put(chemistry2,name);
        contentValues.put(chemistry3,subject);
        contentValues.put(chemistry4,marks);

        db.update(table2,contentValues,"ID=?",new String[]{id});
        return true;
    }
    public Integer deletedatachem(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(table2,"ID=?",new String[]{id});
    }
    //phy
    public boolean insertdataphy(String name,String subject,String marks){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(physics2,name);
        contentValues.put(physics3,subject);
        contentValues.put(physics4,marks);
        long result=db.insert(table1,null,contentValues);
        if (result==-1)
            return false;
        return
                true;
    }
    public Cursor getalldataphy(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+table1,null);
        return res;
    }
    public boolean updatedataphy(String id,String name,String subject,String marks){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(physics1,id);
        contentValues.put(physics2,name);
        contentValues.put(physics3,subject);
        contentValues.put(physics4,marks);

        db.update(table1,contentValues,"ID=?",new String[]{id});
        return true;
    }
    public Integer deletedataphy(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(table1,"ID=?",new String[]{id});
    }
}
