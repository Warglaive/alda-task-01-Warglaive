package simpletimeimpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        assertThat(first.compareTo(other)).isEqualTo(-1);
    }

    @Test
    void compareToMoreTest() {
        var first = new SimpleTimeImpl(1, 1);
        var other = new SimpleTimeImpl(2, 2);
        assertThat(first.compareTo(other)).isEqualTo(1);
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
                java.time.Duration.ofMinutes( first.asMinutes() )
        ).toString());


       /* return LocalTime.MIN.plus(
                java.time.Duration.ofMinutes( first.asMinutes() )
        ).toString();*/
    }
}
