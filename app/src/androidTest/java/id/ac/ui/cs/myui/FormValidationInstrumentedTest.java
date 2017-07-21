package id.ac.ui.cs.myui;


import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import id.ac.ui.cs.myui.activity.LoginActivity;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by ekanaradhipa.d on 20/07/17.
 */

public class FormValidationInstrumentedTest {
    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(LoginActivity.class);

    //Case when both username and password empty
    @Test
    public void testUsernamePasswordEmpty() {
        onView(withId(R.id.btnLogin)).perform(click());
        onView(withId(R.id.btnLogin)).check(matches(isDisplayed()));
    }

    //Case when username empty
    @Test
    public void testUsernameEmpty() {
        onView(withId(R.id.etPassword)).perform(typeText("programmer")).perform(closeSoftKeyboard());
        onView(withId(R.id.btnLogin)).perform(click());
        onView(withId(R.id.btnLogin)).check(matches(isDisplayed()));

    }
    //Case when password empty
    @Test
    public void testPasswordEmpty() {
        onView(withId(R.id.etUsername)).perform(typeText("programmer")).perform(closeSoftKeyboard());
        onView(withId(R.id.btnLogin)).perform(click());
        onView(withId(R.id.btnLogin)).check(matches(isDisplayed()));

    }
    //Case when both username and password filled
    @Test
    public void testFilled() {
        onView(withId(R.id.etUsername)).perform(typeText("programmer")).perform(closeSoftKeyboard());
        onView(withId(R.id.etPassword)).perform(typeText("programmer")).perform(closeSoftKeyboard());
        onView(withId(R.id.btnLogin)).perform(click());
        onView(withId(R.id.bottomBar)).check(matches(isDisplayed()));
    }
}
