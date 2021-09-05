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

      /*  if (this.totalTimeInMins > otherTotalMins) {
            return -1;
        } else if (this.totalTimeInMins < otherTotalMins) {
            return 1;
        }
        return 0;*/
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
                java.time.Duration.ofMinutes( totalTimeInMins )
        ).toString();
      //  return this.getHours() + ":" + this.getMinutes();
    }

    @Override
    public boolean isBefore(Time other) {
        return Time.super.isBefore(other);
    }

    @Override
    public boolean isBeforeOrEqual(Time other) {
        return Time.super.isBeforeOrEqual(other);
    }
  /*  public Duration betweenTimes(SimpleTimeImpl first, SimpleTimeImpl last) {
        //1. make both to mins, substract smaller from bigger, make to hrs and mins again
        int firstTotalMins = first.asMinutes();
        int lastTotalMins = last.asMinutes();
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

        int hour = durationAsMins / 60;
        int mins = durationAsMins % 60;

        return new SimpleDurationImpl(hour, mins);

    }*/
  @Override
  public Duration until(Time other) {
   /*   var hoursUntil = Math.abs(this.getHours() - other.getHours());
      var minutesUntil = Math.abs(this.getMinutes() - other.getMinutes());

      return new SimpleDurationImpl(hoursUntil, minutesUntil);*/


      //1. make both to mins, substract smaller from bigger, make to hrs and mins again
      int firstTotalMins = this.asMinutes();
      int lastTotalMins = other.asMinutes();
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

      int hour = durationAsMins / 60;
      int mins = durationAsMins % 60;

      return new SimpleDurationImpl(hour, mins);
  }
}
