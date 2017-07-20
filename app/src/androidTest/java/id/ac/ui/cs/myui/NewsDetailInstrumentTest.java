package id.ac.ui.cs.myui;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import id.ac.ui.cs.myui.activity.LoginActivity;
import id.ac.ui.cs.myui.activity.NewsHomeActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by irma.latifatul on 20/07/17.
 */

public class NewsDetailInstrumentTest {
    @Rule
    public ActivityTestRule<NewsHomeActivity> mActivityRule = new ActivityTestRule(NewsHomeActivity.class);

    @Test
    public void click_news() {
        // Type text and then press the button.
        onView(withId(R.id.list_news)).perform(click());
        onView(withId(R.id.pubdate)).check(matches(isDisplayed()));
        onView(withId(R.id.news_title)).check(matches(isDisplayed()));
        onView(withId(R.id.news_author)).check(matches(isDisplayed()));
        onView(withId(R.id.news_content)).check(matches(isDisplayed()));
    }
}
