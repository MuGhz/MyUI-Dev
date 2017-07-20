package id.ac.ui.cs.myui;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import id.ac.ui.cs.myui.activity.BookmarkNewsActivity;
import id.ac.ui.cs.myui.activity.LoginActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by agni.wira on 18/07/17.
 */

public class BookmarkInstrumentedTest {
    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule(BookmarkNewsActivity.class);

    // Test listview bookmark is exist
    @Test
    public void listviewBookmarkIsExist() {
        onView(withId(R.id.list_bookmark)).check(matches(isDisplayed()));
    }
}
