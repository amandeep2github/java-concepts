package learn.java.v8.functional;

import learn.java.domain.ecommerce.Product;

public interface MyPredicate<T> {
    boolean check(T t);
}
