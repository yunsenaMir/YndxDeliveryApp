package delivery.app.com.services;

import delivery.app.com.enums.TrafficCongestion;

public class DeliveryCalculationService {
    public static void main(String[] args) {
        System.out.println(calculateDeliveryPrice(31, true, true, TrafficCongestion.VERY_HIGH_TRAFFIC));
    }

    public static int calculateDeliveryPrice(int distance, boolean isHeavy, boolean isFragile, TrafficCongestion trafficCongestion) {
        if (distance <= 0)
            throw new NumberFormatException("Расстояние должно быть больше 0");

        if (distance > 30 && isFragile)
            throw new RuntimeException("Нельзя отправить хрупкий груз на расстояние больше 30 км");

        int totalSum = calculateDistanceFactor(distance);
        totalSum += isHeavy ? 200 : 100;
        totalSum += isFragile ? 300 : 0;
        totalSum = (int) Math.ceil(totalSum * trafficCongestion.getValue());
        return Math.max(totalSum, 400);
    }

    private static int calculateDistanceFactor(int distance) {
        if (distance <= 2)
            return 50;
        else if (distance <= 10)
            return 100;
        else if (distance <= 30)
            return 200;
        else
            return 300;
    }
}
