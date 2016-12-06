package com.doronenko.test1_1;
import org.junit.Test;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.is;
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
            assertEquals("In resource file less messages that need.", true, exist);
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
        assertThat(resourceBundle.getString("evening"), is("Добрый вечер, мир!"));
    }

    @Test
    public void getMessageNightRU(){
        resourceBundle = ResourceBundle.getBundle("message/messages", Locale.forLanguageTag("RU"));
        assertThat(resourceBundle.getString("night"), is("Доброй ночи, мир!"));
    }

    @Test
    public void getMessageMorningEN(){
        resourceBundle = ResourceBundle.getBundle("message/messages", Locale.US);
        assertThat(resourceBundle.getString("morning"), is("Good morning, World!"));
    }

    @Test
    public void getMessageDayEN(){
        resourceBundle = ResourceBundle.getBundle("message/messages", Locale.US);
        assertThat(resourceBundle.getString("day"), is("Good day, World!"));
    }
    @Test
    public void getMessageEveningEN(){
        resourceBundle = ResourceBundle.getBundle("message/messages", Locale.US);
        assertThat(resourceBundle.getString("evening"), is("Good evening, World!"));
    }

    @Test
    public void getMessageNightEN(){
        resourceBundle = ResourceBundle.getBundle("message/messages", Locale.US);
        assertThat(resourceBundle.getString("night"), is("Good night, World!"));
    }

}
