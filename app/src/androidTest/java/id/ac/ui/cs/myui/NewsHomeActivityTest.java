package id.ac.ui.cs.myui;

/**
 * Created by agni.wira on 20/07/17.
 */

import android.support.test.rule.ActivityTestRule;
import android.widget.ListView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import id.ac.ui.cs.myui.activity.NewsHomeActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.Visibility.VISIBLE;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


public class NewsHomeActivityTest {

    ListView listView;

    @Rule
    public ActivityTestRule<NewsHomeActivity> mActivityRule = new ActivityTestRule(NewsHomeActivity.class);

    @Before
    public void setUp(){
        NewsHomeActivity act = mActivityRule.getActivity();
        listView = (ListView) act.findViewById(R.id.list_news);


    }

    // Test listview news is exist
    @Test
    public void listviewBookmarkIsExist() {
        onView(withId(R.id.list_news)).check(matches(withEffectiveVisibility(VISIBLE)));

        onView(withId(R.id.list_news)).check(matches(isDisplayed()));

        onView(withId(R.id.list_news)).perform(click()).check(doesNotExist());

    }
}
