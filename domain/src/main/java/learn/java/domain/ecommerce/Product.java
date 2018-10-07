package learn.java.domain.ecommerce;

import java.util.UUID;

public class Product {
    private String id;

    public Product() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public boolean check(){
        return true;
    }

}
