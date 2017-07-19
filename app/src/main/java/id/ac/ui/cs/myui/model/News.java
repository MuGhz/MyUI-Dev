package id.ac.ui.cs.myui.model;

/**
 * Created by agni.wira on 18/07/17.
 */

public class News {
    private String title;
    private String description;
    private String link;
    private long id;
    private String tanggal;
    private String penulis;
    private boolean bookmarked;

    public News(){
        this.bookmarked=false;

    }
    public News(String title, String description, String link, String tanggal, String penulis) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.tanggal = tanggal;
        this.penulis = penulis;
        this.bookmarked = false;
    }

        public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public boolean isBookmarked() {
        return bookmarked;
    }

    public void setBookmarked(boolean bookmarked) {
        this.bookmarked = bookmarked;
    }



}

