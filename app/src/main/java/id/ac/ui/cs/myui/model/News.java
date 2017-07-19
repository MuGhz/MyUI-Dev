package id.ac.ui.cs.myui.model;

/**
 * Created by Ivan on 7/18/17.
 */

public class News {
    private String id;
    private String newsTitle;
    private String newsContent;
    private String newsDate;
    private String newsDateEdited;
    private String newsSubmitBy;
    private String newsEditedBy;
    private boolean bookmarked;

    public News(String newsTitle, String newsContent, String newsDate, String newsDateEdited, String newsSubmitBy, String newsEditedBy) {
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
        this.newsDate = newsDate;
        this.newsDateEdited = newsDateEdited;
        this.newsSubmitBy = newsSubmitBy;
        this.newsEditedBy = newsEditedBy;
        this.bookmarked = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(String newsDate) {
        this.newsDate = newsDate;
    }

    public String getNewsDateEdited() {
        return newsDateEdited;
    }

    public void setNewsDateEdited(String newsDateEdited) {
        this.newsDateEdited = newsDateEdited;
    }

    public String getNewsSubmitBy() {
        return newsSubmitBy;
    }

    public void setNewsSubmitBy(String newsSubmitBy) {
        this.newsSubmitBy = newsSubmitBy;
    }

    public String getNewsEditedBy() {
        return newsEditedBy;
    }

    public void setNewsEditedBy(String newsEditedBy) {
        this.newsEditedBy = newsEditedBy;
    }

    public boolean isBookmarked() {
        return bookmarked;
    }

    public void setBookmarked(boolean bookmarked) {
        this.bookmarked = bookmarked;
    }
}
