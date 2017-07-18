package id.ac.ui.cs.myui.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by agni.wira on 17/07/17.
 */
@Root(name = "item",strict = false)
public class ItemNews {
    @Element(name = "title")
    String title;

    @Element(name = "link")
    String link;

    @Element(name = "pubdate")
    String pubdate;

    @Element(name = "description")
    String description;

    @Element(name = "guid")
    String guid;

    public ItemNews(){};

    public ItemNews(String title, String link, String pubdate, String description, String guid) {
        this.title = title;
        this.link = link;
        this.pubdate = pubdate;
        this.description = description;
        this.guid = guid;
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

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
}
