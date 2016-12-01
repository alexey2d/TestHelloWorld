package com.doronenko.test1_1;

import org.apache.log4j.Logger;
import java.text.ParseException;
import java.util.Locale;
import java.util.ResourceBundle;



/**
 * Class {@link com.doronenko.test1_1.HelloWorldApp}
 *
 * @author Alexey Doronenko
 * @version 1.0
 * @since 11/29/2016.
 */
public class HelloWorldApp {
    final static Logger log = Logger.getLogger(HelloWorldApp.class);

    public static void main(String[] args) throws ParseException {
        log.debug("HelloWorldApp started.");

        Locale.getDefault();
        log.trace("Getting resources.");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message/messages");

        log.trace("Getting current time range");
        String message = new Notificator().notificate();

        try {
            System.out.println(resourceBundle.getString(message));
        } catch (NullPointerException e) {
            log.error("Null result for time range", e);
            e.printStackTrace();
        }

        log.debug("HelloWorldApp finished.");
    }
}
