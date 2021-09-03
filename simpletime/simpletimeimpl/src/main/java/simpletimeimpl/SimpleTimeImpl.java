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
        return null;
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
    public Duration until(Time other) {
        return null;
    }

    @Override
    public int compareTo(Time o) {
        return 0;
    }
}
