package id.ac.ui.cs.myui;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import id.ac.ui.cs.myui.activity.LoginActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by DELL on 7/13/2017.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginInstrumentedTest {

    private String mButtonTextExpected;

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule(LoginActivity.class);

    @Before
    public void initValidString() {
        // Specify a valid string.
        mButtonTextExpected = "Login QR";
    }

    @Test
    public void labelUsername_inLoginActivity() {
        // Type text and then press the button.
        onView(withId(R.id.login)).check(matches(withText(mButtonTextExpected)));
    }

    @Test
    public void clickLogin_showHomeActivity(){
        onView(withId(R.id.login)).perform(click());
        onView(withId(R.id.bottomBar)).check(matches(isDisplayed()));
    }
}
