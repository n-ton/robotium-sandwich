package com.appthwack.sandwich;

import junit.framework.Assert;

// TODO: Auto-generated Javadoc

/**
 * The Class SandwichAssert.
 */
public class SandwichAssert {

    /**
     * Assert not null.
     *
     * @param message the message
     * @param object  the object
     */
    public static void assertNotNull(String message, Object object) {
        if (SandwichSettings.getAutomaticAssertsEnabled())
            Assert.assertNotNull(message, object);
        else if (object == null)
            SandwichLog.w(message);
    }

    /**
     * Assert true.
     *
     * @param message   the message
     * @param condition the condition
     */
//    public static void assertTrue(String message, boolean condition) {
//        if (SandwichSettings.getAutomaticAssertsEnabled())
//            try {
//                Assert.assertTrue(message, condition);
//            } catch (AssertionError e) {
//                SoloFactory.getSolo().takeScreenshot("Error screenshot");
//                throw e;
//            }
//        else if (!condition) {
//            SandwichLog.w(message);
//            SoloFactory.getSolo().takeScreenshot("Error screenshot");
//        }
//    }
    public static void assertTrue(String message, boolean condition) {
        try {
            Assert.assertTrue(message, condition);
        } catch (AssertionError e) {
            SoloFactory.getSolo().takeScreenshot("Error screenshot");
            SandwichLog.w(message);
            throw e;
        }
    }
}
