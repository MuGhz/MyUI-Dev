package id.ac.ui.cs.myui;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.rule.ActivityTestRule;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;

import id.ac.ui.cs.myui.activity.BookmarkActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertNotNull;


/**
 * Created by muhammad.ghozi41 on 18/07/17.
 */

public class DrawerNavigationInstrumentedTest {
    @Rule
    public ActivityTestRule<BookmarkActivity> mActivityRule = new ActivityTestRule(BookmarkActivity.class);

    @Test
    public void checkBookmarkMenuOnDrawer(){
        onView(withId(R.id.drawer_layout)).perform(actionOpenDrawer());
        assertNotNull(onView(withId(R.id.bookmark_menu_drawer)));
        onView(withId(R.id.drawer_layout)).perform(actionCloseDrawer());

    }
    public static ViewAction actionOpenDrawer() {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(DrawerLayout.class);
            }

            @Override
            public String getDescription() {
                return "open drawer";
            }

            @Override
            public void perform(UiController uiController, View view) {
                ((DrawerLayout) view).openDrawer(GravityCompat.START);
            }
        };
    }
    private static ViewAction actionCloseDrawer() {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(DrawerLayout.class);
            }

            @Override
            public String getDescription() {
                return "close drawer";
            }

            @Override
            public void perform(UiController uiController, View view) {
                ((DrawerLayout) view).closeDrawer(GravityCompat.START);
            }
        };
    }
}
