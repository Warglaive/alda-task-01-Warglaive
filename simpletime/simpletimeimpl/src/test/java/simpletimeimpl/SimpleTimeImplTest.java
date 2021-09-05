package simpletimeimpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalTime;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;


public class SimpleTimeImplTest {


    private SimpleTimeImpl time;

    @BeforeEach
    void setUp() {
        this.time = new SimpleTimeImpl(0, 0);
    }

    /**
     * test if time is added properly
     */
    @Test
    void addTimeTest() {
        var toBeAdded = new SimpleTimeImpl(1, 1);
        var actual = this.time.addTime(toBeAdded);
        var expected = new SimpleTimeImpl(1, 1);
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    /**
     * test if time is added properly
     */
    @Test
    void addTimeMins() {
        int addMins = 5;
        var actual = this.time.addTime(addMins);
        var expected = new SimpleTimeImpl(0, addMins);
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void compareToLessTest() {
        var first = new SimpleTimeImpl(3, 1);
        var other = new SimpleTimeImpl(2, 2);
        /*assertThat(first.compareTo(other)).isEqualTo(-1);*/
        assertThat(first.compareTo(other)).isEqualTo(1);
    }

    @Test
    void compareToMoreTest() {
        var first = new SimpleTimeImpl(1, 1);
        var other = new SimpleTimeImpl(2, 2);
        /*assertThat(first.compareTo(other)).isEqualTo(1);*/
        assertThat(first.compareTo(other)).isEqualTo(-1);
    }

    @Test
    void compareToEqualTest() {
        var first = new SimpleTimeImpl(2, 2);
        var other = new SimpleTimeImpl(2, 2);
        assertThat(first.compareTo(other)).isEqualTo(0);
    }

    @Test
    void untilTest() {
        var time = new SimpleTimeImpl(12, 0);
        var expectedDuration = new SimpleDurationImpl(0, 30);
        //returns 30 mins
        var actualDuration = time.until(new SimpleTimeImpl(12, 30));
        assertThat(actualDuration).usingRecursiveComparison().isEqualTo(expectedDuration);
    }

    //Fields testing
    @Test
    void getHours() {
        assertThat(this.time.getHours()).isEqualTo(0);
    }

    @Test
    void getMinutes() {
        assertThat(this.time.getMinutes()).isEqualTo(0);
    }

    @Test
    void equalsTest() {
        var first = new SimpleTimeImpl(2, 2);
        var other = new SimpleTimeImpl(2, 2);
        assertThat(first.equals(other)).isTrue();
    }

    @Test
    void hashCodeTest() {
        var first = new SimpleTimeImpl(2, 2);
        assertThat(first.hashCode()).isEqualTo(Objects.hash(first.asMinutes()));
    }

    @Test
    void toStringTest() {
        var first = new SimpleTimeImpl(2, 2);
        assertThat(first.toString()).isEqualTo(LocalTime.MIN.plus(
                java.time.Duration.ofMinutes(first.asMinutes())
        ).toString());


       /* return LocalTime.MIN.plus(
                java.time.Duration.ofMinutes( first.asMinutes() )
        ).toString();*/
    }

    @Test
    void isBefore() {
        var before = new SimpleTimeImpl(1, 2);
        var after = new SimpleTimeImpl(2, 1);
        assertThat(before.isBefore(after)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"1, 2, 2, 1", "1, 1, 1, 1"})
    void isBeforeOrEqual(int firstHours, int firstMinutes, int lastHours, int lastMinutes) {
        var before = new SimpleTimeImpl(firstHours, firstMinutes);
        var after = new SimpleTimeImpl(lastHours, lastMinutes);
        assertThat(before.isBeforeOrEqual(after)).isTrue();
    }

    @Test
    void betweenTimes() {
        var first = new SimpleTimeImpl(1, 30);
        var last = new SimpleTimeImpl(2, 0);
        //expected result = 30 mins
        var expected = new SimpleDurationImpl(0, 30);
        //
        var time = new SimpleTimeImpl(1, 1);
        assertThat(time.betweenTimes(first, last)).isEqualTo(expected);
    }
}
