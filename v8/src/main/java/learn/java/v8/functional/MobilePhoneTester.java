package learn.java.v8.functional;

import learn.java.domain.ecommerce.MobilePhone;
import learn.java.domain.ecommerce.Product;

public class MobilePhoneTester {
    public static boolean check(Product product) {
        MobilePhone mb = (MobilePhone) product;
        return mb.getScreenSize() > 5;
    }
}
