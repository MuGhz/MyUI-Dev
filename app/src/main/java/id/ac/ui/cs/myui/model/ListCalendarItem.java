package id.ac.ui.cs.myui.model;

/**
 * Created by Ivan on 7/17/17.
 */

public class ListCalendarItem {
    private String namaKegiatan;
    private String tanggalKegiatan;

    public ListCalendarItem(String namaKegiatan, String tanggalKegiatan) {
        this.namaKegiatan = namaKegiatan;
        this.tanggalKegiatan = tanggalKegiatan;
    }

    public String getNamaKegiatan() {
        return namaKegiatan;
    }

    public void setNamaKegiatan(String namaKegiatan) {
        this.namaKegiatan = namaKegiatan;
    }

    public String getTanggalKegiatan() {
        return tanggalKegiatan;
    }

    public void setTanggalKegiatan(String tanggalKegiatan) {
        this.tanggalKegiatan = tanggalKegiatan;
    }
}
