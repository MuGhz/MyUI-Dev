package id.ac.ui.cs.myui.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/**
 * Created by agni.wira on 17/07/17.
 */
@Root(name = "rss",strict = false)
public class NewsScele {

    @Element(name = "channel")
    public Channel channel;


    public NewsScele(Channel channel) {
        this.channel = channel;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}
