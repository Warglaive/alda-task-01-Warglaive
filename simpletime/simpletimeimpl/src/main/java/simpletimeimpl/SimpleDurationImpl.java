package simpletimeimpl;

import simpletimeapi.Duration;

import java.util.Objects;

public class SimpleDurationImpl implements Duration {
    /*   private int minutes*/;
    /*   private int hours;*/
    private final int totalTimeInMins;

    public SimpleDurationImpl(int hours, int minutes) {
        this.totalTimeInMins = hours * 60 + minutes;

        if (this.totalTimeInMins < 0) {
            throw new IllegalArgumentException("Total minutes can NOT be lower than 0");
        } else if (this.totalTimeInMins > 24 * 60) {
            throw new IllegalArgumentException("Total minutes can NOT be bigger than 24*60");
        }
    }

    @Override
    public Duration plus(Duration duration) {
        return new SimpleDurationImpl(duration.getHours() + this.getHours(), duration.getMinutes() + this.getMinutes());
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
    public int asMinutes() {
        return totalTimeInMins;
    }

    @Override
    public int compareTo(Duration o) {
        //TODO: FIX
        int firstTotalMins = this.getHours() * 60 + this.getMinutes();
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
        return totalTimeInMins == that.totalTimeInMins;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalTimeInMins);
    }

    @Override
    public String toString() {
        return "SimpleDurationImpl{" +
                "totalTimeInMins=" + totalTimeInMins +
                ", minutes}";
    }

    /*public void betweenTimes(){
        this.totalTimeInMins
    }*/
}
