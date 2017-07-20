package id.ac.ui.cs.myui;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.ListView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import id.ac.ui.cs.myui.activity.NewsHomeActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by rifkiadrn on 7/20/2017.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class WebServiceInstrumentedTest {
    private ListView listView;

    @Rule
    public ActivityTestRule<NewsHomeActivity> mActivityRule = new ActivityTestRule(NewsHomeActivity.class);

    @Before
    public void initValidActivity() {
        // Specify a valid string.
        NewsHomeActivity nha = mActivityRule.getActivity();
        listView = (ListView) nha.findViewById(R.id.list_news);

    }

    @Test
    public void labelUsername_inLoginActivity() {
        // Type text and then press the button.
        onView(withId(R.id.list_news)).check(matches((isDisplayed())));
    }
}

