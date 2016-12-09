package com.doronenko.test1_1;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;


/**
 * Class {@link com.doronenko.test1_1.HelloWorldApp}
 *
 * @author Alexey Doronenko
 * @version 1.0
 * @since 12/06/2016.
 */
public class HelloWorldApp {
    final static Logger log = Logger.getLogger(HelloWorldApp.class);

    public static void main(String[] args) throws ParseException {
        log.debug("HelloWorldApp started.");
        log.trace("With param: " + args);

        Locale.getDefault();
        log.trace("Getting resources.");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message/messages");

        log.trace("Getting current time range");
        Date time = new Date();
        String message = new Notifier().inform(Notifier.dateFormat.format(time));

        System.out.println(resourceBundle.getString(message));

        log.debug("HelloWorldApp finished.");
    }
}
