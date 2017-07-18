package id.ac.ui.cs.myui.model;

/**
 * Created by muhammad.ghozi41 on 18/07/17.
 */
public class News {
    private int newsId;
    private String newsTitle;
    private String newsContent;
    private String newsDate;
    private String newsDateEdited;
    private String newsSubmitBy;
    private String newsEditedBy;
    private boolean bookmarked;

    public News(){
        this.bookmarked=false;
    }

    public News(String newsTitle, String newsContent, String newsDate, String newsDateEdited, String newsSubmitBy, String newsEditedBy) {
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
        this.newsDate = newsDate;
        this.newsDateEdited = newsDateEdited;
        this.newsSubmitBy = newsSubmitBy;
        this.newsEditedBy = newsEditedBy;
        this.bookmarked = false;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
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
