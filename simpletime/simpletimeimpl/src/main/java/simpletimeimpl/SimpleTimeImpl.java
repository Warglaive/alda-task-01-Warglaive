package simpletimeimpl;

import simpletimeapi.Duration;
import simpletimeapi.Time;

import java.time.LocalTime;
import java.util.Objects;

public class SimpleTimeImpl implements Time {
    final private int totalTimeInMins;

    public SimpleTimeImpl(int hours, int minutes) {
        this.totalTimeInMins = hours * 60 + minutes;
        if (this.totalTimeInMins < 0) {
            throw new IllegalArgumentException("Total minutes can NOT be lower than 0");
        } else if (this.totalTimeInMins > 24 * 60) {
            throw new IllegalArgumentException("Total minutes can NOT be bigger than 24*60");
        }
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
                java.time.Duration.ofMinutes( totalTimeInMins )
        ).toString();
      //  return this.getHours() + ":" + this.getMinutes();
    }
}
