package id.ac.ui.cs.myui.model;

import org.junit.Before;
import org.junit.Test;


import id.ac.ui.cs.myui.factory.NewsFactory;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Ivan on 7/18/17.
 */

public class NewsUnitTest {
    private News news;
    private String newsTitle = "Berita 1";
    private String newsContent = "orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
    private String newsDate = "2017-01-01";
    private String newsDateEdited = newsDate;
    private String newsSubmitBy = "Orang 1";
    private String newsEditedBy = newsSubmitBy;

    @Before
    public void setUp() throws Exception {
        news = NewsFactory.getNews();
    }

    @Test
    public void getNewsTitle() throws Exception {
        assertEquals(newsTitle, news.getTitle());
    }

    @Test
    public void getNewsContent() throws Exception {
        assertEquals(newsContent, news.getDescription());
    }

    @Test
    public void getNewsDate() throws Exception {
        assertEquals(newsDate, news.getTanggal());
    }

    @Test
    public void getNewsSubmitBy() throws Exception {
        assertEquals(newsSubmitBy, news.getPenulis());
    }

    @Test
    public void setNewsTitle() throws Exception {
        news.setTitle("a");
        assertEquals("a", news.getTitle());
    }

    @Test
    public void setNewsContent() throws  Exception {
        news.setDescription("a");
        assertEquals("a", news.getDescription());
    }

    @Test
    public void setNewsDate() throws Exception {
        news.setTanggal("a");
        assertEquals("a", news.getTanggal());
    }

    @Test
    public void setNewsSubmitBy() throws Exception {
        news.setPenulis("a");
        assertEquals("a", news.getPenulis());
    }

    @Test
    public void setBookmarked() throws Exception {
        news.setBookmarked(true);
        assertEquals(true, news.isBookmarked());
    }

    @Test
    public void setId() throws Exception {
        news.setId(1);
        assertEquals(1, news.getId());
    }
}
