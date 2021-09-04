package simpletimeimpl;

import simpletimeapi.Duration;

import java.util.Objects;

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
        int hoursToMinutes = this.hours * 60;
        return hoursToMinutes + this.minutes;
    }

    @Override
    public int compareTo(Duration o) {
        //TODO: FIX
        int firstTotalMins = this.hours * 60 + this.minutes;
        int otherTotalMins = o.getHours() * 60 + o.getMinutes();

        if (firstTotalMins > otherTotalMins) {
            return 1;
        } else if (firstTotalMins < otherTotalMins) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleDurationImpl that = (SimpleDurationImpl) o;
        return minutes == that.minutes && hours == that.hours;
    }

    @Override
    public int hashCode() {
        return Objects.hash(minutes, hours);
    }
}
