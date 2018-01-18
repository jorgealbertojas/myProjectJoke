package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.content.Context;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.util.Pair;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
public class EchoAndroidTest{

    @Test
    public void testVerifyEchoResponse()  {

        EndpointsAsyncTask endpointsAsyncTask = (EndpointsAsyncTask)  new EndpointsAsyncTask().execute(new Pair<Context, String>(null, "Teste"));

        String getReturn = "";

        try {
            getReturn = endpointsAsyncTask.get().toString();

        } catch (InterruptedException e) {e.printStackTrace();

        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        assertTrue(!getReturn.toString().isEmpty());
    }

    @Test
    public void testVerifyLoggingEchoResponse() {
        assertEquals("hello", Echo.echo("hello", true));
    }

    public static Activity getActivity() {
        final Activity[] currentActivity = new Activity[1];
        onView(allOf(withId(android.R.id.content), isDisplayed())).perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(View.class);
            }

            @Override
            public String getDescription() {
                return "getting text from a TextView";
            }

            @Override
            public void perform(UiController uiController, View view) {
                if (view.getContext() instanceof Activity) {
                    Activity activity1 = ((Activity)view.getContext());
                    currentActivity[0] = activity1;
                }
            }
        });
        return currentActivity[0];
    }
}
