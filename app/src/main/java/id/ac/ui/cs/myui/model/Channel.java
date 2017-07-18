package id.ac.ui.cs.myui.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agni.wira on 17/07/17.
 */
@Root(name = "channel",strict = false)
public class Channel {

    @Element(name = "title")
    public String title;

    @Element(name = "link")
    public String link;

    @Element(name = "description")
    public String description;

    @Element(name = "generator")
    public String generator;

    @Element(name = "language")
    public String language;

    @Element(name = "copyright")
    public String copyright;

    @Element(name = "image",required = false)
    public ImageNews image;

    @ElementList(name = "item", inline = true, required = false)
    public ArrayList<ItemNews> item;

    public Channel() {}

    public Channel(String title, String link, String description, String generator, String language, String copyright, ImageNews image, ArrayList<ItemNews> item) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.generator = generator;
        this.language = language;
        this.copyright = copyright;
        this.image = image;
        this.item = item;
    }
}
