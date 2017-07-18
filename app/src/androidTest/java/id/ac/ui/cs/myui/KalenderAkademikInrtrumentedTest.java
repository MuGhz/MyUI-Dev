package id.ac.ui.cs.myui;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import id.ac.ui.cs.myui.activity.CalendarActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Ivan on 7/18/17.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class KalenderAkademikInrtrumentedTest {
    private String titleKalenderAkademik;

    @Rule
    public ActivityTestRule<CalendarActivity> mActivityRule = new ActivityTestRule(CalendarActivity.class);

    @Before
    public void initValidString() {
        titleKalenderAkademik = "Kalender Akademik";
    }


    @Test
    public void hasKalenderAkademikElement() {
        onView(withId(R.id.title_kalender_akademik)).check(matches(isDisplayed()));
        onView(withId(R.id.list_tanggal)).check(matches(isDisplayed()));
        onView(withId(R.id.calendarItem_desc)).check(matches(isDisplayed()));
        onView(withId(R.id.calendarItem_label)).check(matches(isDisplayed()));
    }

    @Test
    public void titleKalenderAkademikTest() {
        onView(withId(R.id.title_kalender_akademik)).check(matches(withText(titleKalenderAkademik)));
    }

    @Test
    public void onClickCalendarItem() {
        onView(withId(R.id.list_tanggal)).perform(click());
        // declared what activity should be moved in
    }
}
