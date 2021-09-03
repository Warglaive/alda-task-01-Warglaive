package simpletimeimpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SimpleTimeImplTest {
    private int defaultHour = 1;
    private int defaultMin = 1;

    private SimpleTimeImpl time;

    @BeforeEach
    void setUp() {
        this.time = new SimpleTimeImpl(this.defaultHour, this.defaultMin);
    }

    /**
     * test if time is added properly
     */
    @Test
    void addTimeTest() {
        var toBeAdded = new SimpleTimeImpl(1, 1);
        var actual = this.time.addTime(toBeAdded);
        var expected = new SimpleTimeImpl(2, 2);
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    /**
     * test if time is added properly
     */
    @Test
    void addTimeMins() {
        int addMins = 5;
        var actual = this.time.addTime(addMins);
        var expected = new SimpleTimeImpl(2, 2);
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void compareToLessTest() {
        var first = new SimpleTimeImpl(111, 1);
        var other = new SimpleTimeImpl(2, 2);
        assertThat(first.compareTo(other)).isEqualTo(-1);
    }
}
