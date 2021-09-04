package simpletimeimpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import simpletime.APFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class APFactoryTest {

    private APFactory factory;

    @BeforeEach
    void setUp() {
        this.factory = new APFactory();
    }

    @Test
    void createTime() {
        var time = this.factory.createTime(1, 1);
        assertThat(time).isExactlyInstanceOf(SimpleTimeImpl.class);
    }

    @Test
    void createDuration() {
        var duration = this.factory.createDuration(1, 1);
        assertThat(duration).isExactlyInstanceOf(SimpleDurationImpl.class);
    }

    @Test
    void createDurationFromMins() {
        var duration = this.factory.createDuration(135);
        assertThat(duration).isExactlyInstanceOf(SimpleDurationImpl.class);

    }
}
