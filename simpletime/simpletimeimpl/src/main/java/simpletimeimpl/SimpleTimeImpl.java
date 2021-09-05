package simpletimeimpl;

import simpletimeapi.Duration;
import simpletimeapi.Time;

import java.time.LocalTime;
import java.util.Objects;

public class SimpleTimeImpl implements Time {
    final private int totalTimeInMins;

    public SimpleTimeImpl(int hours, int minutes) {
        if (hours > 23) {
            throw new IllegalArgumentException("Hours can NOT be > 23");
        }

     /*   if (minutes > 59) {
            throw new IllegalArgumentException("Minutes can NOT be > 59");
        }*/
        //
        int tempTotalMins = (hours * 60) + minutes;
        if (tempTotalMins < 0) {
            throw new IllegalArgumentException("Total minutes can NOT be lower than 0");
        }
        if (tempTotalMins >= (24 * 60)) {
            throw new IllegalArgumentException("Total minutes can NOT be bigger than 24 * 60");
        }

        this.totalTimeInMins = tempTotalMins;

    }

    @Override
    public Time addTime(Time t) {
        int hours = getHours() + t.getHours();
        int minutes = getMinutes() + t.getMinutes();

        return new SimpleTimeImpl(hours, minutes);
    }

    @Override
    public Time addTime(int minutes) {
        int totalMinutes = this.totalTimeInMins + minutes;
        var hrsConverted = totalMinutes / 60;
        var minsConverted = totalMinutes % 60;

        return new SimpleTimeImpl(hrsConverted, minsConverted);
    }

    @Override
    public int getHours() {
        return this.totalTimeInMins / 60;

    }

    @Override
    public int getMinutes() {
        return this.totalTimeInMins % 60;
    }


    @Override
    public int compareTo(Time o) {
        int otherTotalMins = o.getHours() * 60 + o.getMinutes();

        if (this.totalTimeInMins > otherTotalMins) {
            return 1;
        } else if (this.totalTimeInMins < otherTotalMins) {
            return -1;
        }
        return 0;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleTimeImpl that = (SimpleTimeImpl) o;
        return totalTimeInMins == that.totalTimeInMins;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalTimeInMins);
    }

    @Override
    public String toString() {
        return LocalTime.MIN.plus(
                java.time.Duration.ofMinutes(totalTimeInMins)
        ).toString();
    }

    @Override
    public boolean isBefore(Time other) {
        return Time.super.isBefore(other);
    }

    @Override
    public boolean isBeforeOrEqual(Time other) {
        return Time.super.isBeforeOrEqual(other);
    }

    @Override
    public Duration until(Time until) {

        //1. make both to mins, substract smaller from bigger, make to hrs and mins again
        int firstTotalMins = this.asMinutes();
        int lastTotalMins = until.asMinutes();
        // check which is bigger time in minutes
        int bigger = 0;
        int smaller = 0;
        if (firstTotalMins > lastTotalMins) {
            bigger = firstTotalMins;
            smaller = lastTotalMins;
        } else {
            bigger = lastTotalMins;
            smaller = firstTotalMins;
        }

        //calculate hours and mins
        int durationAsMins = bigger - smaller;

        //Check if other time is on the other day, then add 24 * 60 = 1440 - result from operation
        if (until.isBefore(this)) {
            durationAsMins = 1440 - durationAsMins;
        }


        int hour = durationAsMins / 60;
        int mins = durationAsMins % 60;

        return new SimpleDurationImpl(hour, mins);
    }
}
