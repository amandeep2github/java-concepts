package learn.java.domain.ecommerce;

public class MobilePhone extends Product {
    private float screenSize;

    public MobilePhone(float screenSize) {
        this.screenSize = screenSize;
    }

    public float getScreenSize() {
        return screenSize;
    }


}
