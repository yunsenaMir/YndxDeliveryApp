package delivery.app.com.enums;

public enum TrafficCongestion {

    VERY_HIGH_TRAFFIC("Очень высокая загруженность", 1.6),

    HIGH_TRAFFIC("Высокая загруженность", 1.4),

    ELEVATED_TRAFFIC("Повышенная загруженность", 1.2),
    OTHER("Все остальные случаи", 1);

    private double value;

    TrafficCongestion(String description, double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
