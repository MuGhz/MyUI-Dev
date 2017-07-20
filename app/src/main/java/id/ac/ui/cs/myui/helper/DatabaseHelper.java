package id.ac.ui.cs.myui.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import id.ac.ui.cs.myui.model.CalendarItem;

import id.ac.ui.cs.myui.schema.CalendarSchema;

/**
 * Created by siti.ina on 18/07/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static int DATABASE_VERSION = 1;
        private static String DATABASE_NAME = "kalender.db";
    private String databasePath;
    private SQLiteDatabase db;

    private static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + CalendarSchema.CalendarTable.TABLE_NAME + "(" +
                    CalendarSchema.CalendarTable._ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+
                    CalendarSchema.CalendarTable.COLUMN_NAME_TANGGAL_MULAI + " TEXT, " +
                    CalendarSchema.CalendarTable.COLUMN_NAME_TANGGAL_SELESAI + " TEXT, " +
                    CalendarSchema.CalendarTable.COLUMN_NAME_DURASI + " TEXT, " +
                    CalendarSchema.CalendarTable.COLUMN_NAME_PELAKSANA + " TEXT, " +
                    CalendarSchema.CalendarTable.COLUMN_NAME_NAMA_KEGIATAN + " TEXT"+")";

    private static final String SQL_DROP_TABLE =
            "DROP TABLE IF EXIST " + CalendarSchema.CalendarTable.TABLE_NAME;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        databasePath = context.getExternalFilesDir(null) +"/"+ DATABASE_NAME;
        openDb();
    }

    private void openDb() {
        Log.d("DEBUG", "OPENING DATABASE CONNECTION");
        if(!checkDb())
            db = SQLiteDatabase.openOrCreateDatabase(databasePath, null);
        else
            db = SQLiteDatabase.openDatabase(databasePath, null, SQLiteDatabase.OPEN_READWRITE);

        Log.d("DEBUG", "Database path = "+ db.getPath());
        Log.d("DEBUG", "DB is read only? "+ db.isReadOnly());

        if(!checkTable(CalendarSchema.CalendarTable.TABLE_NAME)) {
            Log.d("DEBUG", "Table is not exist, create new one");
            db.execSQL(SQL_CREATE_TABLE);
        }
        else
            Log.d("DEBUG", "Table exists");
    }

    private boolean checkTable(String tableName) {
        String sql = "SELECT _id FROM "+tableName;
        if(db.isOpen()) {
            try {
                Cursor cur = db.rawQuery(sql, null);
                cur.close();
                return true;
            } catch (SQLiteException e) {
                return false;
            }
        }
        else return false;
    }

    private boolean checkDb() {
        File db = new File(databasePath);
        if(db.exists()) {
            Log.d("DEBUG", "Database exist");
            return true;
        }
        else return false;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        if(!checkDB()) {
//            sqLiteDatabase.execSQL(SQL_CREATE_TABLE);
//        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//        sqLiteDatabase.execSQL(SQL_DROP_TABLE);
//        onCreate(sqLiteDatabase);
    }

    private boolean checkDB() {
        File db = new File(databasePath);
        if(db.exists()) {
            Log.d("debug", "database exist");
            return db.exists();
        } else return false;

    }

    public void insertMenu (List<CalendarItem> calendarItems) {
        String sqlDelete = "DELETE FROM "+CalendarSchema.CalendarTable.TABLE_NAME;
        String sqlInsert = "INSERT INTO "+CalendarSchema.CalendarTable.TABLE_NAME+"("+
                CalendarSchema.CalendarTable.COLUMN_NAME_TANGGAL_MULAI +","+
                CalendarSchema.CalendarTable.COLUMN_NAME_TANGGAL_SELESAI +","+
                CalendarSchema.CalendarTable.COLUMN_NAME_DURASI+","+
                CalendarSchema.CalendarTable.COLUMN_NAME_PELAKSANA+","+
                CalendarSchema.CalendarTable.COLUMN_NAME_NAMA_KEGIATAN+
                ") VALUES (?, ?, ?, ?, ?)";
        if(db.isOpen()) {
            Log.d("DEBUG", "SQLite database open");
            db.execSQL(sqlDelete);
            Log.d("DEBUG","Delete all record on menu_item table");

            SQLiteStatement sqLiteStatement = db.compileStatement(sqlInsert);
            for (CalendarItem item : calendarItems) {
                sqLiteStatement.bindString(1, item.getTanggalMulai());
                sqLiteStatement.bindString(2, item.getTanggalSelesai());
                sqLiteStatement.bindLong(3, item.getDurasi());
                sqLiteStatement.bindString(4, item.getPelaksana());
                sqLiteStatement.bindString(5, item.getNamaKegiatan());
                sqLiteStatement.execute();
                sqLiteStatement.clearBindings();
                Log.d("DEBUG", "Finish insert record : "+ new Gson().toJson(item));
            }
            sqLiteStatement.close();
        }
    }

    public List<CalendarItem> getAllParentMenu() {
        List<CalendarItem> itemList = new ArrayList<CalendarItem>();
        String query = "SELECT _id, tanggal_mulai, tanggal_selesai, durasi, pelaksana, nama_kegiatan FROM calendar_item";
        Cursor cur = db.rawQuery(query, null);
        Log.d("DEBUG ALL PARENT", "Total Menu = "+cur.getCount());
        if(cur.getCount() > 0) {
            if(cur.moveToFirst()) {
            Log.i("tes", "masuk ke 1");
                while(!cur.isAfterLast()) {

                    CalendarItem item = new CalendarItem();
                    item.setId(cur.getLong(cur.getColumnIndex("_id")));
                    item.setTanggalMulai(cur.getString(cur.getColumnIndex(CalendarSchema.CalendarTable.COLUMN_NAME_TANGGAL_MULAI)));
                    item.setTanggalSelesai(cur.getString(cur.getColumnIndex(CalendarSchema.CalendarTable.COLUMN_NAME_TANGGAL_SELESAI)));
                    item.setDurasi(cur.getInt(cur.getColumnIndex(CalendarSchema.CalendarTable.COLUMN_NAME_DURASI)));
                    item.setPelaksana(cur.getString(cur.getColumnIndex(CalendarSchema.CalendarTable.COLUMN_NAME_PELAKSANA)));
                    item.setNamaKegiatan(cur.getString(cur.getColumnIndex(CalendarSchema.CalendarTable.COLUMN_NAME_NAMA_KEGIATAN)));

                    itemList.add(item);
                    cur.moveToNext();

                }
            }
        }
        cur.close();
        return itemList;
    }

    
}
