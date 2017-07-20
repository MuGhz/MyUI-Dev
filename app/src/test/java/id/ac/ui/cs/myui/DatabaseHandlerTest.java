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

    DatabaseHelper db;

    @Before
    public void setUp(){
        db = new DatabaseHelper(RuntimeEnvironment.application);

    }

    @After
    public void tearDown(){
        db.close();
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
        db.insertMenu(lci);
        assertNotNull(db.getAllParentMenu());
        List<CalendarItem> dariDatabase = db.getAllParentMenu();
        assertEquals("test1",dariDatabase.get(0).getNamaKegiatan());
        assertEquals("test2",dariDatabase.get(1).getNamaKegiatan());
        assertEquals("test3",dariDatabase.get(2).getNamaKegiatan());

    }
}
