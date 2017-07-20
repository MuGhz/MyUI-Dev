package id.ac.ui.cs.myui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import id.ac.ui.cs.myui.activity.LoginActivity;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;
import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;

/**
 * Created by idiotme on 7/18/2017.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginInstrumentedTest {
    private Intent intent;
    private SharedPreferences sharedPref;
    //dummy username for local testing purpose
    private String testUsername = "programmer";


    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(LoginActivity.class);

    //Instantiation
    @Before
    public void setUp() {
        intent = new Intent();
        Context context = getInstrumentation().getTargetContext();
        sharedPref = getDefaultSharedPreferences(context);
    }

    //Case when there's saved session
    @Test
    public void testSavedSession() {
        // Set SharedPreferences data
        SharedPreferences.Editor e = sharedPref.edit();
        e.putString("username","programmer");
        e.apply();

        // Launch activity
        mActivityRule.launchActivity(intent);

        assertThat(sharedPref.getString("username", ""), is(testUsername));
    }

    //Case when there's no saved session
    @Test
    public void testNoSession() {
        // Empty SharedPreferences data
        SharedPreferences.Editor e = sharedPref.edit();
        e.clear();
        e.apply();

        // Launch activity
        mActivityRule.launchActivity(intent);

        assertThat(sharedPref.getString("username", ""), isEmptyOrNullString());
    }

}
