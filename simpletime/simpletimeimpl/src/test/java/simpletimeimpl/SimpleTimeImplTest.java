package simpletimeimpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SimpleTimeImplTest {
    private int defaultHour = 0;
    private int defaultMin = 0;

    SimpleTimeImpl time;

    @BeforeEach
    void setUp() {
        this.time = new SimpleTimeImpl(this.defaultHour, this.defaultMin);
    }

    /**
     * test if time is added properly
     */
    @Test
    void addTime() {
        var toBeAdded = new SimpleTimeImpl(1, 1);
        this.time.addTime(toBeAdded);
        assertThat(this.time).isLessThan(new SimpleTimeImpl(2, 2));
    }
}
