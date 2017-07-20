package id.ac.ui.cs.myui.model;

import android.text.Html;
import android.util.Log;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.Date;

/**
 * Created by agni.wira on 17/07/17.
 */
@Root(name = "item",strict = false)
public class ItemNews {
    @Element(name ="title")
    String title;

    @Element(name ="link")
    String link;

    @Element(name = "pubDate")
    String pubdate;

    @Element(name="description")
    String description;

    @Path("guid")
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

    public String getPenulis(){
        String raw = getDescription();
        String [] subRaw = raw.split("\\. ");
        String [] penulis = subRaw[0].split("by ");

        return penulis[1];
    }

    public String stripHtml(String html) {
        return Html.fromHtml(html).toString().replaceAll("\n", "").trim();
    }

    public String getContent(){
        String raw = getDescription();
        String [] subRaw = raw.split("\\. ");

        String akhir = "";
        for(int i= 1; i<subRaw.length;i++){
            akhir += subRaw[i];
        }

        return stripHtml(akhir);

    }
}
