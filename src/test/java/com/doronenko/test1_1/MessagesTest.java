package com.doronenko.test1_1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import static junit.framework.TestCase.assertEquals;

/**
 * Class {@link com.doronenko.test1_1.MessagesTest}
 *
 * @author Alexey Doronenko
 * @version 1.0
 * @since 12/06/2016.
 */

public class MessagesTest {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("message/messages");

    public MessagesTest() {
    }

    /**
     * Test enum TimeRanges values presents in resources
     */
    @Test
    public void testResourceProperties() {
        for (TimeRanges tr : TimeRanges.values()) {
            assertEquals("No message found for " + tr.name().toLowerCase(),
                    true, resourceBundle.containsKey(tr.name().toLowerCase()));
        }
    }

    /**
     * Test enum TimeRanges values presents in resources
     */
    @Test
    public void testResourcePropertiesEN() {
        resourceBundle = ResourceBundle.getBundle("message/messages", Locale.US);

        for (TimeRanges tr : TimeRanges.values()) {
            assertEquals("No message found for " + tr.name().toLowerCase() + " in english resource",
                    true, resourceBundle.containsKey(tr.name().toLowerCase()));
        }
    }

    /**
     * Test enum TimeRanges values presents in resources
     */
    @Test
    public void testResourcePropertiesRU() {
        resourceBundle = ResourceBundle.getBundle("message/messages", Locale.forLanguageTag("RU"));

        Enumeration<String> messagesKeys;

        for (TimeRanges tr : TimeRanges.values()) {
            assertEquals("No message found for " + tr.name().toLowerCase() + " in russian resource",
                    true, resourceBundle.containsKey(tr.name().toLowerCase()));
        }
    }

}
