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
}
