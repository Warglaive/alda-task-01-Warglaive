package simpletimeimpl;

import simpletimeapi.Duration;
import simpletimeapi.Time;

public class SimpleTimeImpl implements Time {
    private int minutes;
    private int hours;

    public SimpleTimeImpl(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    @Override
    public Time addTime(Time t) {
        this.hours = getHours() + t.getHours();
        this.minutes = getMinutes() + t.getMinutes();

        return new SimpleTimeImpl(hours, minutes);
    }

    @Override
    public Time addTime(int minutes) {
        int firstTotalMins = this.hours * 60 + this.minutes + minutes;

        var hrsConverted = firstTotalMins / 60;
        var minsConverted = firstTotalMins % 60;


        return new SimpleTimeImpl(hrsConverted, minsConverted);
    }

    @Override
    public int getHours() {
        return this.hours;

    }

    @Override
    public int getMinutes() {
        return this.minutes;
    }


    @Override
    public int compareTo(Time o) {
        int firstTotalMins = this.hours * 60 + this.minutes;
        int otherTotalMins = o.getHours() * 60 + o.getMinutes();

        if (firstTotalMins > otherTotalMins) {
            return -1;
        } else if (firstTotalMins < otherTotalMins) {
            return 1;
        }
        return 0;
    }

    @Override
    public Duration until(Time other) {
        var hoursUntil = this.hours - other.getHours();
        var minutesUntil = this.minutes - other.getMinutes();

        return new SimpleDurationImpl(hoursUntil, minutesUntil);
    }
}
