package schema;

import android.provider.BaseColumns;

/**
 * Created by siti.ina on 18/07/17.
 */

public class CalendarSchema {
    private  CalendarSchema() {}

    public static class CalendarTable implements BaseColumns {
        public static final String TABLE_NAME = "calendar_item";
        public static final String COLUMN_NAME_TANGGAL_MULAI= "tanggal_mulai";
        public static final String COLUMN_NAME_TANGGAL_SELESAI= "tanggal_selesai";
        public static final String COLUMN_NAME_DURASI = "durasi";
        public static final String COLUMN_NAME_PELAKSANA = "pelaksana";
        public static final String COLUMN_NAME_NAMA_KEGIATAN = "nama_kegiatan";

    }
}


