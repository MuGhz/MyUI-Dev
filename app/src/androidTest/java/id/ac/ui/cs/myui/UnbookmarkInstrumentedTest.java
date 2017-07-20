package id.ac.ui.cs.myui;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import id.ac.ui.cs.myui.activity.BookmarkNewsActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;


/**
 * Created by ayu.annisa41 on 20/07/17.
 */


public class UnbookmarkInstrumentedTest {

    @Rule
    public ActivityTestRule<BookmarkNewsActivity> mActivityRule2 = new ActivityTestRule(BookmarkNewsActivity.class);

    @Test
    public void unbookmarkNews() {
        onView(withId(R.id.list_bookmark)).perform(click());
        onView(withId(R.id.button_bookmark)).check(matches(isClickable()));
        onView(withId(R.id.button_bookmark)).perform(scrollTo()).perform(click());
        onView(withText(R.string.unbookmarked)).
                inRoot(withDecorView(not(is(mActivityRule2.getActivity().getWindow().getDecorView())))).
                check(matches(isDisplayed()));


    }
}
