package com.doronenko.test1_1;

import com.doronenko.test1_1.Notifier;

import java.text.ParseException;
import java.util.Date;

/**
 * Class {@link com.doronenko.test1_1.TimeRanges}
 *
 * @author Alexey Doronenko
 * @version 1.0
 * @since 12/06/2016.
 */
public enum TimeRanges {
    MORNING("06:00:00"),
    DAY("09:00:00"),
    EVENING("19:00:00"),
    NIGHT("23:00:00");

    private String startTime;

    TimeRanges(String startTime) {

        this.startTime = startTime;
    }

    public Date getTime() throws ParseException {
        return Notifier.dateFormat.parse(startTime);
    }

}
