package learn.java.v8.functional;

import learn.java.domain.ecommerce.Product;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class QualityControl {

    public QualityControl() {
    }

    public List<Product> execute(List<Product> products, final Predicate<Product> testCondition) {
        List<Product> passed = products.stream().filter(product -> testCondition.test(product)).collect(Collectors.toList());
        System.out.printf("Total Products %d", products.size());
        System.out.printf("Products passed %d", passed.size());
        return passed;
    }
}
