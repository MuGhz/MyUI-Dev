package id.ac.ui.cs.myui;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import id.ac.ui.cs.myui.activity.NewsDetailActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withResourceName;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
/**
 * Created by Ivan on 7/19/17.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class NewsDetailInstrumentedTest {
    
    @Before
    public void initValidString() {
        // Specify a valid string.

    }

    @Rule
    public ActivityTestRule<NewsDetailActivity> mActivityRule = new ActivityTestRule(NewsDetailActivity.class);

    @Test
    public void testNewsDetailActivity() {
        onView(withId(R.id.pubdate)).check(matches(isDisplayed()));
        onView(withId(R.id.button_wa)).check(matches(isDisplayed()));
        onView(withId(R.id.button_line)).check(matches(isDisplayed()));
        onView(withId(R.id.news_author)).check(matches(isDisplayed()));
        onView(withId(R.id.news_content)).check(matches(isDisplayed()));
        onView(withId(R.id.news_title)).check(matches(isDisplayed()));
    }

    @Test
    public void testShareButtonLine() {
        onView(withId(R.id.button_line)).perform(click());
        //insert test here
    }

    @Test
    public void testShareButtonWA() {
        onView(withId(R.id.button_wa)).perform(click());
        //insert test here
    }
}
