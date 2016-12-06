package com.doronenko.test1_1;
import org.junit.Assert;
import org.junit.Test;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Class {@link com.doronenko.test1_1.MessagesTest}
 *
 * @author Alexey Doronenko
 * @version 1.0
 * @since 11/30/2016.
 */

public class MessagesTest {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("message/messages");

    public MessagesTest() {
    }

    /**
     * Test enum TimeRanges values presents in resources
     */
    @Test
    public void testResourceProperties(){
        Enumeration<String> messagesKeys;

        for (TimeRanges tr : TimeRanges.values()) {
            boolean exist = false;
            messagesKeys = resourceBundle.getKeys();
            String key;
            while (messagesKeys.hasMoreElements()) {
                key = messagesKeys.nextElement();
                if (key.equals(tr.getName())) {
                    exist = true;
                    break;
                }
            }
            assertEquals("No message found for " + tr.getName(), true, exist);
        }
    }
    
    @Test
    public void getMessageMorningRU(){
        resourceBundle = ResourceBundle.getBundle("message/messages", Locale.forLanguageTag("RU"));
        assertEquals("Доброе утро, мир!", resourceBundle.getString("morning"));
    }

    @Test
    public void getMessageDayRU(){
        resourceBundle = ResourceBundle.getBundle("message/messages", Locale.forLanguageTag("RU"));
        assertEquals("Добрый день, мир!", resourceBundle.getString("day"));
    }

    @Test
    public void getMessageEveningRU(){
        resourceBundle = ResourceBundle.getBundle("message/messages", Locale.forLanguageTag("RU"));
        assertThat("Добрый вечер, мир!", equalTo(resourceBundle.getString("evening")));
    }

    @Test
    public void getMessageNightRU(){
        resourceBundle = ResourceBundle.getBundle("message/messages", Locale.forLanguageTag("RU"));
        assertThat("Доброй ночи, мир!", equalTo(resourceBundle.getString("night")));
    }

    @Test
    public void getMessageMorningEN(){
        resourceBundle = ResourceBundle.getBundle("message/messages", Locale.US);
        assertThat("Good morning, World!", equalTo(resourceBundle.getString("morning")));
    }

    @Test
    public void getMessageDayEN(){
        resourceBundle = ResourceBundle.getBundle("message/messages", Locale.US);
        assertThat("Good day, World!", equalTo(resourceBundle.getString("day")));
    }
    @Test
    public void getMessageEveningEN(){
        resourceBundle = ResourceBundle.getBundle("message/messages", Locale.US);
        assertThat("Good evening, World!", equalTo(resourceBundle.getString("evening")));
    }

    @Test
    public void getMessageNightEN(){
        resourceBundle = ResourceBundle.getBundle("message/messages", Locale.US);
        assertThat("Good night, World!", equalTo(resourceBundle.getString("night")));
    }

}
