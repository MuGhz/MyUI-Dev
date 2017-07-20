package id.ac.ui.cs.myui;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.ListView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import id.ac.ui.cs.myui.activity.NewsHomeActivity;

import java.util.ArrayList;

import id.ac.ui.cs.myui.activity.BookmarkNewsActivity;
import id.ac.ui.cs.myui.activity.LoginActivity;
import id.ac.ui.cs.myui.activity.NewsHomeActivity;
import id.ac.ui.cs.myui.adapter.NewsAdapter;
import id.ac.ui.cs.myui.model.News;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.Visibility.VISIBLE;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

/**
 * Created by agni.wira on 18/07/17.
 */

public class BookmarkInstrumentedTest {

    ListView listView;
    @Rule
    public ActivityTestRule<NewsHomeActivity> mActivityRule = new ActivityTestRule(NewsHomeActivity.class);

    // Test listview bookmark is exist
    @Test
    public void listviewBookmarkIsExist() {
        onView(withId(R.id.list_news)).check(matches(isDisplayed()));
        //onView(withId(R.id.list_bookmark)).check(matches(withEffectiveVisibility(VISIBLE)));
    }

    @Test
    public void bookmarkNews() {
        onView(withId(R.id.list_news)).perform(click());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.button_bookmark)).check(matches(isClickable()));
        onView(withId(R.id.button_bookmark)).perform(scrollTo()).perform(click());
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        onView(withText(R.string.bookmarking)).
                inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView())))).
                check(matches(isDisplayed()));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.button_bookmark)).perform(scrollTo()).perform(click());
        onView(withText(R.string.bookmarked)).
                inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView())))).
                check(matches(isDisplayed()));


    }
}
