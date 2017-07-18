package id.ac.ui.cs.myui.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import id.ac.ui.cs.myui.model.News;

/**
 * Created by muhammad.ghozi41 on 18/07/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "MyUI.db";

    // User table name
    private static final String TABLE_NEWS = "news";

    // User Table Columns names
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_TANGGAL = "tanggal";
    private static final String COLUMN_PENULIS = "penulis";
    private static final String COLUMN_BOOKMARKED = "bookmarked";
    private static final String COLUMN_LINK = "link";
    // create table sql query
    private String CREATE_NEWS_TABLE = "CREATE TABLE " + TABLE_NEWS + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_TITLE + " TEXT,"
            + COLUMN_DESCRIPTION + " TEXT," + COLUMN_TANGGAL + " TEXT,"  +
            COLUMN_PENULIS + " TEXT,"+ COLUMN_BOOKMARKED + " INT,"+ COLUMN_LINK +" TEXT"+")";

    // drop table sql query
    private String DROP_NEWS_TABLE = "DROP TABLE IF EXISTS " + TABLE_NEWS;

    /**
     * Constructor
     *
     * @param context
     */
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_NEWS_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db.execSQL(DROP_NEWS_TABLE);

        // Create tables again
        onCreate(db);

    }
    public void addNews(News news){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, news.getTitle());
        values.put(COLUMN_DESCRIPTION , news.getDescription());
        values.put(COLUMN_TANGGAL, news.getTanggal());
        values.put(COLUMN_PENULIS, news.getPenulis());
        values.put(COLUMN_LINK,news.getLink());

        if(news.isBookmarked() ){
            values.put(COLUMN_BOOKMARKED, 1);
        } else {
            values.put(COLUMN_BOOKMARKED, 0);
        }

        // Inserting Row
        db.insert(TABLE_NEWS, null, values);
        db.close();

    }
    public void updateBookmark(News news){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, news.getTitle());
        values.put(COLUMN_DESCRIPTION , news.getDescription());
        values.put(COLUMN_TANGGAL, news.getTanggal());
        values.put(COLUMN_PENULIS, news.getPenulis());
        values.put(COLUMN_LINK,news.getLink());
        if(news.isBookmarked() ){
            values.put(COLUMN_BOOKMARKED, 1);
        } else {
            values.put(COLUMN_BOOKMARKED, 0);
        }
        // updating row
        db.update(TABLE_NEWS, values, COLUMN_ID + " = ?",
                new String[]{String.valueOf(news.getId())});
        db.close();
    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<News> getAllBookmarkedNews() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_ID,
                COLUMN_TITLE,
                COLUMN_DESCRIPTION,
                COLUMN_TANGGAL,
                COLUMN_PENULIS,
                COLUMN_BOOKMARKED,
                COLUMN_LINK
        };
        // sorting orders
        String sortOrder =
                COLUMN_ID + " ASC";
        List<News> bookmarkedNewsList = new ArrayList<News>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_NEWS, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                News news = new News();
                news.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_ID))));
                news.setTitle(cursor.getString(cursor.getColumnIndex(COLUMN_TITLE)));
                news.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)));
                news.setTanggal(cursor.getString(cursor.getColumnIndex(COLUMN_TANGGAL)));
                news.setPenulis(cursor.getString(cursor.getColumnIndex(COLUMN_PENULIS)));
                news.setLink(cursor.getString(cursor.getColumnIndex(COLUMN_LINK)));
                if(cursor.getInt(cursor.getColumnIndex(COLUMN_BOOKMARKED)) >0){
                    news.setBookmarked(true);
                } else {
                    news.setBookmarked(false);
                }


                // Adding user record to list
               if (news.isBookmarked()){
                    bookmarkedNewsList.add(news);
                }

            } while (cursor.moveToNext());}
        cursor.close();
        db.close();

        // return user list
        return bookmarkedNewsList;
    }
}