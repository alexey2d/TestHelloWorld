package com.doronenko.test1_1;

/**
* Class {@link com.doronenko.test1_1.TimeRanges}
*
* @author Alexey Doronenko
* @version 1.0
* @since 11/29/2016.
*/
public enum TimeRanges {
    MORNING("morning", "06:00:00", "09:00:00"),
    DAY("day", "09:00:00", "19:00:00"),
    EVENING("evening", "19:00:00", "23:00:00"),
    NIGHT("night", "23:00:00", "06:00:00");

    private String name;
    private String startTime;
    private String endTime;


    TimeRanges(String name, String startTime, String endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }
}
