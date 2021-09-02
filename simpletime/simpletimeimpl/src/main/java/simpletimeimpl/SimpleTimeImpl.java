package simpletimeimpl;

import simpletimeapi.Duration;
import simpletimeapi.Time;

public class SimpleTimeImpl implements Time {
    private int minutes;
    private int hours;

    SimpleTimeImpl(int minutes, int hours) {
        this.minutes = minutes;
        this.hours = hours;
    }

    @Override
    public Time addTime(Time t) {
        return null;
    }

    @Override
    public Time addTime(int minutes) {
        return null;
    }

    @Override
    public int getHours() {
        return 0;

    }

    @Override
    public int getMinutes() {
        return 0;
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
