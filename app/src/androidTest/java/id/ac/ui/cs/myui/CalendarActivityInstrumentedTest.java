package id.ac.ui.cs.myui;

/**
 * Created by sarah.yarismal on 19/07/17.
 */

import android.app.Fragment;
import android.content.Context;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import id.ac.ui.cs.myui.activity.CalendarActivity;
import id.ac.ui.cs.myui.activity.HomeActivity;
import id.ac.ui.cs.myui.activity.LoginActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressKey;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by DELL on 7/13/2017.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class CalendarActivityInstrumentedTest {

    private String mTextViewExpected;
    private String mTextViewExpected2;

    @Rule
    public ActivityTestRule<CalendarActivity> mActivityRule = new ActivityTestRule(CalendarActivity.class);

    @Before
    public void initValidString() {
        // Specify a valid string.
        mTextViewExpected = "Kalender Akademik";
        mTextViewExpected2 = "Detail Kegiatan";
    }

    @Test
    public void labelUsername_inLoginActivity() {
        // Type text and then press the button.
        onView(withId(R.id.title_kalender_akademik)).check(matches(withText(mTextViewExpected)));
        onView(withId(R.id.list_tanggal)).perform(click());
        onView(withId(R.id.detailKegiatan)).check(matches(withText(mTextViewExpected2)));
    }

}

