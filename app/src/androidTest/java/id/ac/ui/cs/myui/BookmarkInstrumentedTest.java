package id.ac.ui.cs.myui;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.ListView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import id.ac.ui.cs.myui.activity.BookmarkNewsActivity;
import id.ac.ui.cs.myui.activity.LoginActivity;
import id.ac.ui.cs.myui.activity.NewsHomeActivity;
import id.ac.ui.cs.myui.adapter.NewsAdapter;
import id.ac.ui.cs.myui.model.News;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.Visibility.VISIBLE;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by agni.wira on 18/07/17.
 */

public class BookmarkInstrumentedTest {

    ListView listView;
    @Rule
    public ActivityTestRule<BookmarkNewsActivity> mActivityRule = new ActivityTestRule(BookmarkNewsActivity.class);

    @Before
    public void setUp(){
        BookmarkNewsActivity act = mActivityRule.getActivity();
        listView = (ListView) act.findViewById(R.id.list_bookmark);
    }

    // Test listview bookmark is exist
    @Test
    public void listviewBookmarkIsExist() {
        onView(withId(R.id.list_bookmark)).check(matches(withEffectiveVisibility(VISIBLE)));

    }


}
