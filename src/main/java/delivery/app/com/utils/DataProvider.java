package delivery.app.com.utils;

import delivery.app.com.enums.TrafficCongestion;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class DataProvider {

    public static Stream<Arguments> provideDeliveryServiceCalculationParameters() {
        return Stream.of(
                Arguments.of(1, true, true, TrafficCongestion.OTHER, 550),
                Arguments.of(1, true, true, TrafficCongestion.VERY_HIGH_TRAFFIC, 880),
                Arguments.of(1, true, true, TrafficCongestion.ELEVATED_TRAFFIC, 660),
                Arguments.of(9, false, true, TrafficCongestion.ELEVATED_TRAFFIC, 600),
                Arguments.of(9, true, true, TrafficCongestion.HIGH_TRAFFIC, 840),
                Arguments.of(9, true, true, TrafficCongestion.VERY_HIGH_TRAFFIC, 960),
                Arguments.of(10, true, true, TrafficCongestion.HIGH_TRAFFIC, 840),
                Arguments.of(10, true, true, TrafficCongestion.ELEVATED_TRAFFIC, 720),
                Arguments.of(10, true, true, TrafficCongestion.OTHER, 600),
                Arguments.of(11, true, true, TrafficCongestion.HIGH_TRAFFIC, 980),
                Arguments.of(11, false, true, TrafficCongestion.OTHER, 600),
                Arguments.of(11, true, false, TrafficCongestion.ELEVATED_TRAFFIC, 480),
                Arguments.of(11, true, true, TrafficCongestion.VERY_HIGH_TRAFFIC, 1120),
                Arguments.of(29, false, false, TrafficCongestion.HIGH_TRAFFIC, 420),
                Arguments.of(29, true, true, TrafficCongestion.OTHER, 700),
                Arguments.of(29, true, true, TrafficCongestion.ELEVATED_TRAFFIC, 840),
                Arguments.of(29, true, true, TrafficCongestion.VERY_HIGH_TRAFFIC, 1120),
                Arguments.of(30, false, false, TrafficCongestion.HIGH_TRAFFIC, 420),
                Arguments.of(30, true, true, TrafficCongestion.OTHER, 700),
                Arguments.of(30, true, true, TrafficCongestion.ELEVATED_TRAFFIC, 840),
                Arguments.of(30, true, true, TrafficCongestion.VERY_HIGH_TRAFFIC, 1120),
                Arguments.of(31, false, false, TrafficCongestion.HIGH_TRAFFIC, 560),
                Arguments.of(100, false, false, TrafficCongestion.HIGH_TRAFFIC, 560)
        );
    }
}
