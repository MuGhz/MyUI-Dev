package id.ac.ui.cs.myui;

import android.app.Activity;
import android.content.Context;
import android.test.RenamingDelegatingContext;
import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.List;

import id.ac.ui.cs.myui.database.DatabaseHandler;
import id.ac.ui.cs.myui.model.News;

import static android.os.Build.VERSION_CODES.LOLLIPOP;
import static java.security.AccessController.getContext;
import static junit.framework.Assert.assertEquals;

/**
 * Created by muhammad.ghozi41 on 18/07/17.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class DatabaseHandlerTest {

    DatabaseHandler db;

    @Before
    public void setUp(){
        db = new DatabaseHandler(RuntimeEnvironment.application);

    }

    @After
    public void tearDown(){
        db.close();
    }

    @Test
    public void bookmarkTest(){
        News news1 = new News();
        News news2 = new News();
        News news3 = new News();

        news1.setTitle("test1");
        news2.setTitle("test2");
        news3.setTitle("test3");

        db.addBookmark(news1);
        db.addBookmark(news2);
        db.addBookmark(news3);

        //Test in model: is bookmarked should be true
        assertEquals(news1.isBookmarked(), true);
        assertEquals(news2.isBookmarked(), true);
        assertEquals(news3.isBookmarked(), true);

        //Test in database: bookmarked row should be true
        List<News> listBookmark = db.getAllBookmarkedNews();

        assertEquals(listBookmark.size(), 3);
        assertEquals(listBookmark.get(0).getTitle().equals("test1"), true);
        assertEquals(listBookmark.get(1).getTitle().equals("test2"), true);
        assertEquals(listBookmark.get(2).getTitle().equals("test3"), true);

    }

    @Test
    public void unBookmarkTest(){
        News news1 = new News();
        News news2 = new News();
        News news3 = new News();

        news1.setTitle("test1");
        news1.setLink("linkTest1");
        news2.setTitle("test2");
        news2.setLink("linkTest2");
        news3.setTitle("test3");
        news3.setLink("linkTest3");

        db.addBookmark(news1);
        db.addBookmark(news2);
        db.addBookmark(news3);

        db.deleteBookmark(news1);

        //Test in model: is bookmarked should be true, except news1
        assertEquals(news1.isBookmarked(), false);
        assertEquals(news2.isBookmarked(), true);
        assertEquals(news3.isBookmarked(), true);

        //Test in database: bookmarked row should be true
        List<News> listBookmark = db.getAllBookmarkedNews();

        assertEquals(listBookmark.size(), 2);
        assertEquals(listBookmark.get(0).getTitle().equals("test2"), true);
        assertEquals(listBookmark.get(1).getTitle().equals("test3"), true);
//
    }
//
//    public void

}
