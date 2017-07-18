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
    private static final String COLUMN_NEWSID = "newsId";
    private static final String COLUMN_NEWSTITLE = "newsTitle";
    private static final String COLUMN_NEWSCONTENT = "newsContent";
    private static final String COLUMN_NEWSDATE = "newsDate";
    private static final String COLUMN_NEWSDATEEDITED = "newsDateEdited";
    private static final String COLUMN_NEWSSUBMITBY = "newsSubmitBy";
    private static final String COLUMN_NEWSEDITEDBY = "newsEditedBy";
    private static final String COLUMN_BOOKMARKED = "bookmarked";
    // create table sql query
    private String CREATE_NEWS_TABLE = "CREATE TABLE " + TABLE_NEWS + "("
            + COLUMN_NEWSID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NEWSTITLE + " TEXT,"
            + COLUMN_NEWSCONTENT + " TEXT," + COLUMN_NEWSDATE + " TEXT," + COLUMN_NEWSDATEEDITED + " TEXT," +
            COLUMN_NEWSSUBMITBY + " TEXT," + COLUMN_NEWSEDITEDBY + " TEXT,"+ COLUMN_BOOKMARKED + " INT"+")";

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
        values.put(COLUMN_NEWSTITLE, news.getNewsTitle());
        values.put(COLUMN_NEWSCONTENT , news.getNewsContent());
        values.put(COLUMN_NEWSDATE, news.getNewsDate());
        values.put(COLUMN_NEWSDATEEDITED, news.getNewsDateEdited());
        values.put(COLUMN_NEWSSUBMITBY, news.getNewsSubmitBy());
        values.put(COLUMN_NEWSEDITEDBY, news.getNewsEditedBy());
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
        values.put(COLUMN_NEWSTITLE, news.getNewsTitle());
        values.put(COLUMN_NEWSCONTENT , news.getNewsContent());
        values.put(COLUMN_NEWSDATE, news.getNewsDate());
        values.put(COLUMN_NEWSDATEEDITED, news.getNewsDateEdited());
        values.put(COLUMN_NEWSSUBMITBY, news.getNewsSubmitBy());
        values.put(COLUMN_NEWSEDITEDBY, news.getNewsEditedBy());
        if(news.isBookmarked() ){
            values.put(COLUMN_BOOKMARKED, 0);
        } else {
            values.put(COLUMN_BOOKMARKED, 1);
        }
        // updating row
        db.update(TABLE_NEWS, values, COLUMN_NEWSID + " = ?",
                new String[]{String.valueOf(news.getNewsId())});
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
                COLUMN_NEWSID,
                COLUMN_NEWSTITLE,
                COLUMN_NEWSCONTENT,
                COLUMN_NEWSDATE,
                COLUMN_NEWSDATEEDITED,
                COLUMN_NEWSSUBMITBY,
                COLUMN_NEWSEDITEDBY,
                COLUMN_BOOKMARKED
        };
        // sorting orders
        String sortOrder =
                COLUMN_NEWSID + " ASC";
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
                news.setNewsId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_NEWSID))));
                news.setNewsTitle(cursor.getString(cursor.getColumnIndex(COLUMN_NEWSTITLE)));
                news.setNewsContent(cursor.getString(cursor.getColumnIndex(COLUMN_NEWSCONTENT)));
                news.setNewsDate(cursor.getString(cursor.getColumnIndex(COLUMN_NEWSDATE)));
                news.setNewsDateEdited(cursor.getString(cursor.getColumnIndex(COLUMN_NEWSDATEEDITED)));
                news.setNewsSubmitBy(cursor.getString(cursor.getColumnIndex(COLUMN_NEWSSUBMITBY)));
                news.setNewsEditedBy(cursor.getString(cursor.getColumnIndex(COLUMN_NEWSEDITEDBY)));
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