package simpletimeimpl;

import simpletimeapi.Duration;
import simpletimeapi.Time;

public class SimpleTimeImpl implements Time {
    private   int totalTimeInMins;

    public SimpleTimeImpl(int hours, int minutes) {
        this.totalTimeInMins = hours * 60 + minutes;

    }

    @Override
    public Time addTime(Time t) {

        int hours = getHours() + t.getHours();
        int minutes = getMinutes() + t.getMinutes();

        return new SimpleTimeImpl(hours, minutes);
    }

    @Override
    public Time addTime(int minutes) {
        this.totalTimeInMins += minutes;
        var hrsConverted = this.totalTimeInMins / 60;
        var minsConverted = this.totalTimeInMins % 60;


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
            return -1;
        } else if (this.totalTimeInMins < otherTotalMins) {
            return 1;
        }
        return 0;
    }

    @Override
    public Duration until(Time other) {
        var hoursUntil = Math.abs(this.getHours() - other.getHours());
        var minutesUntil = Math.abs(this.getMinutes() - other.getMinutes());

        return new SimpleDurationImpl(hoursUntil, minutesUntil);
    }
}
