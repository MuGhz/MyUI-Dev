package id.ac.ui.cs.myui.model;

import org.simpleframework.xml.Element;

/**
 * Created by agni.wira on 17/07/17.
 */

public class ImageNews {
    @Element(name = "url")
    String url;

    @Element(name = "title")
    String title;

    @Element(name = "link")
    String link;

    @Element(name = "width")
    long width;

    @Element(name = "height")
    long height;

    public ImageNews(){};

    public ImageNews(String url, String title, String link, long width, long height) {
        this.url = url;
        this.title = title;
        this.link = link;
        this.width = width;
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public long getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }
}
