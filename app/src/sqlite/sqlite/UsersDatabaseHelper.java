package ws.idroid.sqlite;
import ws.idroid.sqlite.User;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;

import androidx.annotation.Nullable;
import androidx.core.database.sqlite.SQLiteDatabaseKt;

import java.sql.Blob;
import java.util.ArrayList;


public class UsersDatabaseHelper extends SQLiteOpenHelper {
    private static final  String DATABASE_NAME ="USERsDB";
    private static final  String TABLE_USERS ="USERS";
    private static final  String TABLE_USERS_FAVOURITE ="FAVOURITE";
    private static final  String KEY_ID ="USERS_id";
    private static final  String KEY_ID_FAVOURITE ="FAVOURITE_id";

    private static final  String KEY_USERNAME ="USERNAME";
    private static final  String KEY_PASSWORD ="PASSWORD";
    private static final  String KEY_FAVOURITE ="FAVOURITE";
    private static final  String KEY_FAVOURITE_DESCRIPTION ="DESCRIPTION";
    private static final  String KEY_FAVOURITE_PICTURE ="PICTURE" ;
    private static final  int DB_VERSION =1;

    public UsersDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "
                +TABLE_USERS
                +" ( "+KEY_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                +KEY_USERNAME+ "text,"
                +KEY_PASSWORD+ "text )");

        sqLiteDatabase.execSQL("CREATE TABLE "
                +TABLE_USERS_FAVOURITE
                +"("+KEY_ID_FAVOURITE+ " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                +KEY_FAVOURITE+ "text,"
                +KEY_FAVOURITE_DESCRIPTION+ "text,"
                +KEY_FAVOURITE_PICTURE+ "blob,"

                +"KEY_ID INTERGER, FOREIGN KEY (KEY_ID) REFERENCES "
                +TABLE_USERS +"('KEY_ID') )"
                );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_USERS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_USERS_FAVOURITE);
        onCreate(sqLiteDatabase);
    }

    public boolean insertUser(User user){
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_USERNAME,user.getUSERNAME());
        contentValues.put(KEY_PASSWORD,user.getPASSWORD());
        sql.insert(TABLE_USERS,null,contentValues);
        sql.close();
        return true;
    }
    public boolean insertFavourite(User user,String favourite){
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_ID,user.getId());
        contentValues.put(KEY_FAVOURITE,favourite);
        sql.insert(TABLE_USERS_FAVOURITE,null,contentValues);
        sql.close();
        return true;
    }

    public ArrayList<Favourites> showAllFavourite (String id){//id of user
        SQLiteDatabase sql = this.getReadableDatabase();
        ArrayList<Favourites> arrayList = new ArrayList<>();
        Cursor cursor =sql.rawQuery("SELECT * FROM "+TABLE_USERS_FAVOURITE+" WHERE USERS_id=? ", new String[]{id});
        if(cursor.moveToFirst()) {
            do {
                arrayList.add(new Favourites(cursor.getInt(cursor.getColumnIndex(KEY_ID_FAVOURITE)),
                        cursor.getString(cursor.getColumnIndex(KEY_FAVOURITE)),
                        cursor.getString(cursor.getColumnIndex(KEY_FAVOURITE_DESCRIPTION))));

            } while (cursor.moveToNext());
        }
        cursor.close();
        sql.close();
        return arrayList;
    }
    public int deleteFavourite(int id){
       SQLiteDatabase sql = this.getWritableDatabase();
       int res = sql.delete(TABLE_USERS_FAVOURITE,"FAVOURITE_id=?", new String[]{String.valueOf(id)});
       sql.close();
       return res;
    }


}
