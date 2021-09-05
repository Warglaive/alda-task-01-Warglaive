/*
 * Copyright (c) 2019 Informatics Fontys FHTenL University of Applied Science Venlo
 */
package simpletime;

import simpletimeapi.AbstractAPFactory;
import simpletimeapi.Duration;
import simpletimeapi.Time;
import simpletimeimpl.SimpleDurationImpl;
import simpletimeimpl.SimpleTimeImpl;
//TODO adapt imports if required


/**
 * Abstract factory to separate student implementations from teachers tests. The
 * instance created by this factory will be black-box tested by the teachers
 * tests.
 * <p>
 * Richard van den Ham {@code r.vandenham@fontys.nl} Pieter van den Hombergh
 * {@code p.vandenhombergh@fontys.nl}
 */
public class APFactory implements AbstractAPFactory {

    /**
     * Required for service loader.
     */
    public APFactory() {
    }

    /**
     * Factory method to create an object of type Time.
     *
     * @param hours   the number of hours
     * @param minutes the number of minutes, might be negative.
     * @return Time object
     */
    @Override
    public Time createTime(int hours, int minutes) {
        if (hours>=24){
            throw new IllegalArgumentException("Hours can NOT be >= 24");
        }
        if (minutes>=60){
            throw new IllegalArgumentException("Minutes can NOT be >= 60");
        }
        //
        //TODO
        int totalTimeInMins = (hours * 60) + minutes;
        if (totalTimeInMins < 0) {
            throw new IllegalArgumentException("Total minutes can NOT be lower than 0");
        }
        if (totalTimeInMins >= (24 * 60)) {
            throw new IllegalArgumentException("Total minutes can NOT be bigger than 24 * 60");
        }
        return new SimpleTimeImpl(hours, minutes);
    }

    /**
     * Factory method to create an object of type Duration. The Duration
     * implementation should have a constructor with two arguments: hours and
     * minutes.
     *
     * @param hours   hours part of the duration.
     * @param minutes minutes part of the duration.
     * @return Duration object.
     */
    @Override
    public Duration createDuration(int hours, int minutes) {
        //TODO
        return new SimpleDurationImpl(hours, minutes);
    }

    /**
     * Factory method to create an object of type Duration.
     *
     * @param lengthInMinutes e.g. 105 minutes
     * @return Duration object.
     */
    @Override
    public Duration createDuration(int lengthInMinutes) {
        //TODO
        int hours = lengthInMinutes / 60;
        int minutes = lengthInMinutes % 60;
        return new SimpleDurationImpl(hours, minutes);
    }

}
