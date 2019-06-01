package learn.java.domain.ecommerce;

public class Order {
    private long id;
    private String itemName;
    private double rate;
    private double units;
    private String measurementUnit;

    public Order(long id, String itemName, double rate, double units, String measurementUnit) {
        this.id = id;
        this.itemName = itemName;
        this.rate = rate;
        this.units = units;
        this.measurementUnit = measurementUnit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getUnits() {
        return units;
    }

    public void setUnits(double units) {
        this.units = units;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }
}
