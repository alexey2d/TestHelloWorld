package com.doronenko.test1_1;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* Class {@link com.doronenko.test1_1.Notificator}
*
* @author Alexey Doronenko
* @version 1.0
* @since 11/29/2016.
**/

public class Notificator {
    private static final Logger log = Logger.getLogger(Notificator.class);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private Date time;

    /**
     * Sets time variable for Notificator class from parameter
     * @param timeString
     * @throws ParseException
     */
    public Notificator(String timeString) throws ParseException {
        log.trace("Enter into Notificator(String timeString)");
        setTime(timeString);
        log.trace("Exit from Notificator(String timeString)");
    }

    /**
     * Sets time variable for Notificator class. Gets current time
     * @throws ParseException
     */
    public Notificator() throws ParseException {
        log.trace("Enter into public Notificator()");
        Date now = new Date();
        log.trace("public Notificator() with param: " + dateFormat.format(now));
        setTime(dateFormat.format(now));
        log.trace("Exit from public Notificator()");
    }

    /**
     * Sets time variable for Notificator class
     * @param timeString
     * @throws ParseException
     */
    public void setTime(String timeString) throws ParseException {
        log.trace("Enter into public void setTime(String timeString) with timeString: " + timeString);
        this.time = dateFormat.parse(timeString);
        log.trace("Exit from public void setTime(String timeString)");
    }

    //    по параметру
    // не присваивается значение внутренней переменной
    /**
     * Gets part of a day by time
     * @param timeString
     * @return String
     * @throws ParseException
     */
    public String notificate(String timeString) throws ParseException {
        log.trace("Enter into public String notificate(String timeString) with timeString: " + timeString);
        Date time;
        time = dateFormat.parse(timeString);

        Date intervalStart;
        Date intervalFinish;

        log.trace("Enter into for (TimeRanges tr : com.doronenko.test1_1.TimeRanges.values())");
        for (TimeRanges tr : TimeRanges.values()) {
            intervalStart = dateFormat.parse(tr.getStartTime());
            intervalFinish = dateFormat.parse(tr.getEndTime());

            if(
                    (intervalStart.before(intervalFinish) && time.after(intervalStart) && time.before(intervalFinish))
                        || /** под интервал, где происходит переход через 00:00:00 отдельное условие **/
                    (intervalStart.after(intervalFinish) && (time.after(intervalStart) || time.before(intervalFinish))) // ночь
               ) {
                log.debug("TimeRange found: " + tr.getName());
                log.trace("Exit from for (TimeRanges tr : com.doronenko.test1_1.TimeRanges.values())");
                return tr.getName();
            }
        }

        log.warn("Exit from public String notificate(String timeString) with null result");
        return null;
    }

//    возвратить значение внутренней переменной
    /**
     * Gets part of a day by time from inner variable "time"
     * @return String
     * @throws ParseException
     */
    public String notificate() throws ParseException {
        log.trace("Enter into public String notificate(). Using saved time: " + dateFormat.format(time));
        String message = notificate(dateFormat.format(time));
        log.trace("Exit from  public String notificate()");
        return message;
    }
}
