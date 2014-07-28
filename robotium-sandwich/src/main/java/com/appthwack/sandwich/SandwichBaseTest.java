package com.appthwack.sandwich;


import android.app.Activity;
import android.app.Instrumentation;
import android.preference.PreferenceManager;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

// TODO: Auto-generated Javadoc

/**
 * The Class SandwichBaseTest.
 *
 * @param <T> the generic type
 */
public class SandwichBaseTest<T extends Activity> extends ActivityInstrumentationTestCase2<T> {

    /**
     * Instantiates a new sandwich base test.
     *
     * @param activityClass the activity class
     */
    public SandwichBaseTest(Class<T> activityClass) {
        super(activityClass);
    }

    /* (non-Javadoc)
     * @see android.test.ActivityInstrumentationTestCase2#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        Instrumentation instrumentation = getInstrumentation();
        PreferenceManager.getDefaultSharedPreferences(instrumentation.getTargetContext()).edit().clear().commit();
        Log.d("sandwich", "setup");
        SoloFactory.createSolo(instrumentation);
        this.getActivity();

    }

    /* (non-Javadoc)
     * @see android.test.ActivityInstrumentationTestCase2#tearDown()
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        SoloFactory.getSolo().finishOpenedActivities();
    }

    /* (non-Javadoc)
     * @see android.test.ActivityInstrumentationTestCase2#runTest()
     */
    @Override
    public void runTest() throws Throwable {
        try {
            super.runTest();
        } catch (Throwable t) {
            String testCaseName = String.format("%s.%s", getClass().getName(), getName());
            SoloFactory.getSolo().takeScreenshot(testCaseName);
            Log.w("Boom! Screenshot!", String.format("Captured screenshot for failed test: %s", testCaseName));
            throw t;
        }
    }

}
