package com.doronenko.test1_1;

import org.apache.log4j.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* Class {@link Notifier}
*
* @author Alexey Doronenko
* @version 1.0
* @since 11/29/2016.
**/

public class Notifier {
    private static final Logger log = Logger.getLogger(Notifier.class);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private Date time;

    /**
     * Sets time variable for Notifier class from parameter
     * @param timeString
     * @throws ParseException
     */
    public Notifier(String timeString) throws ParseException {
        log.trace("Enter into Notifier(String timeString)");
        setTime(timeString);
        log.trace("Exit from Notifier(String timeString)");
    }

    /**
     * Sets time variable for Notifier class. Gets current time
     * @throws ParseException
     */
    public Notifier() throws ParseException {
        log.trace("Enter into public Notifier()");
        Date now = new Date();
        log.trace("public Notifier() with param: " + dateFormat.format(now));
        setTime(dateFormat.format(now));
        log.trace("Exit from public Notifier()");
    }

    /**
     * Sets time variable for Notifier class
     * @param timeString
     * @throws ParseException
     */
    public void setTime(String timeString) throws ParseException {
        log.trace("Enter into public void setTime(String timeString) with timeString: " + timeString);
        this.time = dateFormat.parse(timeString);
        log.trace("Exit from public void setTime(String timeString)");
    }

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

        Date intervalStart;
        Date intervalFinish;

        log.trace("Enter into for (TimeRanges tr : TimeRanges.values())");
        for (TimeRanges tr : TimeRanges.values()) {
            intervalStart = dateFormat.parse(tr.getStartTime());
            intervalFinish = dateFormat.parse(tr.getEndTime());

            if(
                    (intervalStart.before(intervalFinish) &&
                            (time.compareTo(intervalStart) > 0) && (time.compareTo(intervalFinish) <= 0))
                        || /** if timeRange pass 0:00 am another condition **/
                    (intervalStart.after(intervalFinish) &&
                            ((time.compareTo(intervalStart) > 0) || time.compareTo(intervalFinish) <= 0))
               ) {
                log.debug("TimeRange found: " + tr.getName() + " for " + timeString);
                log.trace("Exit from for (TimeRanges tr : TimeRanges.values())");
                return tr.getName();
            }
        }

        log.warn("Exit from public String inform(String timeString) with null result");
        return null;
    }

    /**
     * Gets part of a day by time from inner variable "time"
     * @return String
     * @throws ParseException
     */
    public String inform() throws ParseException {
        log.trace("Enter into public String inform(). Using saved time: " + dateFormat.format(time));
        String message = inform(dateFormat.format(time));
        log.trace("Exit from  public String inform()");
        return message;
    }
}
