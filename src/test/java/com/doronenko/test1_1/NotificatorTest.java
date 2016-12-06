package com.doronenko.test1_1;

import org.junit.Test;
import java.text.ParseException;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
* Class {@link com.doronenko.test1_1.NotificatorTest}
*
* @author Alexey Doronenko
* @version 1.0
* @since 11/29/2016.
*/
public class NotificatorTest {
    Notificator notificator = new Notificator();

    public NotificatorTest() throws ParseException {
    }

    @Test
    public void testMorningEvent7am0000() throws Exception {
        assertThat(notificator.notificate("07:00:00"), is("morning"));
    }

    @Test
    public void testMorningEvent8am5959() throws Exception {
        assertThat(notificator.notificate("08:59:59"), is("morning"));
    }

    @Test
    public void testDayEvent9am5959() throws Exception {
        assertThat(notificator.notificate("09:59:59"), is("day"));
    }

    @Test
    public void testDayEvent6pm5900() throws Exception {
        assertThat(notificator.notificate("18:59:00"), is("day"));
}

    @Test
    public void testEveningEvent7pm0159() throws Exception {
        assertThat(notificator.notificate("19:01:59"), is("evening"));
    }

    @Test
    public void testEveningEvent10pm5959() throws Exception {
        assertThat(notificator.notificate("22:59:59"), is("evening"));
    }

    @Test
    public void testNightEvent11pn0100() throws Exception {
        assertThat(notificator.notificate("23:01:00"), is("night"));
    }

    @Test
    public void testNightEvent5am5500() throws Exception {
        assertThat(notificator.notificate("05:55:00"), is("night"));
    }

    @Test
    public void testNotificatorSetter() throws Exception {
        notificator.setTime("13:00:00");
        assertThat(notificator.notificate(), is("day"));
    }
}
