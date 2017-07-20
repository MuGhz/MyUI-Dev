package id.ac.ui.cs.myui.model;



/**
 * Created by Ivan on 7/17/17.
 */

public class CalendarItem{
    private long id;
    private String tanggalMulai;
    private String tanggalSelesai;
    private int durasi;
    private String pelaksana;
    private String namaKegiatan;


    public CalendarItem(long id, String tanggalMulai, String tanggalSelesai, int durasi, String pelaksana, String namaKegiatan) {
        this.id = id;
        this.tanggalMulai = tanggalMulai;
        this.tanggalSelesai = tanggalSelesai;
        this.durasi = durasi;
        this.pelaksana = pelaksana;
        this.namaKegiatan = namaKegiatan;
    }

    public CalendarItem() {
    }

    public String getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(String tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public String getTanggalSelesai() {
        return tanggalSelesai;
    }

    public void setTanggalSelesai(String tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }

    public int getDurasi() {
        return durasi;
    }

    public void setDurasi(int durasi) {
        this.durasi = durasi;
    }

    public String getPelaksana() {
        return pelaksana;
    }

    public void setPelaksana(String pelaksana) {
        this.pelaksana = pelaksana;
    }

    public String getNamaKegiatan() {
        return namaKegiatan;
    }

    public void setNamaKegiatan(String namaKegiatan) {
        this.namaKegiatan = namaKegiatan;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
