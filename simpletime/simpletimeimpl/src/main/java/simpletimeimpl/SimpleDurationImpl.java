package simpletimeimpl;

import simpletimeapi.Duration;

public class SimpleDurationImpl implements Duration {
    private int minutes;
    private int hours;

    public SimpleDurationImpl(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    @Override
    public Duration plus(Duration duration) {
        return new SimpleDurationImpl(duration.getHours() + this.hours, duration.getMinutes() + this.minutes);
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
    public int asMinutes() {
        int hoursToMinutes = this.hours / 60;

        return hoursToMinutes + this.minutes;
    }

    @Override
    public int compareTo(Duration o) {
        return 0;
    }
}
