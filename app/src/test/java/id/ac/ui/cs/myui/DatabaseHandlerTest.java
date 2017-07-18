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

        news1.setNewsTitle("test1");
        news2.setNewsTitle("test2");
        news3.setNewsTitle("test3");

        news1.setBookmarked(true);
        news2.setBookmarked(true);

        db.addNews(news1);
        db.addNews(news2);
        db.addNews(news3);

        List<News> listBookmark = db.getAllBookmarkedNews();
        //Log.i("list1", listBookmark.get(0).toString());
        //Log.i("list2", listBookmark.get(2).toString());
        assertEquals(listBookmark.size(), 2);
        assertEquals(listBookmark.get(0).getNewsTitle().equals("test1"), true);
        assertEquals(listBookmark.get(1).getNewsTitle().equals("test2"), true);

    }

    @Test
    public void updateBookmarkTest(){
        News news1 = new News();
        News news2 = new News();
        News news3 = new News();

        news1.setNewsTitle("test1");
        news2.setNewsTitle("test2");
        news3.setNewsTitle("test3");

        news1.setBookmarked(true);
        news2.setBookmarked(true);
        news3.setBookmarked(true);

        db.addNews(news1);
        db.addNews(news2);
        db.addNews(news3);

        List<News> listBookmark = db.getAllBookmarkedNews();

        assertEquals(3, listBookmark.size());

        db.updateBookmark(listBookmark.get(1));
        listBookmark = db.getAllBookmarkedNews();

        assertEquals(2,listBookmark.size());

    }
}
