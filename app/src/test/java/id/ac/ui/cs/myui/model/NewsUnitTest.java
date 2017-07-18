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
        assertEquals(newsTitle, news.getNewsTitle());
    }

    @Test
    public void getNewsContent() throws Exception {
        assertEquals(newsContent, news.getNewsContent());
    }

    @Test
    public void getNewsDate() throws Exception {
        assertEquals(newsDate, news.getNewsDate());
    }

    @Test
    public void getNewsDateEdited() throws Exception {
        assertEquals(newsDateEdited, news.getNewsDateEdited());
    }

    @Test
    public void getNewsSubmitBy() throws Exception {
        assertEquals(newsSubmitBy, news.getNewsSubmitBy());
    }

    @Test
    public void getNewsEditedBy() throws Exception {
        assertEquals(newsEditedBy, news.getNewsEditedBy());
    }

    @Test
    public void setNewsTitle() throws Exception {
        news.setNewsTitle("a");
        assertEquals("a", news.getNewsTitle());
    }

    @Test
    public void setNewsContent() throws  Exception {
        news.setNewsContent("a");
        assertEquals("a", news.getNewsContent());
    }

    @Test
    public void setNewsDate() throws Exception {
        news.setNewsDate("a");
        assertEquals("a", news.getNewsDate());
    }

    @Test
    public void setNewsDateEdited() throws Exception {
        news.setNewsDateEdited("a");
        assertEquals("a", news.getNewsDateEdited());
    }

    @Test
    public void setNewsSubmitBy() throws Exception {
        news.setNewsSubmitBy("a");
        assertEquals("a", news.getNewsSubmitBy());
    }

    @Test
    public void setNewsEditedBy() throws Exception {
        news.setNewsEditedBy("a");
        assertEquals("a", news.getNewsEditedBy());
    }

    @Test
    public void setBookmarked() throws Exception {
        news.setBookmarked(true);
        assertEquals(true, news.isBookmarked());
    }

    @Test
    public void setId() throws Exception {
        news.setId("a");
        assertEquals("a", news.getId());
    }
}
