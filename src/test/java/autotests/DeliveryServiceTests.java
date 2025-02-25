package autotests;

import delivery.app.com.enums.TrafficCongestion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static delivery.app.com.services.DeliveryCalculationService.*;

public class DeliveryServiceTests {

    /*
       Тест на проверку расчета общей стоимости доставки с корректными данными.
    */
    @ParameterizedTest
    @MethodSource("delivery.app.com.utils.DataProvider#provideDeliveryServiceCalculationParameters")
    public void totalSumDeliveryServiceTest(int distance, boolean isHeavy, boolean isFragile, TrafficCongestion trafficCongestion, int expectedTotalSum) {
        Assertions.assertEquals(calculateDeliveryPrice(distance, isHeavy, isFragile, trafficCongestion), expectedTotalSum);
    }

    /*
       Тест на проверку расчета общей стоимости доставки с корректными данными.
    */
    @Test
    public void totalSumWhenFinalSumIsLowerThanMinimumTest() {
        Assertions.assertEquals(calculateDeliveryPrice(1, true, false, TrafficCongestion.HIGH_TRAFFIC), 400);
    }

    /*
       Тест на проверку расчета общей стоимости доставки для случая, когда груз хрупкий и расстояние больше 30.
    */
    @Test
    public void deliveryServiceExceptionWhenFragileAndDistanceIsMoreThan30Test() {
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            calculateDeliveryPrice(31, true, true, TrafficCongestion.HIGH_TRAFFIC);
        });

        Assertions.assertEquals("Нельзя отправить хрупкий груз на расстояние больше 30 км", thrown.getMessage());
    }

    /*
       Тест на проверку расчета общей стоимости доставки с некорректным форматом расстояния.
    */
    @Test
    public void deliveryServiceDistanceFormatExceptionTest() {
        NumberFormatException thrown = Assertions.assertThrows(NumberFormatException.class, () -> {
            calculateDeliveryPrice(-5, true, true, TrafficCongestion.HIGH_TRAFFIC);
        });

        Assertions.assertEquals("Расстояние должно быть больше 0", thrown.getMessage());
    }
}
