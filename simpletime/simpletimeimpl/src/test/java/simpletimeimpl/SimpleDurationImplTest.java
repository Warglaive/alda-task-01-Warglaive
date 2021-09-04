package simpletimeimpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleDurationImplTest {
    private int defaultHour = 1;
    private int defaultMin = 1;

    private SimpleDurationImpl duration;

    @BeforeEach
    void setUp() {
        this.duration = new SimpleDurationImpl(this.defaultHour, this.defaultMin);
    }

    /**
     * test if time is added properly
     */
    @Test
    void plus() {
        SimpleDurationImpl tempDuration = new SimpleDurationImpl(1, 1);
        SimpleDurationImpl actual = (SimpleDurationImpl) tempDuration.plus(tempDuration);
        var expected = new SimpleDurationImpl(2, 2);
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void compareToLessTest() {
        var first = new SimpleDurationImpl(111, 1);
        var other = new SimpleDurationImpl(2, 2);
        assertThat(first.compareTo(other)).isEqualTo(1);
    }

    @Test
    void compareToMoreTest() {
        var first = new SimpleDurationImpl(0, 600);
        var other = new SimpleDurationImpl(9, 59);
        assertThat(first.compareTo(other)).isEqualTo(1);
    }

    @Test
    void compareToEqualTest() {
        var first = new SimpleDurationImpl(2, 2);
        var other = new SimpleDurationImpl(2, 2);
        assertThat(first.compareTo(other)).isEqualTo(0);
    }

    @Test
    void asMinutesTest() {
        var first = new SimpleDurationImpl(2, 2);
        int expectedTime = 122;
        assertThat(first.asMinutes()).isEqualTo(expectedTime);
    }

    @Test
    void getHours() {
        assertThat(this.duration.getHours()).isEqualTo(1);
    }


    @Test
    void getMinutes() {
        assertThat(this.duration.getMinutes()).isEqualTo(1);
    }

}
