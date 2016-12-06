package com.doronenko.test1_1;

import org.apache.log4j.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* Class {@link com.doronenko.test1_1.Notifier}
*
* @author Alexey Doronenko
* @version 1.1
* @since 12/06/2016.
**/

public class Notifier {
    private static final Logger log = Logger.getLogger(Notifier.class);
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * Gets part of a day by time.
     * Don't set class variable time.
     * @param timeString
     * @return String
     * @throws ParseException
     */
    public String inform(String timeString) throws ParseException {
        log.trace("Enter into public String inform(String timeString) with timeString: " + timeString);
        Date time;
        time = dateFormat.parse(timeString);

        String message;

        if (time.compareTo(TimeRanges.MORNING.getTime()) > 0 && time.compareTo(TimeRanges.DAY.getTime()) <= 0) {
            message = "morning";
        } else if (time.compareTo(TimeRanges.DAY.getTime()) > 0 && time.compareTo(TimeRanges.EVENING.getTime()) <= 0) {
                message = "day";
            } else if (time.compareTo(TimeRanges.EVENING.getTime()) > 0 && time.compareTo(TimeRanges.NIGHT.getTime()) <= 0) {
                    message = "evening";
                } else {
                        message = "night";
        }

        log.debug("TimeRange found: " + message + " for " + timeString);
        return message;
    }

}
