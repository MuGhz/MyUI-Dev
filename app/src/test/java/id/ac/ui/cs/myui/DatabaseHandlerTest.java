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

import java.util.ArrayList;
import java.util.List;
import id.ac.ui.cs.myui.helper.DatabaseHelper;
import id.ac.ui.cs.myui.model.CalendarItem;
import id.ac.ui.cs.myui.database.DatabaseHandler;
import id.ac.ui.cs.myui.model.News;

import static android.os.Build.VERSION_CODES.LOLLIPOP;
import static java.security.AccessController.getContext;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by muhammad.ghozi41 on 18/07/17.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class DatabaseHandlerTest {

    DatabaseHelper dbhelper;
    DatabaseHandler dbhandler;

    @Before
    public void setUp() {
        dbhelper = new DatabaseHelper(RuntimeEnvironment.application);
        dbhandler = new DatabaseHandler(RuntimeEnvironment.application);
    }

    @After
    public void tearDown(){
        dbhelper.close();
        dbhandler.close();
    }

    @Test
    public void calenderTest(){
        CalendarItem ci1 = new CalendarItem(1,"","",1,"","test1");
        CalendarItem ci2 = new CalendarItem(2,"","",2,"","test2");
        CalendarItem ci3 = new CalendarItem(3,"","",3,"","test3");

        List<CalendarItem> lci= new ArrayList<CalendarItem>();
        lci.add(ci1);
        lci.add(ci2);
        lci.add(ci3);
        dbhelper.insertMenu(lci);
        assertNotNull(dbhelper.getAllParentMenu());
        List<CalendarItem> dariDatabase = dbhelper.getAllParentMenu();
        assertEquals("test1",dariDatabase.get(0).getNamaKegiatan());
        assertEquals("test2",dariDatabase.get(1).getNamaKegiatan());
        assertEquals("test3",dariDatabase.get(2).getNamaKegiatan());

    }
    
    public void bookmarkTest(){
        News news1 = new News();
        News news2 = new News();
        News news3 = new News();

        news1.setTitle("test1");
        news2.setTitle("test2");
        news3.setTitle("test3");

        dbhandler.addBookmark(news1);
        dbhandler.addBookmark(news2);
        dbhandler.addBookmark(news3);

        //Test in model: is bookmarked should be true
        assertEquals(news1.isBookmarked(), true);
        assertEquals(news2.isBookmarked(), true);
        assertEquals(news3.isBookmarked(), true);

        //Test in database: bookmarked row should be true
        List<News> listBookmark = dbhandler.getAllBookmarkedNews();

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

        dbhandler.addBookmark(news1);
        dbhandler.addBookmark(news2);
        dbhandler.addBookmark(news3);

        dbhandler.deleteBookmark(news1);

        //Test in model: is bookmarked should be true, except news1
        assertEquals(news1.isBookmarked(), false);
        assertEquals(news2.isBookmarked(), true);
        assertEquals(news3.isBookmarked(), true);

        //Test in database: bookmarked row should be true
        List<News> listBookmark = dbhandler.getAllBookmarkedNews();

        assertEquals(listBookmark.size(), 2);
        assertEquals(listBookmark.get(0).getTitle().equals("test2"), true);
        assertEquals(listBookmark.get(1).getTitle().equals("test3"), true);
//
    }
}
