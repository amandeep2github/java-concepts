package learn.java.domain.ecommerce;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Order {
    private static Set<String> collectionElements;
    private long id;
    private String itemName;
    private double rate;
    private double units;
    private String measurementUnit;

    static {
        collectionElements = new HashSet<>();
        collectionElements.add("ABC");
        collectionElements.add("BCD");
        collectionElements.add("CCD");
        collectionElements.add("DEF");
        collectionElements.add("ELE");

    }

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

    public double getDerivedUnits(){
        if(collectionElements.contains("CCD"))
            return units;
        return units;
    }

    public static void main(String[] args){
        Order order = new Order(1, "Mobile", 10, 10, "none");
        Instant start = Instant.now();
        start.toEpochMilli();
//        System.out.println(start);
        IntStream.range(1, 5).forEach(value -> order.getUnits());
        Instant end = Instant.now();
        System.out.println(end.toEpochMilli()-start.toEpochMilli());
    }

}
